package com.cursojava.interfaz;

/**
 * Interfaz conducible que implementaran todos los vehiculos con metodos que emulan la conduccion
 * @author Victor Tercero
 * @version 1.21
 *
 */

public interface Conducible {
	public void parar(); 
	public void arrancar(); 
	public void avanzar(double metros , double segundos); 
}
