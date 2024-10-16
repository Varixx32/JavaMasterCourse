package com.cursojava.model1;

import com.cursojava.interfaces.Calculable;

public class Cuadrado implements Calculable {
	private double longitudLado;
	private double area; 
	private double perimetro; 

	@Override
	public double calcularArea() {
		area= longitudLado*longitudLado;
		return area;
	}
	
	@Override
	public double calcularPerimetro() {
		perimetro = longitudLado * 4; 
		return perimetro;
	}
}
