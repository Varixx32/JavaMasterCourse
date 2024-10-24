package com.cursojava.model2;

public abstract class FiguraGeometrica {
	private double base; 
	private double altura; 
	private double area; 
	private double perimetro; 
	
	
	
	public FiguraGeometrica() {
		super();
	}
	public FiguraGeometrica(double base, double altura, double area, double perimetro) {
		super();
		this.base = base;
		this.altura = altura;
		this.area = area;
		this.perimetro = perimetro;
	}
	
	
	public double getBase() {
		return base;
	}
	public void setBase(double base) {
		this.base = base;
	}
	public double getAltura() {
		return altura;
	}
	public void setAltura(double altura) {
		this.altura = altura;
	}
	public double getArea() {
		return area;
	}
	public void setArea(double area) {
		this.area = area;
	}
	public double getPerimetro() {
		return perimetro;
	}
	public void setPerimetro(double perimetro) {
		this.perimetro = perimetro;
	}
	private double calcularPerimetro() {
		return 0;
	}
	private double calcularArea() {
		return 0; 
	}

}
