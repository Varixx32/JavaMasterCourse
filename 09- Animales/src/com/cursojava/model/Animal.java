package com.cursojava.model;

public abstract class Animal {
	private int numeroPatas;
	
	public Animal () {
		super();
	}

	public Animal(int numeroPatas) {
		super();
		this.numeroPatas = numeroPatas;
	}

	public int getNumeroPatas() {
		return numeroPatas;
	}

	public void setNumeroPatas(int numeroPatas) {
		this.numeroPatas = numeroPatas;
	}
	
	public void andar() {
		System.out.println("Estoy andando sobre " + numeroPatas + " patas");
	}
	
	public void comer() {
	}
	
}
