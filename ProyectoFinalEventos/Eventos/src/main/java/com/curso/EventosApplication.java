package com.curso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

/**
 * Clase principal de la aplicación Spring Boot para el microservicio de Eventos.
 * Inicializa y ejecuta el microservicio.
 * 	
 * @author Victor Tercero
 * @version: 1.21
 */
@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "API de Eventos", version = "1.21", description = "API para gestionar eventos en el sistema"))
public class EventosApplication {

    /**
     * Método principal que inicia la aplicación Spring Boot.
     *
     * @param args Argumentos de línea de comandos.
     */
    public static void main(String[] args) {
        SpringApplication.run(EventosApplication.class, args);
    }
}
