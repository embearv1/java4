package com.poly.option;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class AuthenticationMail {
	public void adminMail(HttpServletRequest req ,HttpServletResponse res,String mail,String title,String about) {
		final String userMail = "nguyenvanem05@gmail.com";
		final String pass="yourpass";
		Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", "587");
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.starttls.enable", "true");
		
		Session session = Session.getInstance(prop,  
			    new javax.mail.Authenticator() {  
		      protected PasswordAuthentication getPasswordAuthentication() {  
		    return new PasswordAuthentication(userMail,pass);  
		      }  
		    });  
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(mail));
			message.setRecipients(
					Message.RecipientType.TO, 
					InternetAddress.parse(mail));
			message.setSubject(title);
			message.setText(about);
			Transport.send(message);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}	
	}
	
}
