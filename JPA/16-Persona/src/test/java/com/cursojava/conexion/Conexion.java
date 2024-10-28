package com.cursojava.conexion;

import java.util.ArrayList;
import java.util.List;

import com.cursojava.model.Persona;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.TypedQuery;

public class Conexion {
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("personas");
	private EntityManager em = emf.createEntityManager();
	TypedQuery<Persona> persona; 
	
	/**
	 * buscarTodasLasPersonas ejecuta la query que busca las personas en la base de datos
	 * @return todas las personas almacenadas en la base de datos
	 */
	public List<Persona> buscarTodasLasPersonas() {
        List<Persona> personas = new ArrayList<Persona>();
        try {
            persona= em.createNamedQuery("Persona.buscarTodos", Persona.class);
            personas= persona.getResultList(); 
        } catch (Exception e) {
            e.printStackTrace(); 
        }
        return personas;
    }
	/**
	 * buscar por id busca una persona en la base de datos por id 
	 * @param id es el identificador unico de cada persona
	 * @return la persona que haya encontrado (salta un error si no encuentra a nadie) 
	 */
    public Persona buscarPorId(Integer id) {
        Persona persona = null;
        try {
            persona = em.find(Persona.class, id);
        } catch (PersistenceException e) {
            e.printStackTrace();
        }

        return persona;
    }
    /**
     * buscarPorApellido busca a las personas que compartan apellido, pueden ser una o varias
     * @param apellido a buscar en la BD
     * @return la lista de personas que tengan dicho apellido
     */
    public List<Persona> buscarPorApellido(String apellido) {
        List<Persona> personas = null;

        try {
            persona = em.createNamedQuery("Persona.BuscarPorUnApellido", Persona.class);
            persona.setParameter("apellido1", apellido);
            personas = persona.getResultList();
        } catch (PersistenceException e) {
            e.printStackTrace(); 
        }

        return personas;
    }
    /**
     * buscarPorAmbosApellidos busca a las personas teniendo en cuenta dos apellidos. Normalmente solo devolvera una persona pero puede darse la situacion de que compartan ambos apellidos por eso devuelve una lista.
     * @param apellido1
     * @param apellido2
     * @return personas con dichos apellidos
     */
    public List<Persona> buscarPorAmbosApellidos(String apellido1, String apellido2) {
        List<Persona> personas = null;

        try {
            persona = em.createNamedQuery("Persona.BuscarPorAmbosApellidos", Persona.class);
            persona.setParameter("apellido1", apellido1);
            persona.setParameter("apellido2", apellido2);
            personas = persona.getResultList();
        } catch (PersistenceException e) {
            e.printStackTrace(); 
        }

        return personas;
    }
}
