package io.instacode.spring.demo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
//@ContextConfiguration(classes = {SpringTestConfiguration.class})
class DemoApplicationTests {

  @Test
  void contextLoads() {
  }

}
