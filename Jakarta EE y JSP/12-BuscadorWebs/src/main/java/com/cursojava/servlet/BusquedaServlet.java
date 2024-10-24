package com.cursojava.servlet;

import java.io.IOException;
import java.util.ArrayList;

import com.cursojava.model.Website;
import com.cursojava.service.BusquedaService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class BusquedaServlet
 */
public class BusquedaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tematica = request.getParameter("tematica");
		ArrayList<Website> websites = BusquedaService.buscar(tematica);
		
		if(!websites.isEmpty()) {
			HttpSession session = request.getSession();
		    session.setAttribute("websites", websites);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WebsiteDisplayer");
			dispatcher.forward(request, response);
		}else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/SearchError");
			dispatcher.forward(request, response);
		}
		
	}

}
