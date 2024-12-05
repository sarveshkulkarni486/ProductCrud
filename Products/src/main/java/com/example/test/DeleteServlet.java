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

import com.example.beans.Product;
import com.example.services.ShowProductImpl;
import com.example.services.ShowProductServices;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession ses = request.getSession();
		String role = (String)ses.getAttribute("role");
		if(role!=null && role.equals("admin")) {
			int pid = Integer.parseInt(request.getParameter("pid"));
			ShowProductServices pser = new ShowProductImpl();
			Product p = pser.getById(pid);
			if(p!=null) {
				boolean res = pser.deleteProduct(pid);
				if(res) {
					request.setAttribute("message", "Product delete successfully..");
					RequestDispatcher rd = request.getRequestDispatcher("displayprod");
					rd.forward(request, response);
				}
				else {
					request.setAttribute("message", "Unable to delete product");
					RequestDispatcher rd = request.getRequestDispatcher("displayprod");
					rd.forward(request, response);
				}
			}
		}
	}

}
