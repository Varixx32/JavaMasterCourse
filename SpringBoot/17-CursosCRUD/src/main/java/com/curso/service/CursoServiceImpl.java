package com.curso.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import com.curso.model.Curso;

/**
 * Implementación del servicio para gestionar cursos. Simula las operaciones que tipicamente se harian en la base de datos
 */
@Service
public class CursoServiceImpl implements CursoService {
    private List<Curso> cursos;

    /**
     * Constructor que inicializa la lista de cursos con datos de ejemplo. 
     */
    public CursoServiceImpl() {
        cursos = new ArrayList<>(List.of(
            new Curso(1, "Matemáticas", 40, 200.0),
            new Curso(2, "Historia", 30, 150.0),
            new Curso(3, "Inglés", 20, 100.0),
            new Curso(4, "Física", 40, 180.0),
            new Curso(5, "Química", 30, 150.0), 
            new Curso(6, "Biología", 25, 100.0), 
            new Curso(7, "Arte", 20, 120.0),
            new Curso(8, "Geografía", 40, 200.0), 
            new Curso(9, "Música", 25, 150.0),
            new Curso(10, "Economía", 30, 180.0), 
            new Curso(11, "Filosofía", 20, 200.0),
            new Curso(12, "Ciencias Sociales", 35, 150.0), 
            new Curso(13, "Computación", 25, 180.0),
            new Curso(14, "Programación", 30, 220.0),
            new Curso(15, "Robótica", 20, 250.0),
            new Curso(16, "Astronomía", 40, 300.0),
            new Curso(17, "Literatura", 40, 200.0), 
            new Curso(18, "Psicología", 30, 150.0), 
            new Curso(19, "Cálculo", 25, 180.0), 
            new Curso(20, "Fotografía", 20, 150.0) 
        ));
    }

    /**
     * Devuelve la lista de todos los cursos. Este metodo mantiene el encapsulamiento
     *
     * @return Lista de cursos.
     */
    @Override
    public List<Curso> cursos() {
        return cursos;
    }

    /**
     * Busca un curso específico por su código. Devuelve el curso si lo encuentra o null en el caso contrario
     *
     * @param codCurso Código del curso a buscar.
     * @return El curso encontrado o null si no existe.
     */
    @Override
    public Curso buscarCurso(int codCurso) {
        return cursos.stream()
                .filter(curso -> curso.getCodCurso() == codCurso).findFirst().orElse(null);
    }

    /**
     * Agrega un curso nuevo si no existe en la lista.
     *
     * @param curso El curso a agregar.
     */
    @Override
    public void altaCurso(Curso curso) {
        cursos.add(curso);
    }

    /**
     * Elimina un curso de la lista basado en su código.
     *
     * @param codCurso Código del curso a eliminar.
     * @return Lista actualizada de cursos después de la eliminación.
     */
    @Override
    public List<Curso> eliminarCurso(int codCurso) {
        cursos.removeIf(curso -> curso.getCodCurso() == codCurso); // Elimina el curso si encuentra coincidencia
        return cursos; // Devuelve la lista actualizada
    }

    /**
     * Actualiza la duración de un curso específico.
     *
     * @param codCurso Código del curso cuya duración se actualizará.
     * @param duracion Nueva duración en horas.
     */
    @Override
    public void actualizarDuracion(int codCurso, int duracion) {
        Curso curso = buscarCurso(codCurso);
        if (curso != null) {
            curso.setDuracion(duracion);
        }
    }

    /**
     * Filtra los cursos por un rango de precio.
     *
     * @param precioMin Precio mínimo del rango.
     * @param precioMax Precio máximo del rango.
     * @return Lista de cursos dentro del rango de precios especificado.
     */
    @Override
    public List<Curso> cursosPorPrecio(double precioMin, double precioMax) {
        return cursos.stream()
                .filter(curso -> curso.getPrecio() >= precioMin && curso.getPrecio() <= precioMax)
                .collect(Collectors.toList()); 
    }
}
