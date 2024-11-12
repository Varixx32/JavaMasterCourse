package com.curso.model;

import jakarta.persistence.*;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Representa un artista en el sistema.
 * Esta entidad contiene información sobre el artista, como su nombre, categoría y disponibilidad.
 * 
 * @author Victor Tercero
 * @version: 1.21
 */
@Entity
@Table(name = "artistas")
public class Artista {

    /**
     * Identificador único del artista.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_artista")
    private Long id;

    /**
     * Nombre del artista.
     */
    @Column(name = "nombre", nullable = false, unique = true)
    
    private String nombre;

    /**
     * Categoría del artista (ejemplo: cantante, actor, banda).
     */
    @Column(name = "categoria", nullable = false)
    private String categoria;

    /**
     * Indica si el artista está disponible para reservas o eventos.
     */
    @Column(name = "disponible", nullable = false)
    @Schema(description = "Disponibilidad del artista para reservas o eventos", example = "true", required = true)
    private Boolean disponible;

    // Getters y Setters

    /**
     * Obtiene el ID del artista.
     * 
     * @return ID del artista.
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el ID del artista.
     * 
     * @param id Nuevo ID del artista.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre del artista.
     * 
     * @return Nombre del artista.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del artista.
     * 
     * @param nombre Nuevo nombre del artista.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la categoría del artista.
     * 
     * @return Categoría del artista.
     */
    public String getCategoria() {
        return categoria;
    }

    /**
     * Establece la categoría del artista.
     * 
     * @param categoria Nueva categoría del artista.
     */
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    /**
     * Obtiene la disponibilidad del artista.
     * 
     * @return Disponibilidad del artista.
     */
    public Boolean getDisponible() {
        return disponible;
    }

    /**
     * Establece la disponibilidad del artista.
     * 
     * @param disponible Nueva disponibilidad del artista.
     */
    public void setDisponible(Boolean disponible) {
        this.disponible = disponible;
    }
}
