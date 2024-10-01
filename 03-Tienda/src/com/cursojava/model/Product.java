package com.cursojava.model;

public abstract class Product {
	private final String productCode;
	private String model;
	private float price;
	private int quantity; 
	
	public Product() {
		super();
		this.productCode = "";
	}
	public Product(String productCode, String model, float price, int quantity) {
		super();
		this.productCode = productCode;
		this.model = model;
		this.price = price;
		this.quantity = quantity; 
	}


	// Getter y setter de los atributos de todos los productos
	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getProductCode() {
		return productCode;
	}

}
