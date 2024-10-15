package com.cursojava.model;

/*
 * La clase producto almacena los atributos de producto
 * @author: Victor Tercero
 * @version: 1.21
 */
public class Producto {
    // Creo un enum con categorias de ejemplo ya que en un almacen el numero de categorias es limitado y por tanto para evitar errores es preferible hacerlo de esta manera.
    public enum Categoria {
        ALIMENTOS, ELECTRONICA, ROPA, HOGAR, LIBROS
    }
    //En este caso el nombre actuará como el ID y no debe ser cambiado. Por ese mismo motivo elimino su Setter
    private String nombre;
    private double precio;
    private int stock;
    private Categoria categoria;

    // Constructor
    public Producto(String nombre, double precio, int stock, Categoria categoria) {
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        this.categoria = categoria;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public int getStock() {
        return stock;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    // Setters
   
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
