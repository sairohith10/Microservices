package com.springex.mailsender.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springex.mailsender.model.EmailDetails;
import com.springex.mailsender.service.EmailService;

@RestController
public class EmailController {
   
	@Autowired
	EmailService emailService;
	
	@PostMapping("/")
	public String sendMail(@RequestBody EmailDetails emailDetails) {
		return emailService.sendMail(emailDetails);
	}
}
