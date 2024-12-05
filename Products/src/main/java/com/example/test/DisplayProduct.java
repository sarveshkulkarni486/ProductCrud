package com.example.test;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.example.beans.Product;
import com.example.services.ShowProductImpl;
import com.example.services.ShowProductServices;

/**
 * Servlet implementation class DisplayProduct
 */
@WebServlet("/displayprod")
public class DisplayProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		ShowProductServices pserv = new ShowProductImpl();
		List<Product> productlist = new ArrayList<Product>();
		HttpSession sess = request.getSession();
		String role = (String)sess.getAttribute("role");
		RequestDispatcher rd;
		if(role!=null && role.equals("admin")) {
			System.out.println(sess.getAttribute("role"));
			System.out.println(role);
			productlist = pserv.GetAll();
		//	productlist.stream().forEach(System.out::println);
			if(productlist!=null) {
				request.setAttribute("plist", productlist);
				rd = request.getRequestDispatcher("products.jsp");
				rd.forward(request, response);
			}
			else if(productlist==null) {
				request.setAttribute("msg", "product list is empty");
				rd = request.getRequestDispatcher("products.jsp");
				rd.forward(request, response);
			}

		}
		
		else {
			request.setAttribute("message", "Login as admin first:");
			rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}
	
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

}
