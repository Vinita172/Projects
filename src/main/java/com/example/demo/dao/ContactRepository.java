package com.example.demo.dao;



import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entities.Contact;
import com.example.demo.entities.User;

public interface ContactRepository extends JpaRepository<Contact, Integer>  {
     //pagination
	 @Query("from Contact as c where c.user.id=:userid")
	 //currentpage-Page
	 //Contact per page -5
	 public Page<Contact> findContactsByUser(@Param("userid") int userid,Pageable pePageable);
	 
	 //search
	 public List<Contact> findByNameContainingAndUser(String name,User user);
}
