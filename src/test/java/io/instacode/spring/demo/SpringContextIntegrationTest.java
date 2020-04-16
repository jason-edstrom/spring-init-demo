package io.instacode.spring.demo;

import io.instacode.spring.demo.configuration.PersistenceConfig;
import io.instacode.spring.demo.configuration.WebConfig;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.AnnotationConfigContextLoader;


@ContextConfiguration(
    classes = { WebConfig.class, PersistenceConfig.class },
    loader = AnnotationConfigContextLoader.class)
public class SpringContextIntegrationTest extends SpringBootBaseTest {

  @Test
  public void contextLoads() {
  }
}
