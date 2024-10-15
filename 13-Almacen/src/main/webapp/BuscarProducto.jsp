<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.cursojava.model.Producto"%>
<%@ page import="com.cursojava.service.AlmacenService"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Buscar un producto</title>
</head>
<body>
	<form action="BuscarProducto.jsp" method="post">
		<input type="text" name="busqueda"> <input type="submit"
			value="Buscar">
	</form>
	<h1>Producto buscado</h1>
	<table>
		<%
		Producto producto = AlmacenService.getUnProducto(request.getParameter("busqueda"));
		if (producto != null) {
		%>
		<thead>
			<tr>
				<th>Nombre</th>
				<th>Categoría</th>
				<th>Precio</th>
				<th>Stock</th>
				<th>Acciones</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td><%=producto.getNombre()%></td>
				<td><%=producto.getCategoria()%></td>
				<td><%=producto.getPrecio()%></td>
				<td><%=producto.getStock()%></td>
				<td><a
					href="ModificarProducto.jsp?nombre=<%=producto.getNombre()%>">Editar</a>
					<form action="EliminarProducto" method="post">
						<input type="hidden" name="nombre" value="<%=producto.getNombre()%>"> 
						<input type="submit" value="Eliminar">
					</form></td>
			</tr>
			<%
			} else {
			%>
			<tr>
				<td>El producto <%=request.getParameter("busqueda")%> no esta disponible </td>
			</tr>
			<%
				}
			%>
		</tbody>
	</table>
</body>
<a href="ListarProductos.jsp">Volver al listado completo</a>
</html>