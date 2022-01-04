package com.co.transporte.app.services;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.co.transporte.app.domains.PersonaDTO;
import com.co.transporte.app.entities.Persona;
import com.co.transporte.app.repository.PersonaRepository;
import com.co.transporte.app.util.PersonaConverter;

@Service
public class EmpresaTransportadoraSeviceImpl implements IEmpresaTransportadoraService {
	
	@Autowired
	private PersonaRepository personaRepository;
	private final Logger logger = LoggerFactory.getLogger(EmpresaTransportadoraSeviceImpl.class);
	
	public List<Persona> obtenerEmpresasTransportadoras() {
		return (List<Persona>) personaRepository.obtenerEmpresasTransportadoras();
	}

	public Persona crearEmpresaTransportadora(PersonaDTO personaDTO) {
		PersonaConverter personaConverter = new PersonaConverter();
		return personaRepository.save(personaConverter.fromDto(personaDTO));
	}

}
