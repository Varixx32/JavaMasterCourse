<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.cursojava.model.Producto" %>
<%@ page import="com.cursojava.service.AlmacenService" %>
<%@ page import="java.util.List" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Listado de Productos</title>
</head>
<body>
<h1>Listado de Productos Disponibles</h1>

<table>
    <thead>
        <tr>
            <th>Nombre</th>
            <th>Categoría</th>
            <th>Precio</th>
            <th>Stock</th>
            <th>Cantidad</th>
            <th>Confirmar</th>
        </tr>
    </thead>
    <tbody>
        <%
            List<Producto> productos = AlmacenService.getProductos();
            if (productos != null && !productos.isEmpty()) {
                for (Producto producto : productos) {
        %>
        <tr>
            <td><%= producto.getNombre() %></td>
            <td><%= producto.getCategoria() %></td>
            <td><%= producto.getPrecio() %></td>
            <td><%= producto.getStock() %></td>
            <td>
                <form action="AgregarAlPedidoServlet" method="post">
                    <input type="number" name="cantidad" min="1" max="<%= producto.getStock() %>" value="0" required>
                    <input type="hidden" name="nombre" value="<%= producto.getNombre() %>">
            </td>
            <td>
                    <input type="submit" value="Pedir">
                </form>
            </td>
        </tr>
        <%
                }
            } else {
        %>
        <tr>
            <td>No hay productos disponibles.</td>
        </tr>
        <%
            }
        %>
    </tbody>
</table>
<a href="ListarProductos.jsp">Volver al listado completo</a>
</body>
</html>
