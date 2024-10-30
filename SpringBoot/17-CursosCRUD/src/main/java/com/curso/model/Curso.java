package com.curso.model;

/**
 * Modelo de Curso con los datos a almacenar 
 * @author Victor Tercero
 * @version 1.21
 *
 */
public class Curso {
    private int codCurso;
    private String nombre;
    private int duracion;
    private double precio;

    public Curso() {}

    // Constructor con parámetros
    public Curso(int codCurso, String nombre, int duracion, double precio) {
    	this.codCurso = codCurso; 
        this.nombre = nombre;
        this.duracion = duracion;
        this.precio = precio;
    }

    // Getters y Setters
    public int getCodCurso() {
        return codCurso;
    }

    public void setCodCurso(int codCurso) {
        this.codCurso = codCurso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
