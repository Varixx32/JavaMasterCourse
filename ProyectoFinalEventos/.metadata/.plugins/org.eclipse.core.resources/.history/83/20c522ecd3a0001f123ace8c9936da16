package com.curso.repository;

import com.curso.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

/**
 * Repositorio de acceso a datos para la entidad {@link Reserva}.
 * Proporciona métodos CRUD y consultas personalizadas para gestionar reservas.
 */
public interface ReservaRepository extends JpaRepository<Reserva, Long> {

    /**
     * Busca y retorna todas las reservas asociadas a un evento específico.
     *
     * @param idEvento ID del evento para el cual se desean obtener las reservas.
     * @return Una lista de reservas asociadas al evento especificado.
     */
    List<Reserva> findByIdEvento(Long idEvento);
}
