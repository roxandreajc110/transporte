package com.co.transporte.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.co.transporte.app.entities.Persona;
import com.co.transporte.app.services.IPersonaService;

@RestController
public class PersonaApiController implements IPersonaApi {

	@Autowired
	private IPersonaService personaSevice;
	
	public ResponseEntity<List<Persona>> obtenerRepresentantesLegales() {
		return new ResponseEntity<>(personaSevice.obtenerRepresentantesLegales(),
				HttpStatus.OK);
	}

}
