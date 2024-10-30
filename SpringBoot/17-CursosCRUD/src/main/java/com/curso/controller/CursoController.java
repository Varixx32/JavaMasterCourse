package com.curso.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import com.curso.model.Curso;
import com.curso.service.CursoService;

/**
 * Controlador REST para gestionar cursos.
 * @author Victor Tercero
 * @version 1.21
 */
@RestController
@RequestMapping("cursos")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    /**
     * Obtiene la lista de todos los cursos.
     * Simula el select de la base de datos
     *
     * @return Lista de cursos existentes.
     */
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Curso> cursos() {
        return cursoService.cursos();
    }

    /**
     * Busca un curso específico por su código.
     *
     * @param codCurso Código del curso a buscar.
     * @return El curso correspondiente al código proporcionado o null si no se encuentra.
     */
    @GetMapping(value = "/{codCurso}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Curso buscarCurso(@PathVariable int codCurso) {
        return cursoService.buscarCurso(codCurso);
    }

    /**
     * Da de alta un nuevo curso.
     *
     * @param curso Objeto Curso que contiene los datos del curso a agregar.
     * @return Lista de cursos existentes, incluyendo el nuevo curso.
     */
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<Curso> altaCurso(@RequestBody Curso curso) {
        cursoService.altaCurso(curso);
        return cursoService.cursos();
    }

    /**
     * Elimina un curso basado en su código.
     *
     * @param codCurso Código del curso a eliminar.
     * @return Lista de cursos existentes después de la eliminación.
     */
    @DeleteMapping(value = "/{codCurso}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Curso> eliminarCurso(@PathVariable int codCurso) {
        return cursoService.eliminarCurso(codCurso);
    }

    /**
     * Actualiza la duración de un curso.
     *
     * @param codCurso Código del curso cuya duración se va a actualizar.
     * @param duracion Nueva duración en horas del curso.
     */
    @PutMapping(value = "/{codCurso}/{duracion}")
    public void actualizarDuracion(@PathVariable int codCurso, @PathVariable int duracion) {
        cursoService.actualizarDuracion(codCurso, duracion);
    }

    /**
     * Obtiene una lista de cursos cuyo precio se encuentra dentro de un rango especificado.
     *
     * @param precioMin Precio mínimo del rango.
     * @param precioMax Precio máximo del rango.
     * @return Lista de cursos que cumplen con el criterio de precio.
     */
    @GetMapping(value = "/precio/{precioMin}/{precioMax}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Curso> cursosPorPrecio(@PathVariable double precioMin, @PathVariable double precioMax) {
        return cursoService.cursosPorPrecio(precioMin, precioMax);
    }
}
