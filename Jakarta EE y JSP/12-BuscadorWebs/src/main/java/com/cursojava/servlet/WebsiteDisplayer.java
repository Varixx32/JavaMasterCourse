package com.cursojava.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import com.cursojava.model.Website;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class WebsiteDisplayer
 */
public class WebsiteDisplayer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		ArrayList<Website> websites= (ArrayList<Website>) session.getAttribute("websites");
		
		response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1> Estas son las paginas que cumplen con la tematica: " + request.getParameter("tematica") + "</h1>");
        out.println("<ul>");
        for (Website w : websites) {
        	  out.println("<li><a href='"+ w.getDireccion() + "'>"+ " " + w.getDireccion() + " " + "</a></li>");
        	  out.println("<p> Descripcion de la pagina: " + w.getDescrpicion() + "</p>");
        }
        out.println("</ul>");
        out.println("<br><a href='formularioPagina.html'>Hacer otra busqueda</a>");
        out.println("</body></html>");
	}

}
