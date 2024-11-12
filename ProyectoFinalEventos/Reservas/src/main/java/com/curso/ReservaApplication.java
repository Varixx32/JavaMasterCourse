package com.curso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

/**
 * Clase principal de la aplicación Spring Boot para el microservicio de Reservas.
 * Configura y ejecuta el microservicio de Reservas.
 */
@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "API de Reservas", version = "1.0", description = "API para gestionar reservas en el sistema"))
public class ReservaApplication {

    /**
     * Método principal para ejecutar la aplicación de Spring Boot.
     *
     * @param args Argumentos de línea de comandos.
     */
    public static void main(String[] args) {
        SpringApplication.run(ReservaApplication.class, args);
    }

    /**
     * Define un bean RestTemplate que permite realizar solicitudes HTTP a otros servicios.
     *
     * @return Una instancia de RestTemplate configurada.
     */
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
