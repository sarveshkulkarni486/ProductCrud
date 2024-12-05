package com.example.test;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.example.beans.Product;
import com.example.services.ShowProductImpl;
import com.example.services.ShowProductServices;

/**
 * Servlet implementation class UpdateProduct
 */
@WebServlet("/update")
public class UpdateProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		int pid = Integer.parseInt(request.getParameter("pid"));
		String pname = request.getParameter("pname");
		int qty = Integer.parseInt(request.getParameter("qty"));
		double price = Double.parseDouble(request.getParameter("price"));
		String date = request.getParameter("expdate");
		LocalDate dt = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		int cid = Integer.parseInt(request.getParameter("cid"));
		ShowProductServices pserv = new ShowProductImpl();
		Product p = new Product(pid, pname, qty, price, dt, cid);
		boolean res = pserv.updateProduct(p);
		System.out.println(p);
		request.setAttribute("message", "Product updated successfully");
		RequestDispatcher rd = request.getRequestDispatcher("displayprod");
		rd.forward(request, response);
	}

}
