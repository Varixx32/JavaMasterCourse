package com.cursojava.consultas;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import com.cursojava.model.Pelicula;

import java.util.ArrayList;
import java.util.List;

public class Consultas {
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("videoclub");
	private EntityManager em = emf.createEntityManager();
	private TypedQuery<Pelicula> pelicula;
	
	/**
	 * buscarTodasLasPeliculas ejecuta la query para buscar todas las peliculas en la base de datos y devuelve una lista
	 * @return una lista con las peliculas encontrada
	 */
    public List<Pelicula> buscarTodasLasPeliculas() {
        List<Pelicula> peliculas = new ArrayList<Pelicula>();
        try {
            pelicula = em.createNamedQuery("Pelicula.buscarTodas", Pelicula.class);
            peliculas = pelicula.getResultList(); 
        } catch (Exception e) {
            e.printStackTrace(); 
        }
        return peliculas;
    }
    /**
     * buscarPorDirector busca las peliculas por director.
     * @param director
     * @return una lista con las peliculas encontradas con dicho director
     */
    public List<Pelicula> buscarPorDirector(String director) {
        List<Pelicula> peliculas = new ArrayList<Pelicula>();
        try {
        	pelicula= em.createNamedQuery("Pelicula.buscarPorDirector", Pelicula.class);
        	pelicula.setParameter("director", director); 
            peliculas = pelicula.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return peliculas;
    }
    /**
     * encontrar director por letra devuelve las peliculas que tengan un director que empieza por una letra
     * @param letra
     * @return una lista con las peliculas encontradas con directores con la letra especificada
     */
    public List<Pelicula> encontrarDirectorPorLetra(String letra) {
        List<Pelicula> peliculas = new ArrayList<Pelicula>();
        try {
        	pelicula= em.createNamedQuery("Pelicula.encontrarDirectorPorLetra", Pelicula.class);
        	pelicula.setParameter("letra", letra + "%"); 
            peliculas = pelicula.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return peliculas;
    }
/**
 * encontrarPorRangoDePrecio ejecuta la query en la base de datos que encuentra todas las peliculas en un rango de precio predeterminado
 * @param precioMinimo es el tope de precio por bajo 
 * @param precioMaximo es el tope de precio por alto
 * @return la lista de peliculas encontradas que estan dentro de ese rango de precio
 */
    public List<Pelicula> encontrarPorRangoDePrecio(double precioMinimo, double precioMaximo) {
        List<Pelicula> peliculas = new ArrayList<Pelicula>();
        try {
        	pelicula= em.createNamedQuery("Pelicula.encontrarPorRangoDePrecio", Pelicula.class);
        	pelicula.setParameter("precioMinimo", precioMinimo);
        	pelicula.setParameter("precioMaximo", precioMaximo);
            peliculas = pelicula.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return peliculas;
    }
    
    /**
     *	encontrarPorPrecio agrupa todas las peliculas por su precio
     * @return Este es el mas interesante ya que la query devuelve un Double y un Long correspondiente al numero almacenado y a la cantidad de peliculas que ha conseguido agrupar. Por tanto devuelve una array de Objetos default en el que solo contiene los datos devueltos
     *	por este mismo motivo he tenido que reinstanciar la query ya que habia aprovechado una comun para el resto de metodos ya que partian de la entity pelicula pero en este caso el Objecto no se corresponde la tabla por lo que tiene su propia typedQuery
     */

    public List<Object[]> encontrarPorPrecio() {
        List<Object[]> resultados = new ArrayList<Object[]>();
        try {
            TypedQuery<Object[]> query = em.createNamedQuery("Pelicula.encontrarPorPrecio", Object[].class);
            resultados = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultados; 
    }    
}
