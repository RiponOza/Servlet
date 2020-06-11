package com.ripon.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		
		HttpSession session = request.getSession();
		session.setAttribute("UserName", name);
		
		response.sendRedirect("second");
	}

}
