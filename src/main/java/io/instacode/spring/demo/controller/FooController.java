package io.instacode.spring.demo.controller;

import com.google.common.base.Preconditions;
import io.instacode.spring.demo.model.Foo;
//import io.instacode.spring.demo.service.IFooService;
import io.instacode.spring.demo.utility.RestPreconditions;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
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

@RestController
@RequestMapping("/foos")
public class FooController {

  //@Autowired
  //private IFooService iFooService;

  /*@GetMapping
  public List<Foo> findAll() {
    return iFooService.findAll();
  }

  @GetMapping("/{id}")
  public Foo findById(@PathVariable("id") Long id) {
    return RestPreconditions.checkFound(iFooService.findById(id).get());
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Long create(@RequestBody Foo resource) {
    Preconditions.checkNotNull(resource);
    return iFooService.create(resource);
  }

//  @PutMapping(value = "/{id}")
//  @ResponseStatus(HttpStatus.OK)
//  public void update(@PathVariable("id") Long id, @RequestBody Foo resource) {
//    Preconditions.checkNotNull(resource);
//    RestPreconditions.checkNotNull(iFooService.getById(resource.getId()));
//    iFooService.update(resource);
//  }

  @DeleteMapping(value = "/{id}")
  @ResponseStatus(HttpStatus.OK)
  public void delete(@PathVariable("id") Long id) {
    iFooService.deleteById(id);
  }*/

  @GetMapping("/hello")
  public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
    return String.format("Hello %s!", name);
  }
}
