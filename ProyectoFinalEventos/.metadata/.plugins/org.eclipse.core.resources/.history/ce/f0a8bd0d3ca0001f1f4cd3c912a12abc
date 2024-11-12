package com.curso.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.curso.model.CursoDto;
import com.curso.model.Formacion;
@Service
public class FormacionServiceImpl implements FormacionService {
	@Autowired
	RestTemplate template;
	
	private static final String URL = "http://localhost:8080/cursos";
	@Override
	public List<Formacion> getFormaciones() {
		List<CursoDto> cursos = Arrays.asList(template.getForObject(URL, CursoDto[].class));
		List<Formacion> formaciones = new ArrayList<Formacion>();

		for (CursoDto curso : cursos) {
			int asignaturas = curso.getDuracion() >= 50 ? 10 : 5;
			formaciones.add(new Formacion(curso.getNombre(), asignaturas, curso.getPrecio()));
		}

		return formaciones;
	}

	@Override
	public void altaFormacion(Formacion formacion) {

		List <CursoDto> cursos = Arrays.asList(template.getForObject(URL, CursoDto[].class));
		CursoDto cursoInsertar = new CursoDto(formacion.getNombre(), formacion.getAsignaturas() * 10, formacion.getPrecio());
		boolean existeCurso = false;
		
		for (CursoDto curso:cursos) {
			if(curso.getNombre().equalsIgnoreCase(formacion.getNombre())) {
				existeCurso = true;
			}
		}
		if (!existeCurso) {
			template.postForLocation(URL, cursoInsertar);
		}
	}
}
