package com.cursojava.model;

import java.util.ArrayList;

/**
 * La clase camion es un vehiculo con 12 ruedas y un tacometro
 * @author: Victor Tercero
 * @version: 1.21
 */

public class Camion extends Vehiculo {
	private static final int N_RUEDAS = 12; 
	private final String matricula; 
	private ArrayList<Double> tacometro = new ArrayList<Double>();
	
	//Constructores
		
	public Camion(String matricula) {
		super();
		this.matricula = matricula;
	}

	public Camion(String color, double velocidad, int numPlazas, double tiempoDeViaje, double espacioRecorrido, String matricula) {
		super(color, velocidad, numPlazas, tiempoDeViaje, espacioRecorrido);
		this.matricula = matricula; 
	}
	
	//Setters y getters
	
	public ArrayList<Double> getTacometro() {
		return tacometro;
	}

	public void setTacometro(ArrayList<Double> tacometro) {
		this.tacometro = tacometro;
	}

	public static int getnRuedas() {
		return N_RUEDAS;
	}

	public String getMatricula() {
		return matricula;
	}

	/**
	 * arrancar pone un comentario personalizado para el camion para simular procesos de arranque distintos
	 */
	public void arrancar() {
		System.out.println("El camion con matricula " + matricula + " ha arrancado");
	}
	
	/**
	 * parar tan solo pone un comentario personalizado para el caminon simulando un proceso de parado distinto
	 */

	public void parar() {
		System.out.println("El camion con la matricula " + matricula + " ha parado");
		super.parar();
	}
	
	/**
	 * avanzar imprime un mensaje personalizado y ademas registra las velocidades en el tacometro
	 */
	public void avanzar(double metros, double segundos) {
		System.out.println("Avanzo por la ruta");
		super.avanzar(metros, segundos); 
		//Añades la velocidad despues de llamar al metodo padre para que la actualice cada vez que avance y siempre añada la version actualizada
		tacometro.add(super.getVelocidad()); 
	}


	
}
