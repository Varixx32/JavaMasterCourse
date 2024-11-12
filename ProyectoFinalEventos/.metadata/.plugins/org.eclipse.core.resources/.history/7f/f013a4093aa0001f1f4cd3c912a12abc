package com.curso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.curso.model.Formacion;
import com.curso.service.FormacionService;

@RestController
public class FormacionController {
	
	@Autowired
	private FormacionService formacionService;
	
	@GetMapping(value = "formacion", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Formacion> getFormaciones(){
		return formacionService.getFormaciones();
	}
	
	@PostMapping(value = "formacion", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void altaFormacion(@RequestBody Formacion formacion){
		formacionService.altaFormacion(formacion);
	}	
}
