package com.cursojava.model;

/**
 * Clase coche que extiende de vehiculo y añade sus atributos particulares
 * @author Victor Tercero
 * @version 1.21
 *
 */

public class Coche extends Vehiculo {
	
	private static final int N_RUEDAS = 4; 
	private final String matricula; 


	public Coche(String matricula) {
		super();
		this.matricula = matricula; 
	}

	public Coche(String color, double velocidad, int numPlazas, String matricula, double espacioRecorrido, double tiempoDeViaje) {
		super(color, velocidad, numPlazas, espacioRecorrido, tiempoDeViaje);
		this.matricula = matricula; 
	}
	
	/**
	 * arrancar imprime un mensaje personalizado emulando los distintos procesos de arranque que tienen los vehiculos
	 */
	
	public void arrancar() {
		System.out.println("Soy el coche con la matricula " + matricula + " y he arrancado");
		super.arrancar();
		
	}
	/**
	 * parar imprime un mensaje personalizado emulando los distintos procesos de parado que tienen los diferentes vehiculos
	 */

	public void parar() {
		System.out.println("El coche con la matricula " + matricula + " ha parado");
		super.parar();
		
	}
	
	/**
	 * avanzar imprime un mensaje personalizado emulando los distintos procesos de avance que tienen los vehiculos
	 */

	public void avanzar(double metros, double segundos) {
		System.out.println("Avanzo por la carretera");
		super.avanzar(metros, segundos);
	}
	

}
 