package com.curso.model;

import jakarta.persistence.*;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Representa una reserva en el sistema.
 * Esta entidad contiene información sobre la reserva, como el nombre del cliente, DNI, ID del evento y ID del artista.
 */
@Entity
@Table(name = "reservas")
@Schema(description = "Entidad que representa una reserva")
public class Reserva {

    /**
     * Identificador único de la reserva.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reserva")
    @Schema(description = "Identificador único de la reserva", example = "1", accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    /**
     * Nombre del cliente que realiza la reserva.
     */
    @Column(name = "nombre_cliente", nullable = false)
    @Schema(description = "Nombre del cliente que realiza la reserva", example = "Juan Pérez", required = true)
    private String nombreCliente;

    /**
     * DNI del cliente que realiza la reserva.
     */
    @Column(name = "dni", nullable = false, unique = true)
    @Schema(description = "DNI del cliente que realiza la reserva", example = "12345678X", required = true)
    private String dni;

    /**
     * Identificador del evento asociado a la reserva.
     */
    @Column(name = "id_evento", nullable = false)
    @Schema(description = "Identificador del evento asociado a la reserva", example = "1001", required = true)
    private Long idEvento;

    /**
     * Identificador del artista asociado a la reserva.
     */
    @Column(name = "id_artista", nullable = false)
    @Schema(description = "Identificador del artista asociado a la reserva", example = "2001", required = true)
    private Long idArtista;

    // Getters y Setters

    /**
     * Obtiene el ID de la reserva.
     *
     * @return ID de la reserva.
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el ID de la reserva.
     *
     * @param id Nuevo ID de la reserva.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre del cliente.
     *
     * @return Nombre del cliente.
     */
    public String getNombreCliente() {
        return nombreCliente;
    }

    /**
     * Establece el nombre del cliente.
     *
     * @param nombreCliente Nuevo nombre del cliente.
     */
    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    /**
     * Obtiene el DNI del cliente.
     *
     * @return DNI del cliente.
     */
    public String getDni() {
        return dni;
    }

    /**
     * Establece el DNI del cliente.
     *
     * @param dni Nuevo DNI del cliente.
     */
    public void setDni(String dni) {
        this.dni = dni;
    }

    /**
     * Obtiene el ID del evento asociado.
     *
     * @return ID del evento asociado.
     */
    public Long getIdEvento() {
        return idEvento;
    }

    /**
     * Establece el ID del evento asociado.
     *
     * @param idEvento Nuevo ID del evento asociado.
     */
    public void setIdEvento(Long idEvento) {
        this.idEvento = idEvento;
    }

    /**
     * Obtiene el ID del artista asociado.
     *
     * @return ID del artista asociado.
     */
    public Long getIdArtista() {
        return idArtista;
    }

    /**
     * Establece el ID del artista asociado.
     *
     * @param idArtista Nuevo ID del artista asociado.
     */
    public void setIdArtista(Long idArtista) {
        this.idArtista = idArtista;
    }
}
