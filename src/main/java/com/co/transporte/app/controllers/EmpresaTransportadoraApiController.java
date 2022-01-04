package com.co.transporte.app.controllers;

import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.co.transporte.app.domains.PersonaDTO;
import com.co.transporte.app.entities.Persona;
import com.co.transporte.app.services.IEmpresaTransportadoraService;

@RestController
public class EmpresaTransportadoraApiController implements IEmpresaTransportadoraApi {

	@Autowired
	private IEmpresaTransportadoraService empresaTransportadoraSevice;

	public ResponseEntity<List<Persona>> obtenerEmpresasTransportadoras() {
		return new ResponseEntity<>(empresaTransportadoraSevice.obtenerEmpresasTransportadoras(), HttpStatus.OK);
	}

	public ResponseEntity<Map<String, Object>> crearEmpresaTransportadora(PersonaDTO personaDTO) {
		if (empresaTransportadoraSevice.crearEmpresaTransportadora(personaDTO) != null) {
			return new ResponseEntity<>(new JSONObject().put("messageStatus", "Creación exitosa").toMap(),
					HttpStatus.OK);
		} else {
			return new ResponseEntity<>(new JSONObject().put("messageStatus", "Problemas en la creación").toMap(),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
