package com.cursojava.model1;

import com.cursojava.interfaces.Calculable;

public class Circulo implements Calculable {
	private double radio; 
	private double area; 
	private double perimetro; 
	
	@Override
	public double calcularArea() {
		area = Math.PI * radio * radio; 
		return 0;
	}

	@Override
	public double calcularPerimetro() {
		perimetro = 2* Math.PI* radio;
		return perimetro;
	}

}
