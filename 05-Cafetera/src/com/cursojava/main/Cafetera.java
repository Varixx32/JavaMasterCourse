package com.cursojava.main;

public class Cafetera {
	private double cantidadMaxima; 
	private double cantidadActual;
	
	//Constructores de acuerdo a los parametros del ejercicio
	public Cafetera() {
		cantidadMaxima= 1000; 
		cantidadActual= 0; 
	}

	public Cafetera(double cantidadMaxima) {
		this.cantidadMaxima = cantidadMaxima;
		cantidadActual= cantidadMaxima; 
	}

	public Cafetera(double cantidadMaxima, double cantidadActual) {
		this.cantidadMaxima = cantidadMaxima;
		
		if(cantidadActual>cantidadMaxima) {
			this.cantidadActual= cantidadMaxima; 
		}else {
			this.cantidadActual=cantidadActual; 
		}
	}
	//Getters y Setters
	public double getCantidadMaxima() {
		return cantidadMaxima;
	}

	public void setCantidadMaxima(double cantidadMaxima) {
		this.cantidadMaxima = cantidadMaxima;
	}

	public double getCantidadActual() {
		return cantidadActual;
	}
	
	//Se entiende que se aplica la misma propiedad del constructor al setter
	//La cafetera no puede tener mas cafe que la cantidad maxima de cafe que admite
	public void setCantidadActual(double cantidadActual) {
		if(cantidadActual>cantidadMaxima) {
			this.cantidadActual = this.cantidadMaxima;
		}else {
			this.cantidadActual = cantidadActual;
		}
	} 
	
	/**
	 * llenar cafeteria es un metodo que establece la cantidad actual a la cantidad maxima. 
	 */
	public void llenarCafetera() {
		cantidadActual= cantidadMaxima; 
	}
	
	/**
	 * servir taza vacia parte del cafe de la cafetera para llenar la taza
	 * @param cantidadTaza es la cantiad de liquido que cabe en la taza y por tanto la cantidad de cafe que se va a vaciar de la cafetera
	 */
	public void servirTaza(double cantidadTaza) {
		if(cantidadTaza>cantidadActual) {
			//0 ya que no puedes tener una cantidad de cafe negativa
			cantidadActual= 0; 
		}else {
			cantidadActual = cantidadActual-cantidadTaza; 
		}
	}
	
	/**
	 * vaciarCafetera establece la cantidad actual de cafe a 0
	 */
	public void vaciarCafetera() {
		cantidadActual=0; 
	}
	
	/**
	 * agregarCafe añade una cantidad x de cafe a la cafetera. Si esta cantidad es mayor que la maxima entonces simplemente la llena.
	 * @param cantidad
	 */
	
	public void agregarCafe(double cantidad) {
		if(cantidad+ cantidadActual>cantidadMaxima) {
			cantidadActual= cantidadMaxima; 
		}else {
			cantidadActual += cantidad;
		}
	}
	
}
