package com.cursojava.model;

import com.cursojava.interfaz.Mascota;

public class Pez extends Animal implements Mascota{
	private String nombrePez;
	
	
	public void andar() {
		super.andar(); 
		System.out.println("No ando, nado");
	}

	public void comer() {
		System.out.println("Me gusta comer placton");
	}

	@Override
	public void jugar() {
		System.out.println("Estoy Nadando");
	}
	
	

}
