package io.instacode.spring.demo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

@AutoConfigureMockMvc
public class FooControllerAppIntegrationTest extends SpringBootBaseTest {

  @Autowired
  private MockMvc mockMvc;

  @Test
  void whenTestApp_thenEmptyResponse() throws Exception {
    this.mockMvc.perform(get("/foos")).andExpect(status().isOk());
  }
}
