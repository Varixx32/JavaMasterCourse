package com.cursojava.vista;


import java.sql.Date;

import com.cursojava.controlador.EmpleadoControlador;
import com.cursojava.modelo.Empleado;

public class EmpleadoVista {
	/**
	 * Muestra un menu basico con las opciones a seleccionar. Utiliza un switch para seleccionarlas. He incluido una opcion de salir del programa
	 */
    public static void mostrarMenu() {
        int opcion;

        do {
            System.out.println("---- Menú de Gestión de Empleados ----");
            System.out.println("1. Listar todos los empleados");
            System.out.println("2. Buscar empleado por apellido");
            System.out.println("3. Insertar nuevo empleado");
            System.out.println("4. Actualizar empleado");
            System.out.println("5. Eliminar empleado");
            System.out.println("6. Salir");

            opcion = EmpleadoControlador.introduceInt("Elige una opción: ");
            
            switch (opcion) {
                case 1:
                    EmpleadoControlador.imprimirTodosLosEmpleados();
                    break;
                case 2:
                    String apellido = EmpleadoControlador.introduceString("Introduce el apellido del empleado a buscar: ");
                    EmpleadoControlador.imprimirEmpleadoPorApellido(apellido);
                    break;
                case 3:
                    insertarNuevoEmpleado();
                    break;
                case 4:
                    actualizarEmpleado();
                    break;
                case 5:
                    eliminarEmpleado();
                    break;
                case 6:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida, por favor elige una opción entre 1 y 6.");
            }

        } while (opcion != 6);
    }
    /**
     * insertar empleado le pide al usuario todos los datos necesarios para la insercion. Tambien los comprueba antes de redirigirlos al controlador. (Las comprobaciones se hacen en metodos del propio controlador)
     */
    public static void insertarNuevoEmpleado() {
        System.out.println("---- Insertar nuevo empleado ----");
        String nombre = EmpleadoControlador.introduceString("Nombre: ");
        String apellido1 = EmpleadoControlador.introduceString("Primer apellido: ");
        String apellido2 = EmpleadoControlador.introduceString("Segundo apellido: ");
        Date fechaNacimiento = EmpleadoControlador.introduceFecha("Fecha de nacimiento (yyyy-MM-dd): ");
        double salario = EmpleadoControlador.introduceDouble("Salario: ");

        Empleado nuevoEmpleado = new Empleado(nombre, apellido1, apellido2, fechaNacimiento, salario);
        EmpleadoControlador.insertarEmpleado(nuevoEmpleado);
    }
    /**
     * actualizarEmpleado le pide al usuario todos los datos necesarios para la actualizacion. Tambien los comprueba antes de redirigirlos al controlador. (Las comprobaciones se hacen en metodos del propio controlador)
     */
    public static void actualizarEmpleado() {
        System.out.println("---- Actualizar empleado ----");
       
        int id = EmpleadoControlador.introduceId("Introduce el id del empleado que quieras actualizar: ");
        String nombre = EmpleadoControlador.introduceString("Nuevo nombre: ");
        String apellido1 = EmpleadoControlador.introduceString("Nuevo primer apellido: ");
        String apellido2 = EmpleadoControlador.introduceString("Nuevo segundo apellido: ");
        Date fechaNacimiento = EmpleadoControlador.introduceFecha("Nueva fecha de nacimiento (dd-MM-aaaa): ");
        double salario = EmpleadoControlador.introduceDouble("Nuevo salario: ");

        Empleado empleadoActualizado = new Empleado(id, nombre, apellido1, apellido2, fechaNacimiento, salario);
        EmpleadoControlador.actualizarEmpleado(empleadoActualizado);
    }
    /**
     * eliminarEmpleado elimina un empleado de la base de datos. Comprueba a su vez que exista
     * Utiliza el objeto empleado pero para eliminarlo solo es necesario el id asi que inicializa el constctor con datos por defecto. 
     */
    public static void eliminarEmpleado() {
        System.out.println("---- Eliminar empleado ----");
        int id = EmpleadoControlador.introduceId("ID del empleado a eliminar: ");
        Empleado empleadoAEliminar = new Empleado(id, "", "", "", null, 0);
        EmpleadoControlador.eliminarEmpleado(empleadoAEliminar);
    }

}
