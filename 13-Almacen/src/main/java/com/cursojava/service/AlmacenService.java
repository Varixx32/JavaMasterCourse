package com.cursojava.service;

/*
 * La clase AlmacenService tiene una arrayList con todos los productos ademas de los metodos utilizados para la manipulación de estos datos.
 * @author: Victor Tercero
 * @version: 1.21
 */

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.cursojava.model.Producto;
import com.cursojava.model.Producto.Categoria;

public class AlmacenService {
	// ArrayList que hace de BBDD con datos de prueba precargados.
	private static ArrayList<Producto> productos = new ArrayList<>(
			List.of(new Producto("Manzana", 0.50, 100, Producto.Categoria.ALIMENTOS),
					new Producto("Laptop", 800.00, 10, Producto.Categoria.ELECTRONICA),
					new Producto("Camiseta", 15.99, 50, Producto.Categoria.ROPA),
					new Producto("Silla", 45.50, 30, Producto.Categoria.HOGAR),
					new Producto("Libro de cocina", 25.00, 40, Producto.Categoria.LIBROS),
					new Producto("Pan", 1.20, 200, Producto.Categoria.ALIMENTOS),
					new Producto("Televisor", 600.00, 8, Producto.Categoria.ELECTRONICA),
					new Producto("Pantalones", 30.00, 25, Producto.Categoria.ROPA),
					new Producto("Mesa", 120.00, 15, Producto.Categoria.HOGAR),
					new Producto("Novela", 20.00, 60, Producto.Categoria.LIBROS),
					new Producto("Leche", 0.99, 180, Producto.Categoria.ALIMENTOS),
					new Producto("Teléfono móvil", 400.00, 20, Producto.Categoria.ELECTRONICA),
					new Producto("Chaqueta", 60.00, 35, Producto.Categoria.ROPA),
					new Producto("Estantería", 75.00, 12, Producto.Categoria.HOGAR),
					new Producto("Enciclopedia", 50.00, 10, Producto.Categoria.LIBROS),
					new Producto("Arroz", 1.50, 150, Producto.Categoria.ALIMENTOS),
					new Producto("Auriculares", 35.00, 40, Producto.Categoria.ELECTRONICA),
					new Producto("Zapatos", 45.00, 22, Producto.Categoria.ROPA),
					new Producto("Lámpara", 30.00, 25, Producto.Categoria.HOGAR),
					new Producto("Libro de historia", 18.00, 50, Producto.Categoria.LIBROS),
					new Producto("Cereal", 3.50, 90, Producto.Categoria.ALIMENTOS),
					new Producto("Cámara", 250.00, 10, Producto.Categoria.ELECTRONICA),
					new Producto("Sombrero", 20.00, 40, Producto.Categoria.ROPA),
					new Producto("Cama", 500.00, 5, Producto.Categoria.HOGAR),
					new Producto("Libro infantil", 12.00, 70, Producto.Categoria.LIBROS),
					new Producto("Galletas", 2.00, 120, Producto.Categoria.ALIMENTOS),
					new Producto("Smartwatch", 150.00, 15, Producto.Categoria.ELECTRONICA),
					new Producto("Abrigo", 85.00, 18, Producto.Categoria.ROPA),
					new Producto("Espejo", 55.00, 22, Producto.Categoria.HOGAR),
					new Producto("Diccionario", 22.00, 40, Producto.Categoria.LIBROS)));

	// Método para obtener los productos
	public static List<Producto> getProductos() {
		return productos;
	}

	/*
	 * Este metodo recibe un nombre busca el producto que tenga ese nombre y lo
	 * devuelve.
	 * 
	 * @param: nombre del producto
	 * 
	 * @returns: el objeto Producto que tenga asignado el nombre especificado
	 * 
	 * Tal y como esta diseñado en programa no debe de haber dos ejercicios con el
	 * mismo nombre, sin embargo si por algun casual lo hubiera siempre manda el
	 * primero que este registrado en la array Igual no es el resultado esperado
	 * pero de esta manera no crasheara.
	 */
	public static Producto getUnProducto(String nombre) {

		ArrayList<Producto> producto = productos.stream().filter(x -> x.getNombre().equals(nombre))
				.collect(Collectors.toCollection(ArrayList::new));

		if (!producto.isEmpty()) {
			return producto.get(0);
		} else {
			return null;
		}

	}

	/*
	 * Este metodo elimina un producto dado
	 * 
	 * @param: El producto a eliminar
	 */
	public static void eliminarProducto(Producto producto) {
		productos.remove(producto);
	}

	/*
	 * El metodo modificar utiliza los setters para modificar la informacion
	 * necesaria No se puede modificar el nombre ya que actua como el ID del
	 * producto.
	 * 
	 * @param modificad: El objeto producto con los valores ya editados.
	 * 
	 * @param original: El producto original almacenado en la array.
	 */
	public static void modificarProducto(Producto modificado, Producto original) {
		original.setPrecio(modificado.getPrecio());
		original.setStock(modificado.getStock());
		original.setCategoria(modificado.getCategoria());
	}

	/*
	 * El form manda los datos en tipo string por lo que esta funcion los convierte
	 * al tipo categoria para poder crear el objeto
	 * 
	 * @param: La categoria desde el formulario
	 * 
	 * @returns: El objeto categoria correspondiente El null esta puesto en default
	 * pero no debe saltar nunca ya que hemos utilizado un select para escoger las
	 * strings
	 */
	public static Categoria parsearCategoria(String categoria) {
		switch (categoria.toUpperCase()) {
		case "ALIMENTOS":
			return Categoria.ALIMENTOS;
		case "ELECTRONICA":
			return Categoria.ELECTRONICA;
		case "ROPA":
			return Categoria.ROPA;
		case "HOGAR":
			return Categoria.HOGAR;
		case "LIBROS":
			return Categoria.LIBROS;
		default:
			return null;
		}
	}

	/*
	 * agregarAProductos recoge un objeto producto y lo añade a la lista de
	 * productos
	 */
	public static void agregarAProductos(Producto producto) {
		productos.add(producto);
	}

}
