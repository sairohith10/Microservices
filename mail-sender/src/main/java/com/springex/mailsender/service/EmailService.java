package com.springex.mailsender.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.springex.mailsender.model.EmailDetails;

@Service
public class EmailService {
	@Value("${app.sender.mail}")
	private String senderEmail;
    
	@Autowired 
	private JavaMailSender mailSender;
	
	public String sendMail(EmailDetails emailDetails) {
	
		
		try {
			SimpleMailMessage message = new SimpleMailMessage();
			message.setFrom(senderEmail);
			message.setTo(emailDetails.getReceiverMail());
			message.setText(emailDetails.getBody());
			message.setSubject(emailDetails.getSubject());
			
			mailSender.send(message);
			return "Email sent successfully...";
			
		}
		catch(Exception e) {
			return "Email sent fail...";
		}
	}

}
