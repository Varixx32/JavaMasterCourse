package com.cursojava.principal;

import com.cursojava.consultas.Consultas;
import com.cursojava.model.Pelicula;
/**
 * Clase principal que ejecuta las pruebas
 * @author Victor Tercero
 *	@version 1.21
 */
public class Principal {

    public static void main(String[] args) {
        Consultas consultas = new Consultas();

        // BUSCAR TODAS LAS PELÍCULAS
        System.out.println("---TODAS LAS PELÍCULAS ---");
        for (Pelicula pelicula : consultas.buscarTodasLasPeliculas()) {
            System.out.println(pelicula);
        }

        // BUSCAR POR DIRECTOR
        System.out.println("---PELICULAS POR DIRECTOR---");
        for (Pelicula pelicula : consultas.buscarPorDirector("Christopher Nolan")) {
            System.out.println(pelicula);
        }

        // BUSCAR DIRECTORES QUE EMPIEZAN CON 'T'
        System.out.println("---PELICULAS POR LETRA 'T'---");
        for (Pelicula pelicula : consultas.encontrarDirectorPorLetra("C")) {
            System.out.println(pelicula);
        }

        // BUSCAR PELÍCULAS DE DIRECTORES ANA O EVA
        System.out.println("---PELICULAS DE DOS DIRECTORES DISTINTOS---");
        for (Pelicula pelicula : consultas.buscarPorDirector("Hayao Miyazaki")) {
            System.out.println(pelicula);
        }
        for (Pelicula pelicula : consultas.buscarPorDirector("James Cameron")) {
            System.out.println(pelicula);
        }

        // BUSCAR PELÍCULAS POR RANGO DE PRECIO
        System.out.println("---PELÍCULAS CON PRECIO ENTRE 20 Y 55---");
        for (Pelicula pelicula : consultas.encontrarPorRangoDePrecio(20, 55)) {
            System.out.println(pelicula);
        }

        // MOSTRAR EL NÚMERO DE PELÍCULAS POR PRECIO DE ALQUILER
        System.out.println("---NÚMERO DE PELÍCULAS POR PRECIO DE ALQUILER---");
        for (Object[] resultado : consultas.encontrarPorPrecio()) {
            double precio = (Double) resultado[0];
            long cantidad = (Long) resultado[1];
            System.out.printf("Precio: $%.2f - Cantidad de Películas: %d%n", precio, cantidad);
        }

       
    }
}
