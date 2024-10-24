<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<title>Agregar Producto</title>
</head>
<body>
	<h1>Agregar Producto</h1>

	<form action="AgregarProductoServlet" method="post">
		<p>Nombre:</p>
		<input type="text" id="nombre" name="nombre" required><br>

		<p>Categoria</p>
		<select id="categoria" name="categoria">
			<option value="ALIMENTOS">Alimentos</option>
			<option value="ELECTRONICA">Electrónica</option>
			<option value="ROPA">Ropa</option>
			<option value="HOGAR">Hogar</option>
			<option value="LIBROS">Libros</option>
		</select><br>

		<p>Precio</p>
		<input type="number" id="precio" name="precio" step="0.01" required><br>

		<p>Stock</p>
		<input type="number" id="stock" name="stock" required><br>

		<input type="submit" value="Agregar Producto">
	</form>
	<a href='ListarProductos.jsp'>Volver al inicio</a>
</body>
</html>
