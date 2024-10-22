package com.cursojava.controlador;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.cursojava.conexion.Conexion;
import com.cursojava.dao.EmpleadoDAO;
import com.cursojava.modelo.Empleado;


/**
 * La clase empleado controlador lleva a cabo la logistica de la aplicacion al igual que hace de intermediario entre el usuario y el modelo y el DAO
 * @author Victor Tercero
 * @version 1.21
 */
public class EmpleadoControlador {
	private static EmpleadoDAO empleadoDAO = new EmpleadoDAO(Conexion.conectarMySQL());
	private static Scanner scanner = new Scanner(System.in);

    /**
     * Introduce int es un metodo que pide al usuario un numero por la terminal y hace las comprobaciones pertinentes antes de pasarlo al resto del programa
     * Se asegura de que el dato introducido es un numero, de otra manera no avanza. 
     * Ademas limpia el buffer del scanner.
     * @param mensaje: Es el mensaje que deseas que se muestre por pantalla antes de pedir el numero. Si no quieres que muestre nada introduce una string vacia
     * @return El numero introducido
     */
    public static int introduceInt(String mensaje) {
        int numero = 0;
        boolean correcto = false;
        while (!correcto) {
            try {
                System.out.print(mensaje);
                numero = scanner.nextInt();
                correcto = true;
            } catch (InputMismatchException e) {
                System.out.println("Error: Introduce un número entero válido.");
            }
        }
        scanner.nextLine(); // Limpiar buffer del scanner
        return numero;
    }

   /**
    * El metodo IntroduceString utiliza el Scanner para pedirle al usuario que es una string. 
    * Todo lo que metas por la consola puede ser una string asi que solamente comprueba que no tenga mas de 50 caracteres que es el maximo que almacena nuestra base de datos
    * @return la string introducida
    */
    public static String introduceString(String mensaje) {
    	String string = null;
        boolean correcto = false;

        while (!correcto) {
            System.out.println(mensaje);
            string = scanner.nextLine();
            if(string.toCharArray().length<50) {
            	correcto = true; 
            	break;
            }else {
            	System.out.println("El maximo de caracteres es 50");
            }
        }
        return string;
    }

   /**
    * El meotodo introduceFecha le pide al usuario una fecha en un formato en concreto.
    * Si la mete en otro formato o lo que introduce no es una fecha entonces le pide que la introduzca de nuevo
    * @param mensaje a imprimir
    * @return Fecha parseada a SQLDate para que se pueda utilizar en las bases de datos
    */
    public static Date introduceFecha(String mensaje) {
        Date fecha = null;
        boolean correcto = false;
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");

        while (!correcto) {
            try {
                System.out.print(mensaje);
                String fechaInput = scanner.nextLine();
                fecha = new Date(formatoFecha.parse(fechaInput).getTime());
                correcto = true;
            } catch (ParseException e) {
                System.out.println("Error: Introduce una fecha válida en formato dd-MM-aaaa.");
            }
        }
        return fecha;
    }

    /**
     * El metodo introduceDouble recibe pide al usuario un double y comprueba que efectivamente sea un Double. Si no lo pide de vuelta. 
     * Ademas limpia el buffer del scanner.
     * @param mensaje
     * @return El double introducido
     */
    public static double introduceDouble(String mensaje) {
        double numero = 0;
        boolean correcto = false;
        while (!correcto) {
            try {
                System.out.print(mensaje);
                numero = scanner.nextDouble();
                correcto = true;
            } catch (InputMismatchException e) {
                System.out.println("Error: Introduce un número decimal válido.");
            }
        }
        scanner.nextLine(); // Limpiar buffer del scanner
        return numero;
    }
    /**
     * La clase introduceID se encarga de asegurar que el numero introducido equivale a un id en la base de datos. Esto es para evitar problemas en el Delete y el Update.
     * @param mensaje
     * @return el id seleccionado
     */
    public static int introduceId(String mensaje) {
        int id = 0;
        boolean correcto = false;
        while (!correcto) {
            try {
                System.out.print(mensaje);
                id = scanner.nextInt();
                if(!empleadoDAO.selectEmpleadoPorId(id).equals(null)) {
                	correcto=true;
                }else {
                	System.out.println("No hemos encontrado el ID en la base de datos. Introduce un ID valido");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Introduce un número id válido.");
            }
        }
        scanner.nextLine(); // Limpiar buffer del scanner
        return id;
    }
	/**
	 * ImprimirEmpleadoFormato imprime un empleado de manera presentable por pantalla. He hecho este metodo porque varios otros metodos imprimian datos por pantalla y esta es la forma mas ordenada de hacerlo. 
	 * @param empleado a imprimir
	 */
	 public static void imprimirEmpleadoFormato(Empleado empleado) {
	        System.out.println("+--------------------------------------+");
	        System.out.println("| ID:         " + empleado.getId());
	        System.out.println("| Nombre:     " + empleado.getNombre());
	        System.out.println("| Apellido 1: " + empleado.getApellido1());
	        System.out.println("| Apellido 2: " + empleado.getApellido2());
	        System.out.println("| Fecha Nac.: " + empleado.getFechaNacimiento());
	        System.out.println("| Salario:    " + String.format("%.2f", empleado.getSalario()));
	        System.out.println("+--------------------------------------+");
	        System.out.println();
	    }
	/**
	 * imprimirEmpleados recibe una array de x empleados y los manda a imprimir con formato. Comprueba que la arraylist no este vacia aunque llegados a este metodo no deberia estarlo nunca. 
	 * @param empleados a imprimir
	 */
	public static void imprimirEmpleados(ArrayList<Empleado> empleados) {
		if(!empleados.isEmpty()) {
			System.out.println("Lista de empleados:");
        
        	for (Empleado empleado : empleados) {
        		imprimirEmpleadoFormato(empleado);
        	}
		}else {
			System.out.println("No hay empleados registrados en la base de datos");
		}
	}
	
	/**
	 * imprimirEmpleadosPorApellido busca los empleados con un mismo apellido. Pueden o no ser varios y luego los manda a imprimir.
	 * @param apellido a buscar
	 */
	
	public static void imprimirEmpleadoPorApellido(String apellido) {
		ArrayList<Empleado> empleadosEncontrados = empleadoDAO.selectEmpleadoPorApellido(apellido);
		if(!empleadosEncontrados.isEmpty()) {
			imprimirEmpleados(empleadosEncontrados);
		}else {
			System.out.println("No hemos encontrado empleados con ese apellido");
		}
	}
	/**
	 * imprimirTodosLosEmpleados recupera todos los empleados de la base de datos y los imprime.
	 */
	public static void imprimirTodosLosEmpleados() {
		ArrayList<Empleado> empleadosEncontrados = empleadoDAO.selectEmpleados();
		if(!empleadosEncontrados.isEmpty()) {
			imprimirEmpleados(empleadosEncontrados);
		}else {
			System.out.println("No hemos encontrado empleados en la base de datos");
		}
	}
	/**
	 * insertarEmpleado inserta un empleado en la base de datos. Este metodo esta para asegurar la encapsulacion. No necesita hacer comprobaciones ya que llegados a este punto estan todas hechas.
	 * @param empleado a insertar
	 */
	public static void insertarEmpleado (Empleado empleado) {
		empleadoDAO.insertarEmpleado(empleado);
        System.out.println("Empleado insertado.");
	}
	
	/**
	 * actualizarEmpleado actualiza un empleado en la base de datos. 
	 * @param empleado a actualizar (con los datos ya cambiados)
	 */
	
	public static void actualizarEmpleado (Empleado empleadoActualizado) {
		empleadoDAO.actualizarEmpleado(empleadoActualizado);
		System.out.println("Empleado actualizado.");
	}
	/**
	 * eliminarEmpleado elimina un empleado de la base de datos.
	 * @param empleado a eliminar
	 */
	public static void eliminarEmpleado(Empleado empleado) {
	  empleadoDAO.eliminarEmpleado(empleado);
	  System.out.println("Empleado eliminado.");
	}
}
