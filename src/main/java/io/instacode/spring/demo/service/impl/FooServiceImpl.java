package io.instacode.spring.demo.service.impl;

import io.instacode.spring.demo.dao.FooRepository;
import io.instacode.spring.demo.dto.FooDTO;
import io.instacode.spring.demo.mapper.FooMapper;
import io.instacode.spring.demo.model.Foo;
import io.instacode.spring.demo.service.FooService;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class FooServiceImpl implements FooService {
	private final FooMapper mapper = Mappers.getMapper(FooMapper.class);
	private final FooRepository repository;

	public FooServiceImpl(FooRepository repository) {
		this.repository = repository;
	}

	@Override
	public FooDTO save(FooDTO dto) {
		return mapper.toDto(repository.save(mapper.toEntity(dto)));
	}

	@Override
	public void save(List<FooDTO> dtos) {
		repository.saveAll(mapper.toEntityList(dtos));
	}

	@Override
	public void deleteById(Long id) {
		repository.deleteById(id);
	}

	@Override
	public Optional<FooDTO> findById(Long id) {
		Optional<Foo> entityOptional = repository.findById(id);
		return entityOptional.map(entity -> Optional.ofNullable(mapper.toDto(entity))).orElse(null);
	}

	@Override
	public List<FooDTO> findAll() {
		return mapper.toDtoList((List<Foo>) repository.findAll());
	}

	@Override
	public Page<FooDTO> findAll(Pageable pageable) {
		Page<Foo> entityPage = repository.findAll(pageable);
		List<FooDTO> dtos = mapper.toDtoList(entityPage.getContent());
		return new PageImpl<>(dtos, pageable, entityPage.getTotalElements());
	}

	@Override
	public FooDTO updateById(FooDTO dto) {
		Optional<FooDTO> optionalDto = findById(dto.getId());
		if (optionalDto.isPresent()) {
			return save(dto);
		}
		return null;
	}
}