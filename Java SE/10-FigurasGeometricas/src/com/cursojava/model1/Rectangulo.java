package com.cursojava.model1;

import com.cursojava.interfaces.Calculable;

public class Rectangulo implements Calculable{
	private double lado1; 
	private double lado2; 
	private double area; 
	private double perimetro;
	@Override
	public double calcularArea() {
		area = lado1 * lado2; 
		return area;
	}
	@Override
	public double calcularPerimetro() {
		perimetro = (lado1 * 2) + (lado2 * 2); 
		return perimetro;
	} 
	
	
}
