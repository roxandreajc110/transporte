package com.co.transporte.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.co.transporte.app.entities.Persona;

public interface PersonaRepository extends CrudRepository<Persona, Integer>  {
	
	@Query("select p from Persona p where representanteLegal is not null")
	List<Persona> obtenerEmpresasTransportadoras();
	
	@Query("select p from Persona p where representanteLegal is null and empresaContratista is null")
	List<Persona> obtenerRepresentantesLegales();

}
