package org.ts.game.interfaces.game.rest;

import java.lang.reflect.ParameterizedType;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.ts.game.domain.model.AbstractEntity;
import org.ts.game.interfaces.AbstractDto;

public class Assembler<E extends AbstractEntity, O extends AbstractDto> {

	protected final Class<E> entityClass;
	protected final Class<O> dtoClass;
	
	@Autowired
	ModelMapper mapper;
	
	@SuppressWarnings("unchecked")
	protected Assembler() {
		this.entityClass = (Class<E>)((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		this.dtoClass = (Class<O>)((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1];
	}
	
	public O toDto(E entity) {
		if(entity == null) {
			return null;
		}
		
		return mapper.map(entity, dtoClass);
	}
	
	public E toEntity(O dto) {
		if(dto == null) {
			return null;
		}
		
		return mapper.map(dto, entityClass);
	}
}
