package com.cursojava.model;

import com.cursojava.interfaz.Mascota;

public class Gato extends Animal implements Mascota {
	
	private String nombreGato; 

	@Override
	public void jugar() {
		System.out.println("Soy el gato " + nombreGato + " me gusta jugar con la pelota");
	}
	public void comer() {
		System.out.println("Me gusta comer arañas y peces"); 
	}
}
