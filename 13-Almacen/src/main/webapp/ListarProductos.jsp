<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.cursojava.model.Producto" %>
<%@ page import="com.cursojava.service.AlmacenService" %>
<html>
<head>
    <title>Listado de Productos</title>
</head>
<body>
//reboot de la pagina
 <form action="BuscarProducto.jsp" method="post">
	<input type="text" name="busqueda">
        <input type="submit" value="Buscar">
 </form>
    <h1>Listado de Productos</h1>
    <table>
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
                    
                    <a href="ModificarProducto.jsp?nombre=<%= producto.getNombre() %>">Editar</a>                 
                    <form action="EliminarProducto" method="post" style="display:inline;">
                        <input type="hidden" name="nombre" value="<%= producto.getNombre() %>">
                        <input type="submit" value="Eliminar">
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
    <a href="AgregarProductoForm.jsp">Agregar Producto</a>
    <a href="HacerPedido.jsp">Hacer un pedido</a>
</body>
</html>
