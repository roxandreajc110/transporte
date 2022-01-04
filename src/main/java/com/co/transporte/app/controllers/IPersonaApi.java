package com.co.transporte.app.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.co.transporte.app.entities.Persona;

import io.swagger.annotations.ApiOperation;

@CrossOrigin("*")
@RequestMapping("/api/persona")
public interface IPersonaApi {

	@GetMapping(value = "/representanteLegal", produces = "application/json")
	@ApiOperation(value = "Servicio que retorna todos las figuras de representantes legales")
	ResponseEntity<List<Persona>> obtenerRepresentantesLegales();

}
