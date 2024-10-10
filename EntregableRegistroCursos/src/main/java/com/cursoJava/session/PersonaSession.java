package com.cursoJava.session;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class PersonaSession
 */

public class PersonaSession extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombre = request.getParameter("nombre");

        // Guardar el nombre en la sesión
        HttpSession session = request.getSession();
        session.setAttribute("nombre", nombre);

       //Generamos el HTML 
        response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"UTF-8\">");
		out.println("<title>Persona registrada</title>");
		out.println("</head>");
		out.println("<body>");
		
		out.println("Nombre de la persona registrada: " + nombre);
	    out.println("<br><a href='formularioCurso.html'>Formulario del curso</a>");
	    
		out.println("</body>");
		out.println("</html>");
		out.close();
    }
}

