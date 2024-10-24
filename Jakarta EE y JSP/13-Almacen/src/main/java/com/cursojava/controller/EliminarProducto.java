package com.cursojava.controller;

import java.io.IOException;

import com.cursojava.service.AlmacenService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EliminarProducto
 */
public class EliminarProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nombre = request.getParameter("nombre");

		AlmacenService.eliminarProducto(AlmacenService.getUnProducto(nombre));
		RequestDispatcher dispatcher = request.getRequestDispatcher("/ListarProductos.jsp");
		dispatcher.forward(request, response);
	}

}
