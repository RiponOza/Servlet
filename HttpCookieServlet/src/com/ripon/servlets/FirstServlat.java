package com.ripon.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/first")
public class FirstServlat extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private String name;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		out.print("This is first Servlet" + "<br>");
		
		name = request.getParameter("name");
		
		Cookie cookie = new Cookie("UserName", name.toString());
		response.addCookie(cookie);
		
		response.sendRedirect("second");
	}

}
