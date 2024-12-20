package com.curso;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * Clase principal de la aplicación Spring Boot para el microservicio de Artistas.
 * Proporciona configuración básica de inicio y el bean RestTemplate.
 * 
 * @author Victor Tercero
 * @version: 1.21
 */
@SpringBootApplication(scanBasePackages = {"com.curso.controller", "com.curso.service"})
public class ArtistasApplication {

    /**
     * Método principal para ejecutar la aplicación.
     *
     * @param args Argumentos de línea de comandos.
     */
    public static void main(String[] args) {
        SpringApplication.run(ArtistasApplication.class, args);
    }

    /**
     * Define un bean RestTemplate que permite realizar solicitudes HTTP a otros servicios.
     *
     * @return Una instancia de RestTemplate configurada.
     */
    @Bean
    RestTemplate template() {
        return new RestTemplate();
    }
}
