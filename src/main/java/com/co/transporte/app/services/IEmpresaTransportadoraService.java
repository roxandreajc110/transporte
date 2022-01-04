package com.co.transporte.app.services;

import java.util.List;

import com.co.transporte.app.domains.PersonaDTO;
import com.co.transporte.app.entities.Persona;

public interface IEmpresaTransportadoraService {
	
	List<Persona> obtenerEmpresasTransportadoras();

	Persona crearEmpresaTransportadora(PersonaDTO personaDTO);

}
