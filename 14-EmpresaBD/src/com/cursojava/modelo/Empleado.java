package com.cursojava.modelo;

import java.sql.Date;

/**
 * La clase Empleado es una clase que imita la tabla de la base de datos. De esta manera cuando tengamos que trabajar con sus datos solo tendremos que hacer una consulta.
 * @author: Victor Tercero
 * @version: 1.21
 */

public class Empleado {
	private int id;
	private String nombre;
	private String apellido1;
	private String apellido2;
	private Date fechaNacimiento; 
	private double salario;

	// Constructores
	
	//Constructor sin id para insertarlo en la base de datos. La base de datos crea su id con auto increment
	public Empleado(String nombre, String apellido1, String apellido2, Date fechaNacimiento, double salario) {
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.fechaNacimiento = fechaNacimiento;
		this.salario = salario;
	}
	//Constructor con id para cuando ejecutamos el metodo de recuperar los empleados de la BD
	public Empleado(int id, String nombre, String apellido1, String apellido2, Date fechaNacimiento, double salario) {
		this.id= id;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.fechaNacimiento = fechaNacimiento;
		this.salario = salario;
	}
	//Constructor vacio
	public Empleado () {}

	// Getters y Setters (El setter de ID esta eliminado ya que debemos asegurarnos que el ID lo gestiona unicamente la BD)
	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

}

