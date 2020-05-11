package io.instacode.spring.demo.mapper.impl;

import io.instacode.spring.demo.dto.FooDTO;
import io.instacode.spring.demo.mapper.FooMapper;
import io.instacode.spring.demo.model.Foo;
import java.util.List;
import java.util.stream.Collectors;

public class FooMapperImpl implements FooMapper {
	@Override
	public Foo toEntity(FooDTO dto) {
		Foo entity = new Foo();
		entity.setId(dto.getId());
		return entity;
	}

	@Override
	public FooDTO toDto(Foo entity) {
		FooDTO dto = new FooDTO();
		dto.setId(entity.getId());
		return dto;
	}

	@Override
	public List<Foo> toEntityList(List<FooDTO> dtoList) {
		return dtoList.stream().map(this::toEntity).collect(Collectors.toList());
	}

	@Override
	public List<FooDTO> toDtoList(List<Foo> entityList) {
		return entityList.stream().map(this::toDto).collect(Collectors.toList());
	}
}