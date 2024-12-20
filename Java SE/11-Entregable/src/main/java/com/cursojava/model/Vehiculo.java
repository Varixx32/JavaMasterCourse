package com.cursojava.model;

import com.cursojava.interfaz.Conducible;

public abstract class Vehiculo implements Conducible{
	//Todos los vehiculos tienen un color, aunque sea el del propio material que estan hechos
	private String color; 
	private double velocidad;	
	private int numPlazas;
	private double tiempoDeViaje; 
	private double espacioRecorrido; 
	
	//Constructores, Para este ejemplo creare uno vacio y uno con todos los parametros
	//Esto es porque creo que todos los atributos son inherentes a todos los vehiculos
	
	public Vehiculo(String color, double velocidad, int numPlazas, double tiempoDeViaje, double espacioRecorrido) {
		super();
		this.color = color;
		this.velocidad = velocidad;
		this.numPlazas = numPlazas;
		this.tiempoDeViaje = tiempoDeViaje; 
		this.espacioRecorrido = espacioRecorrido; 
	}
	
	public Vehiculo() {
		super(); 
	}
	
	
	//Getters y Setters
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public double getVelocidad() {
		return velocidad;
	}
	public void setVelocidad(double velocidad) {
		this.velocidad = velocidad;
	}
	public int getNumPlazas() {
		return numPlazas;
		
	}

	public void setNumPlazas(int numPlazas) {
		this.numPlazas = numPlazas;
	}

	public double getTiempoDeViaje() {
		return tiempoDeViaje;
	}

	public void setTiempoDeViaje(double tiempoDeViaje) {
		this.tiempoDeViaje = tiempoDeViaje;
	}

	public double getEspacioRecorrido() {
		return espacioRecorrido;
	}

	public void setEspacioRecorrido(double espacioRecorrido) {
		this.espacioRecorrido = espacioRecorrido;
	}
	
	/*
	 * arrancar se implementa unicamente a nivel aritmetico ya que todos los vehiculos calculan los parametros de la misma manera
	 */
	
	public void arrancar() {
		setVelocidad(0); 
		setEspacioRecorrido(0);
		setTiempoDeViaje(0);
		
	}
	/*
	 * avanzar se implementa unicamente a nivel aritmetico ya que todos los vehiculos calculan los parametros de la misma manera
	 */
	public void avanzar(double metros, double segundos) {
		setEspacioRecorrido(getEspacioRecorrido()+metros); 
		setVelocidad(metros/segundos); 
		setTiempoDeViaje(getTiempoDeViaje()+segundos);
	} 
	
	public void parar() {
		System.out.println("La distancia recorrida ha sido " + getEspacioRecorrido()+ " metros");
		System.out.println("El tiempo que ha durado el recorrido " + getTiempoDeViaje());
		System.out.println("La velocidad media ha sido de " + getEspacioRecorrido()/getTiempoDeViaje() + " metros por segundo");
	}
	
	
	
	
	
	
}
