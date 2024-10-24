

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.cursojava.model.Producto;
import com.cursojava.model.Producto.Categoria;
import com.cursojava.service.AlmacenService;
/**
 * Esta clase hace el test de la clase AlmacenService que es la que tiene todos los metodos con retornos.
 * @author Victor Tercero
 * @version 1.21
 */

class AlmacenServiceTest {

	
	/*
	 * Este test comprueba que el metodo getProductos devuelve la array con los productos iniciales. 
	 * Como la Array esta preinicializada a 30 utiliza el metodo size para comprobarlo
	 */
    @Test
    void testGetProductos() {
        List<Producto> productos = AlmacenService.getProductos();
        assertEquals(30, productos.size());
    }
    /*
     * Este test comprueba que los productos que si existen se devuelvan correctamente mientras que los que no existen devuelve null
     * En este caso no se si es correcto pero mi arrange y mi act se hacen dentro de la misma linea
     */
    @Test
    void testGetUnProducto() {
    	//arrange y act
        Producto producto = AlmacenService.getUnProducto("Manzana");
        //assert
        assertEquals("Manzana", producto.getNombre());
        //arrange y act
        Producto productoInexistente = AlmacenService.getUnProducto("ERROR");
        //assert
        assertNull(productoInexistente);
    }
    
    /*
     * Este test comprureba el metodo de eliminar producto. Primero utiliza un assert para comprobar que el producto existe. Acto seguido lo borra y comprueba que no existe.
     */
    @Test
    void testEliminarProducto() {
    	//arrange y act
        Producto producto = AlmacenService.getUnProducto("Manzana");
        //assert
        assertNotNull(producto);
        //arrange y act
        AlmacenService.eliminarProducto(producto);
        //assert	
        assertNull(AlmacenService.getUnProducto("Manzana"));
    }
    /*
     * Este test comprueba el metodo para modificar producto. Primero modifica el producto y luego comprueba que los nuevos valores del objeto son los que deben ser
     */
    @Test
    void testModificarProducto() {
    	//arrange
        Producto original = AlmacenService.getUnProducto("Laptop");
        Producto modificado = new Producto("Laptop", 900.00, 8, Categoria.ELECTRONICA);
        //act
        AlmacenService.modificarProducto(modificado, original);
        //assert
        assertEquals(900.00, original.getPrecio());
        assertEquals(8, original.getStock());
    }
    /*
     * Este es el test para parsear la categoria. Prueba a crear una categoria que si exista y comprueba que efectivamente se ha parseado bien
     * Despues trata de crear una categoria invalida y ve que efectivamente devuelve null ya que nose ha podido parsear correctamente
     */
    @Test
    void testParsearCategoria() {
    	//arrange y act
        Categoria categoriaAlimentos = AlmacenService.parsearCategoria("ALIMENTOS");
        //assert
        assertEquals(Categoria.ALIMENTOS, categoriaAlimentos);
        //arrange y act
        Categoria categoriaInvalida = AlmacenService.parsearCategoria("ERROR");
        //assert
        assertNull(categoriaInvalida);
    }
    /*
     * Este test prueba a agregar un producto a la array de productos. Primero utiliza el metodo para añadir y despues lo intenta sacar de la array. Si existe es que el metodo de añadir ha funcionado correctamente. 
     */
    @Test
    void testAgregarAProductos() {
    	//arrange
        Producto nuevoProducto = new Producto("Tablet", 500.00, 20, Categoria.ELECTRONICA);
        //act
        AlmacenService.agregarAProductos(nuevoProducto);
        //assert
        Producto productoRecuperado = AlmacenService.getUnProducto("Tablet");
        assertNotNull(productoRecuperado);
        assertEquals("Tablet", productoRecuperado.getNombre());
    }
}

