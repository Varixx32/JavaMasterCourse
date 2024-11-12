package com.curso.service;

import com.curso.model.Reserva;
import com.curso.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementación de ReservaService para gestionar la lógica de negocio relacionada con las reservas.
 * @author Victor Tercero
 * @version: 1.21
 *
 */
@Service
public class ReservaServiceImpl implements ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;

    /**
     * Crea una nueva reserva en el sistema.
     *
     * @param reserva Objeto Reserva que contiene los datos de la nueva reserva.
     * @return La reserva creada.
     */
    @Override
    public Reserva crearReserva(Reserva reserva) {
        return reservaRepository.save(reserva);
    }

    /**
     * Obtiene una lista de todas las reservas asociadas a un evento específico.
     *
     * @param idEvento ID del evento para el cual se desean obtener las reservas.
     * @return Lista de reservas asociadas al evento especificado.
     */
    @Override
    public List<Reserva> obtenerReservasPorEvento(Long idEvento) {
        return reservaRepository.findByIdEvento(idEvento);
    }
}
