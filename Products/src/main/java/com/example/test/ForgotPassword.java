package com.example.test;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import com.example.beans.User;
import com.example.services.LoginServices;
import com.example.services.LoginServicesImpl;

/**
 * Servlet implementation class ForgotPassword
 */
@WebServlet("/forgot")
public class ForgotPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	response.setContentType("text/html");
    	PrintWriter out = response.getWriter();
    	String username = request.getParameter("username");
    	String password =request.getParameter("password");
    	User u = new User(username, password);
    	LoginServices lserv = new LoginServicesImpl();
    	boolean flag = lserv.exists(u);
    	RequestDispatcher rd;
    	if(flag) {
    		request.setAttribute("message", "Password update:");
    		rd = request.getRequestDispatcher("login.jsp");
    		rd.forward(request, response);
    	}
    	else {
    		request.setAttribute("message", "User did not exists or not found..");
    		rd = request.getRequestDispatcher("forgot.jsp");
    		rd.forward(request, response);
    	}
	}

}
