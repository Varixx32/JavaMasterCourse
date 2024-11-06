package com.curso.model;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * La clase Empleado es una clase que mapea la entidad de empleados en la base de datos.
 * @author: Victor Tercero
 * @version: 1.21
 */
@Entity
@Table(name = "empleado")
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nombre;

    private String apellido1;

    private String apellido2;

    @Column(name = "fecha_nacimiento")
    private LocalDate fechaNacimiento;

    private double salario;

    // Constructores

    // Constructor sin id para insertarlo en la base de datos.
    public Empleado(String nombre, String apellido1, String apellido2, LocalDate fechaNacimiento, double salario) {
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.fechaNacimiento = fechaNacimiento;
        this.salario = salario;
    }

    // Constructor con id para cuando ejecutamos el método de recuperar los empleados de la BD
    public Empleado(int id, String nombre, String apellido1, String apellido2, LocalDate fechaNacimiento, double salario) {
        this.id = id;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.fechaNacimiento = fechaNacimiento;
        this.salario = salario;
    }

    // Constructor vacío
    public Empleado() {}

    // Getters y Setters (El setter de ID está eliminado ya que debemos asegurarnos que el ID lo gestiona únicamente la BD)

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
}
