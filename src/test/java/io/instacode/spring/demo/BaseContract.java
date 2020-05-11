package io.instacode.spring.demo;

//import io.instacode.spring.demo.controller.FooController;
import io.instacode.spring.demo.controller.FooController;
import io.restassured.RestAssured;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

@SpringBootTest(classes = BaseContract.Config.class, webEnvironment = SpringBootTest.WebEnvironment.NONE)
public abstract class BaseContract extends SpringBootBaseTest{

	@Value("${APPLICATION_BASE_URL}")
	String url;
	@Value("${APPLICATION_USERNAME:}")
	String username;
	@Value("${APPLICATION_PASSWORD:}")
	String password;
	@InjectMocks
	FooController fooController;


	@BeforeEach
	public void setup() {
		RestAssuredMockMvc.standaloneSetup(fooController);
		RestAssured.baseURI = this.url;
		if (StringUtils.hasText(this.username)) {
			RestAssured.authentication = RestAssured.basic(this.username, this.password);
		}

	}

	@Configuration
	@EnableAutoConfiguration
	protected static class Config {
	}
}
