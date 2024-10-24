package com.cursojava.main;

public class Cuenta {
	private final String titular; 
	private double cantidad;
	
	//Constructores, ambos tienen el atributo cuenta ya que no puede haber una cuenta sin titular
	
	public Cuenta(String titular) {
		super();
		this.titular = titular;
	}

	public Cuenta(String titular, float cantidad) {
		super();
		this.titular = titular;
		this.cantidad = cantidad;
	}
	
	//Getters y Setters

	public double getCantidad() {
		return cantidad;
	}

	public void setCantidad(float cantidad) {
		this.cantidad = cantidad;
	}

	public String getTitular() {
		return titular;
	} 
	public void ingresar(double cantidadIngresada) {
		if(cantidadIngresada>0) {
			cantidad = cantidad - cantidadIngresada; 
		}
	}
	public void retirar (double cantidadRetirada) {
		if(cantidadRetirada>cantidad) {
			cantidad = 0; 
		}else {
			cantidad = cantidad-cantidadRetirada; 
		}
	}
	
}
