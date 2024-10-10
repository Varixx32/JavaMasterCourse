package com.cursojava.model;
/**
 * Clase que almacena la informacion de las paginas web
 * @author Victor
 * @version: 1.21
 *
 */
public class Website {
	private String direccion;
	private String tematica; 
	private String descrpicion;
	
	
	//Constructores
	public String getDireccion() {
		return direccion;
	}
	public Website(String direccion, String tematica, String descrpicion) {
		super();
		this.direccion = direccion;
		this.tematica = tematica;
		this.descrpicion = descrpicion;
	}
	//Setters y Getters
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTematica() {
		return tematica;
	}
	public void setTematica(String tematica) {
		this.tematica = tematica;
	}
	public String getDescrpicion() {
		return descrpicion;
	}
	public void setDescrpicion(String descrpicion) {
		this.descrpicion = descrpicion;
	} 
}
