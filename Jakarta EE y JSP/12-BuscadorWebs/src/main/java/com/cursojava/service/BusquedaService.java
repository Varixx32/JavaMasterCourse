package com.cursojava.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.cursojava.model.Website;

/*
 * 
 * La clase BusquedaService ejecuta una operacion de busqueda entre las paginas web indexadas.
 * @author: Victor
 * @version: 1.21
 **/

public class BusquedaService {
	//Lista de las paginas web indexadas
	static List<Website> websitesIndexadas = List.of(
		    new Website("https://www.wikipedia.org", "Educacion", "Enciclopedia colaborativa de contenido libre."),
		    new Website("https://www.github.com", "Tecnologia", "Plataforma de alojamiento de repositorios Git para proyectos de software."),
		    new Website("https://www.stackoverflow.com", "Tecnologia", "Comunidad de preguntas y respuestas para programadores."),
		    new Website("https://www.medium.com", "Cultura", "Plataforma de blogs donde las personas publican articulos en varias tematicas."),
		    new Website("https://www.reddit.com", "Cultura", "Comunidad de foros donde los usuarios pueden discutir cualquier tema."),
		    new Website("https://www.khanacademy.org", "Educacion", "Plataforma gratuita de educacion online con cursos interactivos."),
		    new Website("https://www.coursera.org", "Educacion", "Cursos online masivos abiertos (MOOC) ofrecidos por universidades."),
		    new Website("https://www.udemy.com", "Educacion", "Marketplace de cursos online sobre una amplia variedad de temas."),
		    new Website("https://www.edx.org", "Educacion", "Plataforma de aprendizaje online fundada por MIT y Harvard."),
		    new Website("https://www.codecademy.com", "Tecnologia", "Plataforma interactiva para aprender a programar en linea."),
		    new Website("https://www.producthunt.com", "Tecnologia", "Sitio web para descubrir productos nuevos e innovadores."),
		    new Website("https://www.news.ycombinator.com", "Tecnologia", "Foro donde se discuten noticias tecnologicas y de startups."),
		    new Website("https://www.theverge.com", "Tecnologia", "Medio de comunicacion especializado en tecnologia y cultura digital."),
		    new Website("https://www.nytimes.com", "Noticias", "Periodico estadounidense que cubre noticias internacionales y nacionales."),
		    new Website("https://www.bbc.com", "Noticias", "Medio britanico que cubre noticias a nivel mundial."),
		    new Website("https://www.cnn.com", "Noticias", "Canal de noticias estadounidense que cubre noticias de todo el mundo."),
		    new Website("https://www.bloomberg.com", "Economia", "Provee noticias y analisis sobre mercados financieros y negocios."),
		    new Website("https://www.wsj.com", "Economia", "Periodico centrado en noticias economicas y financieras."),
		    new Website("https://www.quora.com", "Cultura", "Comunidad de preguntas y respuestas en la que los usuarios comparten conocimientos."),
		    new Website("https://www.linkedin.com", "Profesional", "Red social orientada a negocios, empleo y conexiones profesionales."),
		    new Website("https://www.behance.net", "Cultura", "Plataforma donde los disenadores muestran y descubren portafolios creativos."),
		    new Website("https://www.dribbble.com", "Cultura", "Comunidad de disenadores para mostrar trabajos creativos y obtener feedback."),
		    new Website("https://www.deviantart.com", "Cultura", "Comunidad en linea donde artistas comparten y promocionan su trabajo."),
		    new Website("https://www.pinterest.com", "Cultura", "Plataforma para descubrir ideas y proyectos creativos mediante imagenes."),
		    new Website("https://www.amazon.com", "Economia", "Plataforma de comercio electronico que ofrece productos y servicios a nivel global."),
		    new Website("https://www.ebay.com", "Economia", "Mercado online donde usuarios pueden comprar y vender productos."),
		    new Website("https://www.alibaba.com", "Economia", "Plataforma de comercio electronico orientada a negocios mayoristas."),
		    new Website("https://www.netflix.com", "Entretenimiento", "Plataforma de streaming de series y peliculas por suscripcion."),
		    new Website("https://www.spotify.com", "Entretenimiento", "Plataforma de streaming de musica, podcasts y contenido de audio."),
		    new Website("https://www.youtube.com", "Entretenimiento", "Plataforma de videos donde los usuarios pueden subir, ver y compartir contenido."),
		    new Website("https://www.vimeo.com", "Entretenimiento", "Plataforma de videos con un enfoque en contenido de alta calidad y cine."),
		    new Website("https://www.twitch.tv", "Entretenimiento", "Plataforma de transmision en vivo, popular entre los gamers."),
		    new Website("https://www.ted.com", "Educacion", "Plataforma de charlas inspiradoras sobre diversos temas, presentadas por expertos."),
		    new Website("https://www.airbnb.com", "Viajes", "Marketplace de alquileres de corta duracion entre particulares."),
		    new Website("https://www.booking.com", "Viajes", "Plataforma para reservar alojamiento en cualquier parte del mundo."),
		    new Website("https://www.tripadvisor.com", "Viajes", "Sitio web de resenas y comparaciones de viajes y turismo."),
		    new Website("https://www.skyscanner.com", "Viajes", "Motor de busqueda de vuelos, hoteles y alquiler de autos."),
		    new Website("https://www.expedia.com", "Viajes", "Agencia de viajes en linea para la compra de vuelos, hoteles y paquetes turisticos."),
		    new Website("https://www.weather.com", "Noticias", "Portal con informacion sobre el clima global y pronosticos meteorologicos."),
		    new Website("https://www.nationalgeographic.com", "Ciencia", "Revista y sitio web que cubre temas de ciencia, historia y exploracion."),
		    new Website("https://www.sciencemag.org", "Ciencia", "Publicacion que cubre avances en ciencia e investigaciones."),
		    new Website("https://www.nature.com", "Ciencia", "Revista cientifica que publica investigaciones de alta calidad en varios campos."),
		    new Website("https://www.arxiv.org", "Ciencia", "Repositorio gratuito de preprints academicos en ciencia, matematicas y computacion."),
		    new Website("https://www.acm.org", "Ciencia", "Asociacion profesional para investigadores en ciencias computacionales."),
		    new Website("https://www.figma.com", "Tecnologia", "Herramienta de diseno colaborativo para interfaces de usuario y prototipos."),
		    new Website("https://www.canva.com", "Tecnologia", "Plataforma de diseno grafico facil de usar para crear contenido visual."),
		    new Website("https://www.pexels.com", "Cultura", "Banco de imagenes y videos gratuitos de alta calidad."),
		    new Website("https://www.unsplash.com", "Cultura", "Plataforma con fotografias gratuitas de alta calidad.")
		);

	/*
	 * buscar busca por tematica en la array de websites
	 * @params: la tematica a buscar
	 * @returns: una arraylist con las paginas web que coincidan con la tematica seleccionada
	 */
	public static ArrayList<Website> buscar (String tematica){
		return websitesIndexadas.stream()
			    .filter(x -> x.getTematica().equals(tematica))
			    .collect(Collectors.toCollection(ArrayList::new));
	}
}
