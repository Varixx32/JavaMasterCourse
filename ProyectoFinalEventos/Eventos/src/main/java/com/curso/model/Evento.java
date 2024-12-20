package com.curso.model;

import jakarta.persistence.*;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDate;

/**
 * Representa un evento en el sistema.
 * Esta entidad contiene información sobre el evento, como su nombre, categoría, fecha, ubicación, precio y disponibilidad.
 * 
 * @author Victor Tercero
 * @version: 1.21
 */
@Entity
@Table(name = "eventos")
@Schema(description = "Entidad que representa un evento")
public class Evento {

    /**
     * Identificador único del evento.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_evento")
    private Long id;

    /**
     * Nombre del evento.
     */
    @Column(name = "nombre", nullable = false, unique = true)
    private String nombre;

    /**
     * Categoría del evento (ejemplo: concierto, obra de teatro, festival).
     */
    @Column(name = "categoria", nullable = false)
    private String categoria;

    /**
     * Fecha del evento.
     */
    @Column(name = "fecha_evento", nullable = false)
    private LocalDate fecha;

    /**
     * Ubicación donde se llevará a cabo el evento.
     */
    @Column(name = "ubicacion", nullable = false)
    private String ubicacion;

    /**
     * Precio de entrada al evento.
     */
    @Column(name = "precio", nullable = false)
    private Double precio;

    /**
     * Indica si el evento está disponible para reservas o no.
     */
    @Column(name = "disponible", nullable = false)
    private Boolean disponible;

    // Getters y Setters

    /**
     * Obtiene el ID del evento.
     * 
     * @return ID del evento.
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el ID del evento.
     * 
     * @param id Nuevo ID del evento.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre del evento.
     * 
     * @return Nombre del evento.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del evento.
     * 
     * @param nombre Nuevo nombre del evento.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la categoría del evento.
     * 
     * @return Categoría del evento.
     */
    public String getCategoria() {
        return categoria;
    }

    /**
     * Establece la categoría del evento.
     * 
     * @param categoria Nueva categoría del evento.
     */
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    /**
     * Obtiene la fecha del evento.
     * 
     * @return Fecha del evento.
     */
    public LocalDate getFecha() {
        return fecha;
    }

    /**
     * Establece la fecha del evento.
     * 
     * @param fecha Nueva fecha del evento.
     */
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    /**
     * Obtiene la ubicación del evento.
     * 
     * @return Ubicación del evento.
     */
    public String getUbicacion() {
        return ubicacion;
    }

    /**
     * Establece la ubicación del evento.
     * 
     * @param ubicacion Nueva ubicación del evento.
     */
    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    /**
     * Obtiene el precio de la entrada al evento.
     * 
     * @return Precio del evento.
     */
    public Double getPrecio() {
        return precio;
    }

    /**
     * Establece el precio de la entrada al evento.
     * 
     * @param precio Nuevo precio del evento.
     */
    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    /**
     * Obtiene la disponibilidad del evento.
     * 
     * @return Disponibilidad del evento.
     */
    public Boolean getDisponible() {
        return disponible;
    }

    /**
     * Establece la disponibilidad del evento.
     * 
     * @param disponible Nueva disponibilidad del evento.
     */
    public void setDisponible(Boolean disponible) {
        this.disponible = disponible;
    }
}
