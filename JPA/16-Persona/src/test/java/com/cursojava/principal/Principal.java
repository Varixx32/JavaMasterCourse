package com.cursojava.principal;

import java.util.List;

import com.cursojava.conexion.Conexion;
import com.cursojava.model.Persona;

public class Principal {
    public static void main(String[] args) {
        Conexion conexion = new Conexion();
        
        System.out.println("=== Buscar todo===");
        List<Persona> personasEnBD= conexion.buscarTodasLasPersonas();
        if (personasEnBD.isEmpty()) {
            System.out.println("No se encontraron personas en la base de datos");
        } else {
            for (Persona persona : personasEnBD) {
                System.out.println(persona);
            }
        }
        
        
        System.out.println("=== Buscar por ID ===");
        int id = 1;  
        Persona personaPorId = conexion.buscarPorId(id);
        System.out.println(personaPorId);

        
        System.out.println("=== Buscar por apellido1 ===");
        String apellido = "Perez";  
        List<Persona> personasPorApellido1 = conexion.buscarPorApellido(apellido);
        if (personasPorApellido1.isEmpty()) {
            System.out.println("No se encontraron personas con el apellido " + apellido);
        } else {
            for (Persona persona : personasPorApellido1) {
                System.out.println(persona);
            }
        }

        
        System.out.println("=== Buscar por apellido1 y apellido2 ===");
        String apellido2 = "Gomez";  
        List<Persona> personasPorApellidos = conexion.buscarPorAmbosApellidos(apellido, apellido2);
        if (personasPorApellidos.isEmpty()) {
            System.out.println("No se encontraron personas con los apellidos " + apellido + " y " + apellido2);
        } else {
            for (Persona persona : personasPorApellidos) {
                System.out.println(persona);
            }
        }
    }
}
