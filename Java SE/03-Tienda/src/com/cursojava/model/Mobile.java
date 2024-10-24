package com.cursojava.model;

public class Mobile extends Product {
	private String provider;

	public Mobile(String productCode, String model, float price, int quantity, String provider) {
		super(productCode, model, price, quantity);
		this.provider = provider; 
	}
}
