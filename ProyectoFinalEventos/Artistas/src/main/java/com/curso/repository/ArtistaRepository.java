package com.curso.repository;

import com.curso.model.Artista;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

/**
 * Repositorio de acceso a datos para la entidad Artista.
 * Proporciona métodos CRUD y consultas personalizadas para gestionar artistas.
 * 
 * @author Victor Tercero
 * @version: 1.21
 */
public interface ArtistaRepository extends JpaRepository<Artista, Long> {

    /**
     * Busca y retorna todos los artistas que están disponibles.
     *
     * @return Una lista de artistas disponibles.
     */
    List<Artista> findByDisponibleTrue();

    /**
     * Busca un artista por su nombre.
     *
     * @param nombre Nombre del artista.
     * @return El artista encontrado o null si no existe.
     */
    Artista findByNombre(String nombre);
}
