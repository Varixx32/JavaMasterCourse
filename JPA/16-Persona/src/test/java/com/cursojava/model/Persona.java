package com.cursojava.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

@Entity
@Table(name = "personas")
@NamedQueries({
    @NamedQuery(name = "Persona.buscarTodos", query = "SELECT p FROM Persona p"),
    @NamedQuery(name = "Persona.BuscarPorUnApellido", query = "SELECT p FROM Persona p WHERE p.apellido1 = :apellido1"),
    @NamedQuery(name = "Persona.BuscarPorAmbosApellidos", query = "SELECT p FROM Persona p WHERE p.apellido1 = :apellido1 AND p.apellido2 = :apellido2")
})

public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "apellido1", nullable = false)
    private String apellido1;

    @Column(name = "apellido2")
    private String apellido2;

    @Column(name = "telefono", unique = true, nullable = false)
    private String telefono;

    // Constructores
    public Persona() {}

  
    public Persona(String nombre, String apellido1, String apellido2, String telefono) {
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.telefono = telefono;
    }

    // Getters y Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "-----------------------------\n" +
               "Persona:\n" +
               "  ID         : " + id + "\n" +
               "  Nombre     : " + nombre + "\n" +
               "  Apellido 1 : " + apellido1 + "\n" +
               "  Apellido 2 : " + apellido2 + "\n" +
               "  Teléfono   : " + telefono + "\n" +
               "-----------------------------";
    }

}

