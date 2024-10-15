<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <title>Tablas de Multiplicar 10x10</title>
</head>
<body>

<h2>Matriz 10x10 - Tablas de Multiplicar</h2>

<table>
    <%
        // Usamos dos bucles for para imprimir la matriz 10x10
        for (int i = 1; i <= 10; i++) {
            out.println("<tr>"); //Empieza la fila
            for (int j = 1; j <= 10; j++) {
                out.println("<td>" + (i * j) + "</td>");   // Rellena cada hueco de la fila
            }
            out.println("</tr>"); //Pasa a la siguiente fila
        }
    %>
</table>

</body>
</html>
