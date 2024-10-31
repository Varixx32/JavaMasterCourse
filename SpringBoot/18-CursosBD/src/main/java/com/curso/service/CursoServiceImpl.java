package com.curso.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.model.Curso;
import com.curso.repository.CursoRepository;

/**
 * Implementación del servicio para gestionar cursos utilizando JPA y base de datos.
 */
@Service
public class CursoServiceImpl implements CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    /**
     * Devuelve la lista de todos los cursos desde la base de datos.
     *
     * @return Lista de cursos.
     */
    @Override
    public List<Curso> cursos() {
        return cursoRepository.findAll();
    }

    /**
     * Busca un curso específico por su código en la base de datos.
     *
     * @param codCurso Código del curso a buscar.
     * @return El curso encontrado o null si no existe.
     */
    @Override
    public Curso buscarCurso(int codCurso) {
        return cursoRepository.findById(codCurso).orElse(null);
    }

    /**
     * Agrega un curso nuevo a la base de datos.
     *
     * @param curso El curso a agregar.
     */
    @Override
    public void altaCurso(Curso curso) {
        cursoRepository.save(curso);
    }

    /**
     * Elimina un curso de la base de datos basado en su código.
     *
     * @param codCurso Código del curso a eliminar.
     * @return Lista actualizada de cursos después de la eliminación.
     */
    @Override
    public List<Curso> eliminarCurso(int codCurso) {
        cursoRepository.deleteById(codCurso);
        return cursoRepository.findAll(); // Devuelve la lista actualizada
    }

    /**
     * Actualiza la duración de un curso específico en la base de datos.
     *
     * @param codCurso Código del curso cuya duración se actualizará.
     * @param duracion Nueva duración en horas.
     */
    @Override
    public void actualizarDuracion(int codCurso, int duracion) {
        Curso curso = buscarCurso(codCurso);
        if (curso != null) {
            curso.setDuracion(duracion);
            cursoRepository.save(curso);
        }
    }

    /**
     * Filtra los cursos por un rango de precio utilizando una consulta JPA.
     *
     * @param precioMin Precio mínimo del rango.
     * @param precioMax Precio máximo del rango.
     * @return Lista de cursos dentro del rango de precios especificado.
     */
    @Override
    public List<Curso> cursosEntrePrecios(double precioMin, double precioMax) {
        return cursoRepository.findBetweenPrecio(precioMin, precioMax);
    }
}
