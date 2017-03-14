package com.dss;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Servlet1")
public class Servlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public Servlet1() {
        super();
           }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		//welcome notes
		writer.println("This is First Servlet");
		writer.println("</br>");
		// Get Parameters
		request.getAttribute("uname");
		request.getAttribute("upass");
		// Create Http Session
		HttpSession session = request.getSession();
		// load the details
		session.setAttribute("uname",uname);
		session.setAttribute("upass",upass);
		// Forward the session to next Servlet or page
		RequestDispatcher dispatcher = request.getRequestDispatcher("login2.html");
		dispatcher.forward(request, response);
		
		
		
		
		
		
	}

}
