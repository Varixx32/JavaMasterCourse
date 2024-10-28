package com.cursojava.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

@Entity
@Table(name = "Peliculas")
@NamedQueries({
    @NamedQuery(name = "Pelicula.buscarTodas", query = "SELECT p FROM Pelicula p"),
    @NamedQuery(name = "Pelicula.buscarPorDirector", query = "SELECT p FROM Pelicula p WHERE p.director = :director"),
    @NamedQuery(name = "Pelicula.encontrarDirectorPorLetra", query = "SELECT p FROM Pelicula p WHERE p.director LIKE :letra"),
    @NamedQuery(name = "Pelicula.encontrarPorRangoDePrecio", query = "SELECT p FROM Pelicula p WHERE p.precioAlquiler > :precioMinimo AND p.precioAlquiler < :precioMaximo"),
    @NamedQuery(name = "Pelicula.encontrarPorPrecio", query = "SELECT p.precioAlquiler, COUNT(p) FROM Pelicula p GROUP BY p.precioAlquiler")
})
public class Pelicula {
    @Id
    @Column(name = "Codigo") 
    private int codigo;

    @Column(name = "Titulo") 
    private String titulo;

    @Column(name = "Director") 
    private String director;

    @Column(name = "PrecioAlquiler") 
    private double precioAlquiler;

    // Constructores
    public Pelicula() {}

    public Pelicula(int codigo, String titulo, String director, double precioAlquiler) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.director = director;
        this.precioAlquiler = precioAlquiler;
    }

    // Getters y Setters
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public double getPrecioAlquiler() {
        return precioAlquiler;
    }

    public void setPrecioAlquiler(double precioAlquiler) {
        this.precioAlquiler = precioAlquiler;
    }
    
    @Override
    public String toString() {
        return String.format("Título: %s\n" +
                             "Director: %s\n" +
                             "Código: %d\n" +
                             "Precio Alquiler: $%.2f\n" +
                             "--------------------", 
                             titulo, director, codigo, precioAlquiler);
    }


}
