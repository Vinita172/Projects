package com.example.demo.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.dao.ContactRepository;
import com.example.demo.dao.UserRepository;
import com.example.demo.entities.Contact;
import com.example.demo.entities.User;


@Controller
public class SearchController {
@Autowired
private UserRepository userRepository;

@Autowired 
private ContactRepository contactRepository;

//serach Handler
@GetMapping("/search{query}")
public ResponseEntity<?> search(@PathVariable("query") String query,Principal principal){
	System.out.println(query);
	User user=this.userRepository.getUserByUserName(principal.getName());
	List<Contact> contacts=this.contactRepository.findByNameContainingAndUser(query, user);
	return ResponseEntity.ok(contacts);
}
}
