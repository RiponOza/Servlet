package com.ripon.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/second")
public class SecondServlet extends HttpServlet {


	private String name;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		Cookie cookies[] = request.getCookies();
		
		for(Cookie cookie: cookies) {
			if (cookie.getName().equals("UserName")) {
				name = cookie.getValue();
			}
		}

		PrintWriter out = response.getWriter();
		out.print("This is second Servlet" + "<br>");

		out.print("Hello " + name + "<br>");
	}

}
