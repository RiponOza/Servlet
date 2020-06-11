package com.ripon.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/second")
public class SecondServlet extends HttpServlet {


	private String name;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		HttpSession session = request.getSession();
		name = (String) session.getAttribute("UserName");

		PrintWriter out = response.getWriter();
		out.print("This is second Servlet" + "<br>");
		
		out.print("Hello " + name + "<br>");
	}
	

}
