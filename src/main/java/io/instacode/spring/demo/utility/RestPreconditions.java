package io.instacode.spring.demo.utility;

import io.instacode.spring.demo.exceptions.BadRequestException;
import io.instacode.spring.demo.exceptions.ResourceNotFoundException;
import java.util.Optional;

public class RestPreconditions {
  public static <T> T checkFound(T resource) throws ResourceNotFoundException {
    if (resource == null) {
      throw new ResourceNotFoundException();
    } else if (resource instanceof Optional)
    {
      ((Optional) resource).isPresent();

    }
    return resource;
  }

  public static <T> T checkNotNull(T resource) {
    if (resource == null){
      throw new BadRequestException();
    }
    return resource;
  }
}
