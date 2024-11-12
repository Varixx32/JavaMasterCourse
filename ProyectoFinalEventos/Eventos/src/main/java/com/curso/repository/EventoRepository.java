package com.curso.repository;

import com.curso.model.Evento;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

/**
 * Repositorio de acceso a datos para la entidad evento.
 * Proporciona métodos CRUD y consultas personalizadas para gestionar eventos.
 * 
 * @author Victor Tercero
 * @version: 1.21
 */
public interface EventoRepository extends JpaRepository<Evento, Long> {

    /**
     * Busca y retorna todos los eventos que están disponibles.
     *
     * @return Una lista de eventos disponibles.
     */
    List<Evento> findByDisponibleTrue();

    /**
     * Busca un evento por su nombre.
     *
     * @param nombre Nombre del evento.
     * @return El evento encontrado o null si no existe.
     */
    Evento findByNombre(String nombre);
}
