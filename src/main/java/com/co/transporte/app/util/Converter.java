package com.co.transporte.app.util;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public abstract class Converter<E, D> {

	public abstract E fromDto(D dto);

	public abstract D fromEntity(E entity);
	
	public List<D> fromEntity(Iterable<E> entities) {
		if(entities != null ) {
			List<E> listEntities = new ArrayList<>();
			entities.forEach(listEntities::add);
			return listEntities.stream().map(entity -> fromEntity(entity)).collect(Collectors.toList());
		}else {
			return null;
		}
		
	}
	
	public List<E> fromDto(Iterable<D> dtos) {
		if(dtos != null ) {
			List<D> listDtos = new ArrayList<>();
			dtos.forEach(listDtos::add);
			return listDtos.stream().map(entity -> fromDto(entity)).collect(Collectors.toList());
		}else {
			return null;
		}
	}
}