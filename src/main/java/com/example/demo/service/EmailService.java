package com.example.demo.service;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Service;

@Service
public class EmailService {
 public boolean sendEmail(String subject,String message,String to) {
	 
	 boolean f=false;
	 String from="techsoftindia2018@gmail.com";
	 
	 //Variable for gmail
	 String host="smtp.gmail.com";
	 
	 //get the system properties
	 Properties properties=System.getProperties();
	 System.out.println("PROPERTIES "+properties);
	 
	 //setting important information to properties object
	 
	 //host set
	 properties.put("mail.smtp.host",host);
	 properties.put("mail.smtp.host","465");
	 properties.put("mail.smtp.host.ssl.enable", "true");
	 properties.put("mail.smtp.auth", "true");
	 
	 //Step 1:to get the Session Object...
	 Session session=Session.getInstance(properties,new Authenticator() {
		 @Override
		 protected PasswordAuthentication getPasswordAuthentication() {
			 return new PasswordAuthentication("techsoftindia2018@gmail.com", "123@SoftTech");
		 }
	 });
	 session.setDebug(true);
	 
	 //Step 2:compose the message [text,multi media]
	 MimeMessage m=new MimeMessage(session);
	 try {
		 //from email
		 m.setFrom(from);
		 
		 //adding recipient to message
		 m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
		 
		 //adding subject to message
		 m.setSubject(subject);
		 
		 //adding text to message
		 m.setContent(message, "text/html");
		 
		 //send
		 
		 //Step 3:send the message using Transport Class
		 Transport.send(m);
		 System.out.println("Sent Success................");
		 f=true;
		 
	 }catch (Exception e) {
		 e.printStackTrace();
	}
	 return f;
 }
}
