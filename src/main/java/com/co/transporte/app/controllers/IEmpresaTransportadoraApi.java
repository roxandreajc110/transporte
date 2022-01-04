package com.co.transporte.app.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.co.transporte.app.domains.PersonaDTO;
import com.co.transporte.app.entities.Persona;
import com.co.transporte.app.util.View;
import com.fasterxml.jackson.annotation.JsonView;

import io.swagger.annotations.ApiOperation;

@CrossOrigin("*")
@RequestMapping("/api/empresaTransportadora")
public interface IEmpresaTransportadoraApi {

	@GetMapping(value = "/", produces = "application/json")
	@ApiOperation(value = "Servicio que retorna todas las empresas transportadores creadas")
	@JsonView(View.EmpresaTransportadora.class)
	ResponseEntity<List<Persona>> obtenerEmpresasTransportadoras();
	
	@PostMapping(value = "/", produces = "application/json")
	@ApiOperation(value = "Servicio para la creación de una empresa transportadora")
	ResponseEntity<Map<String, Object>> crearEmpresaTransportadora(@RequestBody PersonaDTO personaDTO);
	
}
