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

import com.example.beans.Product;
import com.example.services.ShowProductImpl;
import com.example.services.ShowProductServices;

/**
 * Servlet implementation class EditProduct
 */
@WebServlet("/editprod")
public class EditProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession ses = request.getSession();
		String role = (String)ses.getAttribute("role");
		if(role!=null && role.equals("admin")) {
			int pid = Integer.parseInt(request.getParameter("pid"));
			ShowProductServices pserv = new ShowProductImpl();
			Product p = pserv.getById(pid);
			if(p!=null) {
				request.setAttribute("Productdata", p);
				RequestDispatcher rd = request.getRequestDispatcher("updateform.jsp");
				rd.forward(request, response);
			}
		}
	}

}
