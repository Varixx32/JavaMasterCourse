package com.cursojava.controller;

import java.io.IOException;

import com.cursojava.model.Producto;
import com.cursojava.service.AlmacenService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AgregarAlPedidoServlet
 */
public class AgregarAlPedidoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombreProducto = request.getParameter("nombre");
		int cantidadPedida = Integer.valueOf(request.getParameter("cantidad"));
		
		Producto productoAgregado = AlmacenService.getUnProducto(nombreProducto); 
		productoAgregado.setStock(productoAgregado.getStock()-cantidadPedida);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/HacerPedido.jsp");
		dispatcher.forward(request, response);
	}

}
