package com.ripon.SMTP.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ripon.SMTP.beans.MailSender;

@WebServlet("/mailSender")
public class MailSenderServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private String to;
	private String msg;
	private String subject;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		MailSender ms = new MailSender();
		
		msg = request.getParameter("message");
		to = request.getParameter("DestinationEmailAddress");
		subject = request.getParameter("Subject");
		
		PrintWriter out = response.getWriter();
		
		try {
			ms.setMsg(msg);
			ms.setMailSubject(subject);
			ms.setTo(to);
			ms.sendMail();
			out.print("Email sent successfully");
		}
		catch(Exception e) {
			out.print("Error Occured. Try again.");
			e.printStackTrace();
		}
	}

}
