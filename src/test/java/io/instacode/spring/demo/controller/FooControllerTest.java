package io.instacode.spring.demo.controller;

import io.instacode.spring.demo.dto.FooDTO;
import io.instacode.spring.demo.service.FooService;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;

import static org.mockito.Mockito.*;

class FooControllerTest {
	@Mock
	FooService fooService;
	@InjectMocks
	FooController fooController;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void testSave() {
		when(fooService.save((FooDTO) any())).thenReturn(new FooDTO());

		fooController.save(new FooDTO());
	}

//	@Test
//	void testFindById() {
//		when(fooService.findById(anyLong())).thenReturn(null);
//
//		FooDTO result = fooController.findById(1L);
//		Assertions.assertEquals(new FooDTO(), result);
//	}

	@Test
	void testDelete() {
		fooController.delete(1L);
	}

//	@Test
//	void testList() {
//		when(fooService.findAll()).thenReturn(Collections.singletonList(new FooDTO()));
//
//		List<FooDTO> result = fooController.list();
//		Assertions.assertEquals(Collections.singletonList(new FooDTO()), result);
//	}

	@Test
	void testPageQuery() {
		when(fooService.findAll(any())).thenReturn(null);

		Page<FooDTO> result = fooController.pageQuery(null);
		Assertions.assertNull(result);
	}

//	@Test
//	void testUpdate() {
//		when(fooService.updateById(any())).thenReturn(new FooDTO());
//
//		FooDTO result = fooController.update(new FooDTO());
//		Assertions.assertEquals(new FooDTO(), result);
//	}

	@Test
	void testHello() {
		String result = fooController.hello("name");
		Assertions.assertEquals("Hello name!", result);
	}

	@Test
	void testRoot() {
		String result = fooController.root();
		Assertions.assertEquals("", result);
	}
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme