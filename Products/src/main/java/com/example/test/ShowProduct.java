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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.example.beans.Product;
import com.example.services.ShowProductImpl;
import com.example.services.ShowProductServices;

/**
 * Servlet implementation class ShowProduct
 */
@WebServlet("/showprod")
public class ShowProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession sess = request.getSession();
		String role = (String) sess.getAttribute("role");	
		if(role!=null && role.equals("admin")) {		
			int pid = Integer.parseInt(request.getParameter("pid"));
			String pname = request.getParameter("pname");
			int qty = Integer.parseInt(request.getParameter("qty"));
			double price = Double.parseDouble(request.getParameter("price"));
			String exp = request.getParameter("expdate");
			LocalDate ldt = LocalDate.parse(exp, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
			int cid = Integer.parseInt(request.getParameter("cid"));
			Product p = new Product(pid, pname, qty, price, ldt, cid);
			ShowProductServices spserv = new ShowProductImpl();
			boolean res = spserv.addProduct(p);
			if(res) {
				request.setAttribute("message", "Product added successfully");
				RequestDispatcher rd = request.getRequestDispatcher("displayprod");
				rd.forward(request, response);
			}
		}
		else {
			request.setAttribute("message", "Login as admin first:");
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}
	}
}
