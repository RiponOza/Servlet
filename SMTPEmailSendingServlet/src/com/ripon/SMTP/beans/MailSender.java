package com.ripon.SMTP.beans;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailSender {

	private String to;
	private String msg;
	private String subject;
	private Session session;
	private Properties properties;
	private String myAccount;
	private String password;

	// constructor
	public MailSender() {
		myAccount = "riponoja9@gmail.com";
		password = "**********";
		properties = new Properties();
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");

		session = Session.getInstance(properties, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {

				return new PasswordAuthentication(myAccount, password);
			}

		});

	}

	// setters
	public void setTo(String to) {
		this.to = to;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public void setMailSubject(String subject) {
		this.subject = subject;
	}

	// business method
	public void sendMail() {
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(myAccount));
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject(subject);
			message.setText(msg);

			// Send message
			Transport.send(message);
			System.out.println("message sent successfully....");

		} catch (MessagingException mex) {
			mex.printStackTrace();
		}
	}
}
