package com.example.test;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

import com.example.beans.User;
import com.example.services.LoginServices;
import com.example.services.LoginServicesImpl;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	LoginServices lserv = new LoginServicesImpl();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String username = request.getParameter("email");
		String password = request.getParameter("password");
		User u = lserv.validate(username, password);
		RequestDispatcher rd;
		if(u.getRole()!=null && u.getRole().equals("admin")) {
			HttpSession session = request.getSession();
			session.setMaxInactiveInterval(1800);
			session.setAttribute("username", username);
			session.setAttribute("role", u.getRole());
			request.setAttribute("message", "Welcome"+username);
			rd = request.getRequestDispatcher("displayprod");
			out.println("Session created");
			System.out.println(session.getAttribute("role"));
			rd.forward(request, response);
		}
		else {
			request.setAttribute("message", "unable to login you do not have authorization:");
			rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}
	}

}
