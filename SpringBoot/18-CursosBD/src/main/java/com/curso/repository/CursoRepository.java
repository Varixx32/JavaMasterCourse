package com.curso.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import com.curso.model.Curso;

/**
 * El repositorio que JPA utiliza para comunicarse con la base de datos
 * Debe devlarar el findBetweenPrecio ya que es el unico metodo que JPA no tiene por defecto.
 * @author Victor Tercero
 * @version 1.21
 *
 */
@Repository
public interface CursoRepository extends JpaRepository<Curso, Integer> {
    List<Curso> findBetweenPrecio(double precioMin, double precioMax);
}
