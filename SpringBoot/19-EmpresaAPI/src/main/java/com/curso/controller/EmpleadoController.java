package com.curso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curso.model.Empleado;
import com.curso.service.EmpleadoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * Controlador REST para gestionar empleados.
 * Este controlador expone endpoints para obtener, crear, actualizar y eliminar empleados.
 */
@Tag(name = "Empleados", description = "API para gestionar empleados")
@RestController
@RequestMapping("/api/empleados")
public class EmpleadoController {

    private final EmpleadoService empleadoService;

    @Autowired
    public EmpleadoController(EmpleadoService empleadoService) {
        this.empleadoService = empleadoService;
    }

    /**
     * Obtiene todos los empleados.
     *
     * @return Lista de todos los empleados.
     */
    @Operation(summary = "Obtener todos los empleados")
    @GetMapping
    public List<Empleado> getAllEmpleados() {
        return empleadoService.getAllEmpleados();
    }

    /**
     * Obtiene un empleado por su ID.
     *
     * @param id Identificador único del empleado.
     * @return El empleado correspondiente o un 404 si no se encuentra.
     */
    @Operation(summary = "Obtener un empleado por ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Empleado encontrado"),
        @ApiResponse(responseCode = "404", description = "Empleado no encontrado")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Empleado> getEmpleadoById(@PathVariable int id) {
        Empleado empleado = empleadoService.getEmpleadoById(id);
        return empleado != null ? ResponseEntity.ok(empleado) : ResponseEntity.notFound().build();
    }

    /**
     * Crea un nuevo empleado.
     *
     * @param empleado Datos del empleado a crear.
     * @return El empleado creado.
     */
    @Operation(summary = "Crear un nuevo empleado")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Empleado creado"),
        @ApiResponse(responseCode = "400", description = "Solicitud inválida")
    })
    @PostMapping
    public ResponseEntity<Empleado> createEmpleado(@RequestBody Empleado empleado) {
        Empleado nuevoEmpleado = empleadoService.createEmpleado(empleado);
        return ResponseEntity.status(201).body(nuevoEmpleado);
    }

    /**
     * Actualiza un empleado existente.
     *
     * @param id Identificador único del empleado a actualizar.
     * @param empleadoUpdated Datos actualizados del empleado.
     * @return El empleado actualizado o un 404 si no se encuentra.
     */
    @Operation(summary = "Actualizar un empleado existente")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Empleado actualizado"),
        @ApiResponse(responseCode = "404", description = "Empleado no encontrado")
    })
    @PutMapping("/{id}")
    public ResponseEntity<Empleado> updateEmpleado(@PathVariable int id, @RequestBody Empleado empleadoUpdated) {
        Empleado empleado = empleadoService.updateEmpleado(id, empleadoUpdated);
        return empleado != null ? ResponseEntity.ok(empleado) : ResponseEntity.notFound().build();
    }

    /**
     * Elimina un empleado por su ID.
     *
     * @param id Identificador único del empleado a eliminar.
     * @return 204 si el empleado fue eliminado o 404 si no se encuentra.
     */
    @Operation(summary = "Eliminar un empleado")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "204", description = "Empleado eliminado"),
        @ApiResponse(responseCode = "404", description = "Empleado no encontrado")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmpleado(@PathVariable int id) {
        try {
            empleadoService.deleteEmpleado(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
