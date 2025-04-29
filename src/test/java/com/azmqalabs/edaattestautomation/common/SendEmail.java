package com.azmqalabs.edaattestautomation.common;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.testng.annotations.Test;

public class SendEmail {

	public static void sendEmailWithAttachment(String reportPath) throws MessagingException {

	    final String username = "dhruvakumar033@gmail.com";
	    final String password = "efqj ovcx qoqk xntk";

	    Properties props = new Properties();
	    props.put("mail.smtp.auth", true);
	    props.put("mail.smtp.starttls.enable", true);
	    props.put("mail.smtp.host", "smtp.gmail.com");
	    props.put("mail.smtp.port", "587");

	    Session session = Session.getInstance(props,
	            new javax.mail.Authenticator() {
	                protected PasswordAuthentication getPasswordAuthentication() {
	                    return new PasswordAuthentication(username, password);
	                }
	            });

	    try {

	        Message message = new MimeMessage(session);
	        message.setFrom(new InternetAddress("dhruvakumar033@gmail.com"));
	        message.setRecipients(Message.RecipientType.TO,
	                InternetAddress.parse("dhruvakumar033@gmail.com"));
	        message.setSubject("Testing Subject");
	        message.setText("PFA");

	        MimeMultipart multipart = new MimeMultipart();
	        MimeBodyPart attachmentPart = new MimeBodyPart();
	        String file = reportPath;
	        FileDataSource Source = new FileDataSource(file);
	        attachmentPart.setDataHandler(new DataHandler(Source));
	        attachmentPart.setFileName("Testreport.html");
	        multipart.addBodyPart(attachmentPart); 	
	        message.setContent(multipart);
	        System.out.println("Sending the email");
	        Transport.send(message);
	        System.out.println("Email sent successfully");

	    } catch (MessagingException e) {
	        e.printStackTrace();
	    }
	}
}
