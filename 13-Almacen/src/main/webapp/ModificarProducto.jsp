<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.cursojava.model.Producto" %>
<%@ page import="com.cursojava.service.AlmacenService" %>
<%
    String nombre = request.getParameter("nombre");
    Producto producto = AlmacenService.getUnProducto(nombre); 
%>
<html>
<head>
    <title>Modificar Producto</title>
</head>
<body>
    <h1>Modificar <%= producto.getNombre() %></h1>
    <form action="ModificarProductoServlet" method="post">	
    	<input type="hidden" name="nombre" value="<%= producto.getNombre()%>">
        <p>Categoría:</p>
        <p>Categoria</p>
        <select id="categoria" name="categoria" value="<%=producto.getCategoria()%>">
            <option value="ALIMENTOS">Alimentos</option>
            <option value="ELECTRONICA">Electrónica</option>
            <option value="ROPA">Ropa</option>
            <option value="HOGAR">Hogar</option>
            <option value="LIBROS">Libros</option>
        </select><br>
        <p>Precio:</p>
        <input type="number" name="precio" step="0.01" value="<%= producto.getPrecio() %>"><br>
        <p>Stock:</p>
        <input type="number" name="stock" value="<%= producto.getStock() %>"><br>
        <input type="submit" value="Guardar Cambios">
    </form>
</body>
</html>
