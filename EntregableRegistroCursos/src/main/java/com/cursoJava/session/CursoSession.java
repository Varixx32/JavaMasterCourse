package com.cursoJava.session;

/**
 * Servlet implementation class CursoSession
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class CursoSession extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String curso = request.getParameter("curso");

        // Obtener la lista de cursos de la sesión (o crearla si no existe)
        List<String> cursos = (List<String>) session.getAttribute("cursos");
        if (cursos == null) {
            cursos = new ArrayList<>();
        }
        cursos.add(curso);

        // Guardar la lista de cursos en la sesión
        session.setAttribute("cursos", cursos);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + session.getAttribute("nombre") + ", estas matriculado en los cursos siguientes:</h1>");
        out.println("<ul>");
        for (String c : cursos) {
            out.println("<li>" + c + "</li>");
        }
        out.println("</ul>");
        out.println("<br><a href='formularioCurso.html'>Matricularse en otro curso</a>");
        out.println("</body></html>");
    }
}

