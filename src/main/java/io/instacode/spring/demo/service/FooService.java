package io.instacode.spring.demo.service;

import io.instacode.spring.demo.dto.FooDTO;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface FooService {
	FooDTO save(FooDTO dto);

	void save(List<FooDTO> dtos);

	void deleteById(Long id);

	Optional<FooDTO> findById(Long id);

	List<FooDTO> findAll();

	Page<FooDTO> findAll(Pageable pageable);

	FooDTO updateById(FooDTO dto);
}