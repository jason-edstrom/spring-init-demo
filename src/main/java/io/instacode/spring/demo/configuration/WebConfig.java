package io.instacode.spring.demo.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "io.instacode.spring.demo.controller")
public class WebConfig {
}
