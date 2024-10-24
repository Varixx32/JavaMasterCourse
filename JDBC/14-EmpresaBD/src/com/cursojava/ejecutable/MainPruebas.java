package com.cursojava.ejecutable;

import java.util.Date;

import com.cursojava.conexion.Conexion;
import com.cursojava.controlador.EmpleadoControlador;
import com.cursojava.dao.EmpleadoDAO;
import com.cursojava.modelo.Empleado;

/**
 * La clase main del paquete pruebas es una clase ejecutable que ejecuta los metodos directamente para comprobar que funcionan
 * 
 * Puedes probarlo manualmente con el entorno grafico ejecutando la clase Main que se encuentra en este mismo paquete. La base de datos tiene ya datos de ejemplo precargados. 
 */

public class MainPruebas {
    public static void main(String[] args) {
        Empleado nuevoEmpleado = new Empleado("Juan", "Perez", "Gomez", new java.sql.Date(new Date().getTime()), 2500.00);
        EmpleadoControlador.insertarEmpleado(nuevoEmpleado);

        // Actualizar empleado
        nuevoEmpleado.setSalario(2800.00); // Modificar el salario (Por ejemplo)
        EmpleadoControlador.actualizarEmpleado(nuevoEmpleado);
        

        // Buscar empleado por apellido
        	String apellido = "Perez";
        	EmpleadoControlador.imprimirEmpleadoPorApellido(apellido);

        // Listar todos los empleados
        	EmpleadoControlador.imprimirTodosLosEmpleados();

        // Eliminar empleado
        EmpleadoControlador.eliminarEmpleado(nuevoEmpleado);
        EmpleadoControlador.imprimirEmpleadoPorApellido(apellido);//Lo buscamos a ver si se ha borrado correctamente
        
        
    }
}
