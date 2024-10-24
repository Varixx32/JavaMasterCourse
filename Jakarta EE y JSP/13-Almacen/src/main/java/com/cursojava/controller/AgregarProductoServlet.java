package com.cursojava.controller;

import java.io.IOException;

import com.cursojava.model.Producto;
import com.cursojava.model.Producto.Categoria;
import com.cursojava.service.AlmacenService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProductoServlet
 */
public class AgregarProductoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre = request.getParameter("nombre");
		Categoria categoria = AlmacenService.parsearCategoria(request.getParameter("categoria"));
		double precio = Double.valueOf(request.getParameter("precio"));
		int stock = Integer.valueOf(request.getParameter("stock"));
		
		AlmacenService.agregarAProductos(new Producto (nombre, precio, stock, categoria));
		RequestDispatcher dispatcher = request.getRequestDispatcher("/ListarProductos.jsp");
		dispatcher.forward(request, response);
	}
}