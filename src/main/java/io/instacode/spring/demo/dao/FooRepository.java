package io.instacode.spring.demo.dao;

import io.instacode.spring.demo.model.Foo;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FooRepository extends PagingAndSortingRepository<Foo, Long> {
}