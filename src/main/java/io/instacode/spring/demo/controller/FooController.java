package io.instacode.spring.demo.controller;

import io.instacode.spring.demo.dto.FooDTO;
import io.instacode.spring.demo.service.FooService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/foo")
@RestController
@Api(tags = "Foo API")
public class FooController {

	private final FooService fooService;

	public FooController(FooService fooService) {
		this.fooService = fooService;
	}

	@ApiOperation("Add new data")
	@PostMapping("/save")
	public void save(@RequestBody FooDTO foo) {
		fooService.save(foo);
	}

	@ApiOperation("Delete based on primary key")
	@GetMapping("/{id}")
	public FooDTO findById(@PathVariable("id") Long id) {
		Optional<FooDTO> dtoOptional = fooService.findById(id);
		return dtoOptional.orElse(null);
	}

	@ApiOperation("Find by Id")
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable("id") Long id) {
		fooService.deleteById(id);
	}

	@ApiOperation("Find all data")
	@GetMapping("/list")
	public List<FooDTO> list() {
		return fooService.findAll();
	}

	@ApiOperation("Pagination request")
	@GetMapping("/page-query")
	public Page<FooDTO> pageQuery(Pageable pageable) {
		return fooService.findAll(pageable);
	}

	@ApiOperation("Update one data")
	@PutMapping("/update/{id}")
	public FooDTO update(@RequestBody FooDTO dto) {
		return fooService.updateById(dto);
	}

	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		return String.format("Hello %s!", name);
	}
	@GetMapping("")
	@ResponseStatus(HttpStatus.OK)
	public String root(){
		return "";
	}
}