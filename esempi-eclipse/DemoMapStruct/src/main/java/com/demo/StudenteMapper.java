package com.demo;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StudenteMapper {
	
	StudenteMapper mapper = Mappers.getMapper(StudenteMapper.class);

	StudenteDTO map(Studente studente);
	
}
