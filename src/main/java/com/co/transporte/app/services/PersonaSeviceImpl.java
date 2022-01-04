package com.co.transporte.app.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.co.transporte.app.entities.Persona;
import com.co.transporte.app.repository.PersonaRepository;

@Service
public class PersonaSeviceImpl implements IPersonaService {
	
	@Autowired
	private PersonaRepository personaRepository;
	
	public List<Persona> obtenerRepresentantesLegales() {
		return (List<Persona>) personaRepository.obtenerRepresentantesLegales();
	}

}
