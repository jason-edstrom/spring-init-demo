package io.instacode.spring.demo.mapper;

import io.instacode.spring.demo.dto.FooDTO;
import io.instacode.spring.demo.model.Foo;
import org.mapstruct.Mapper;

@Mapper
public interface FooMapper extends EntityMapper<FooDTO, Foo> {
}