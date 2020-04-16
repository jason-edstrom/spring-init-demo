package io.instacode.spring.demo.utility;

import io.instacode.spring.demo.exceptions.ResourceNotFoundException;

public class RestPreconditions {
  public static <T> T checkFound(T resource) throws ResourceNotFoundException {
    if (resource == null) {
      throw new ResourceNotFoundException();
    }
    return resource;
  }
}
