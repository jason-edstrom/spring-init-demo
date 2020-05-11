package io.instacode.spring.demo.mapper;

import java.util.List;
import org.springframework.data.domain.Page;

public interface EntityMapper<D, E> {
	E toEntity(D dto);

	D toDto(E entity);

	List<E> toEntityList(List<D> dtoList);

	List<D> toDtoList(List<E> entityList);
}