package com.co.transporte.app.util;

import com.co.transporte.app.domains.PersonaDTO;
import com.co.transporte.app.entities.Persona;

public class PersonaConverter extends Converter<Persona, PersonaDTO> {

	@Override
	public Persona fromDto(PersonaDTO personaDTO) {
		Persona persona = new Persona();
		persona.setIdPersona(personaDTO.getId());
		persona.setTipoIdentificacion(personaDTO.getTipoIdentificacion());
		persona.setIdentificacion(personaDTO.getIdentificacion());
		persona.setNombre(personaDTO.getNombre());
		persona.setDireccion(personaDTO.getDireccion());
		persona.setTelefono(personaDTO.getTelefono());
		if(personaDTO.getRepresentanteLegal() != null ) {
			Persona representanteLegal = fromDto(personaDTO.getRepresentanteLegal());
			persona.setRepresentanteLegal(representanteLegal);
		}
		if(personaDTO.getEmpresaContratista() != null ) {
			Persona empresaContratista = fromDto(personaDTO.getEmpresaContratista());
			persona.setRepresentanteLegal(empresaContratista);
		}
		return persona;
	}
	
	@Override
	public PersonaDTO fromEntity(Persona persona) {
		PersonaDTO personaDTO = new PersonaDTO();		
		personaDTO.setId(persona.getIdPersona());
		personaDTO.setTipoIdentificacion(persona.getTipoIdentificacion());
		personaDTO.setIdentificacion(persona.getIdentificacion());
		personaDTO.setNombre(persona.getNombre());
		personaDTO.setDireccion(persona.getDireccion());
		personaDTO.setTelefono(persona.getTelefono());
		if(persona.getRepresentanteLegal() != null ) {
			PersonaDTO representanteLegal = fromEntity(persona.getRepresentanteLegal());
			personaDTO.setRepresentanteLegal(representanteLegal);
		}
		if(persona.getEmpresaContratista() != null ) {
			PersonaDTO empresaContratista = fromEntity(persona.getEmpresaContratista());
			personaDTO.setRepresentanteLegal(empresaContratista);
		}
		return personaDTO;
	}


}
