package com.cursojava.model;

public class Computers extends Product {
	private String cpuModel; 
	private float hardDriveCapacity; 
	private float ramMemory;
	
	public Computers(String productCode, String model, float price, int quantity, String cpuModel, float hardDriveCapacity, float ramMemory ) {
		super(productCode, model, price, quantity);
		this.cpuModel= cpuModel; 
		this.hardDriveCapacity = hardDriveCapacity; 
		this.ramMemory = ramMemory; 
	}	
}
