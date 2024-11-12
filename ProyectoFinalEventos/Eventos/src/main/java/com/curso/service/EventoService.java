package com.curso.service;

import com.curso.model.Evento;

import java.util.List;

/**
 * Interfaz para los servicios relacionados con los eventos.
 */
public interface EventoService {

    /**
     * Obtiene una lista de todos los eventos disponibles.
     *
     * @return Lista de eventos disponibles.
     */
    List<Evento> obtenerEventosDisponibles();

    /**
     * Obtiene un evento específico por su nombre.
     *
     * @param nombre El nombre del evento.
     * @return El evento correspondiente al nombre o null si no existe.
     */
    Evento obtenerEventoPorNombre(String nombre);

    /**
     * Obtiene un evento específico por su ID.
     *
     * @param id El ID del evento.
     * @return El evento correspondiente al ID o null si no existe.
     */
    Evento obtenerEventoPorId(Long id);

    /**
     * Guarda un nuevo evento en la base de datos.
     *
     * @param evento El evento a guardar.
     * @return El evento guardado.
     */
    Evento guardarEvento(Evento evento);
}
