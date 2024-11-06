package com.curso.service;

import com.curso.model.Empleado;
import java.util.List;
import java.util.Optional;

/**
 * interfaz service que declara los metodos que se implementaraen en EmpleadoServiceImpl
 * @author Victor Tercero
 * @version 1.21
 *
 */
public interface EmpleadoService {
    List<Empleado> getAllEmpleados();
    Empleado getEmpleadoById(int id);
    Empleado createEmpleado(Empleado empleado);
    Empleado updateEmpleado(int id, Empleado empleadoDetails);
    void deleteEmpleado(int id);
}
