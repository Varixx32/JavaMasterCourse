package com.cursojava.ejecutable;

import com.cursojava.vista.EmpleadoVista;
/**
 * Esta clase es tecnicamente innecesaria ya que solo ejecuta un metodo de otra clase. Sin embargo queria dejar un Main facil de encontrar para que sea mas sencillo a la hora de probar el codigo. 
 * Esta clase no la incluiria en un proyecto real, solo esta incluida para facilitar la correcion del ejercicio
 * Tambien esta la clase MainPruebas En este mismo paquete que ejecuta todos los metodos importantes con datos de prueba directamente desde el codigo para no lidiar con la interfaz grafica. 
 * El script de generacion de base de datos ya incluye Empleados para que sea mas facil testear el codigo.
 * @author Victor Tercero
 * @version 1.21
 *
 */
public class Main {
	public static void main(String[] args) {
        EmpleadoVista.mostrarMenu();
    }
}
