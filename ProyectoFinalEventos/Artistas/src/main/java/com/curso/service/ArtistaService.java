package com.curso.service;

import com.curso.model.Artista;

import java.util.List;

/**
 * Interfaz para los servicios relacionados con los artistas.
 * 
 * @author Victor Tercero
 * @version: 1.21
 */
public interface ArtistaService {

    /**
     * Obtiene una lista de todos los artistas disponibles.
     *
     * @return Lista de artistas disponibles.
     */
    List<Artista> obtenerArtistasDisponibles();

    /**
     * Obtiene un artista específico por su nombre.
     *
     * @param nombre El nombre del artista.
     * @return El artista correspondiente al nombre o null si no existe.
     */
    Artista obtenerArtistaPorNombre(String nombre);

    /**
     * Obtiene un artista específico por su ID.
     *
     * @param id El ID del artista.
     * @return El artista correspondiente al ID o null si no existe.
     */
    Artista obtenerArtistaPorId(Long id);

    /**
     * Guarda un nuevo artista en la base de datos.
     *
     * @param artista El artista a guardar.
     * @return El artista guardado.
     */
    Artista guardarArtista(Artista artista);
}
