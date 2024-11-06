package com.curso.service;

import com.curso.model.Empleado;
import com.curso.repository.EmpleadoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {

    private final EmpleadoRepository empleadoRepository;

    @Autowired
    public EmpleadoServiceImpl(EmpleadoRepository empleadoRepository) {
        this.empleadoRepository = empleadoRepository;
    }

    @Override
    public List<Empleado> getAllEmpleados() {
        return empleadoRepository.findAll();
    }

    @Override
    public Empleado getEmpleadoById(int id) {
        return empleadoRepository.findById(id).orElse(null);
    }

    @Override
    public Empleado createEmpleado(Empleado empleado) {
        return empleadoRepository.save(empleado);
    }

    @Override
    public Empleado updateEmpleado(int id, Empleado empleadoUpdated) {
        Empleado empleado = empleadoRepository.findById(id).orElse(null);
        if (empleado != null) {
            empleado.setNombre(empleadoUpdated.getNombre());
            empleado.setApellido1(empleadoUpdated.getApellido1());
            empleado.setApellido2(empleadoUpdated.getApellido2());
            empleado.setFechaNacimiento(empleadoUpdated.getFechaNacimiento());
            empleado.setSalario(empleadoUpdated.getSalario());
            return empleadoRepository.save(empleado);
        } else {
            return null;
        }
    }

    @Override
    public void deleteEmpleado(int id) {
        if (empleadoRepository.existsById(id)) {
            empleadoRepository.deleteById(id);
        } else {
            throw new RuntimeException("Empleado no encontrado con id: " + id);
        }
    }
}
