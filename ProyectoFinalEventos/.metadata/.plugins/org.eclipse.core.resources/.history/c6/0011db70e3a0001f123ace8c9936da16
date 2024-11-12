package com.curso.service;

import com.curso.model.Evento;
import com.curso.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementación de la interfaz EventoService.
 */
@Service
public class EventoServiceImpl implements EventoService {

    @Autowired
    private EventoRepository eventoRepository;

    /**
     * Obtiene una lista de todos los eventos disponibles.
     *
     * @return Lista de eventos disponibles.
     */
    @Override
    public List<Evento> obtenerEventosDisponibles() {
        return eventoRepository.findByDisponibleTrue();
    }

    /**
     * Obtiene un evento específico por su nombre.
     *
     * @param nombre El nombre del evento.
     * @return El evento correspondiente al nombre o null si no existe.
     */
    @Override
    public Evento obtenerEventoPorNombre(String nombre) {
        return eventoRepository.findByNombre(nombre);
    }

    /**
     * Obtiene un evento específico por su ID.
     *
     * @param id El ID del evento.
     * @return El evento correspondiente al ID o null si no existe.
     */
    @Override
    public Evento obtenerEventoPorId(Long id) {
        return eventoRepository.findById(id).orElse(null);
    }

    /**
     * Guarda un nuevo evento en la base de datos.
     *
     * @param evento El evento a guardar.
     * @return El evento guardado.
     */
    @Override
    public Evento guardarEvento(Evento evento) {
        return eventoRepository.save(evento);
    }
}
