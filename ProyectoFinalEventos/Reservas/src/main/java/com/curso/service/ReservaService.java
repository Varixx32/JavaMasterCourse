package com.curso.service;

import com.curso.model.Reserva;
import java.util.List;
/**
 * Service de reserva
 * @author Victor Tercero
 * @version: 1.21
 *
 */
public interface ReservaService {
    Reserva crearReserva(Reserva reserva);
    List<Reserva> obtenerReservasPorEvento(Long idEvento);
}
