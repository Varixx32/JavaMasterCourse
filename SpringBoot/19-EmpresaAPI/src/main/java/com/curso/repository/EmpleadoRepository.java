package com.curso.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.curso.model.Empleado;

/**
 * El repositorio que JPA utiliza para comunicarse con la base de datos
 * @author Victor Tercero
 * @version 1.21
 *
 */
@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Integer> {
}
