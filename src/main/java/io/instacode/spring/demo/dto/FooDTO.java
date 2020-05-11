package io.instacode.spring.demo.dto;

import org.springframework.format.annotation.DateTimeFormat;

public class FooDTO {
	private Long id;

	public FooDTO() {
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return this.id;
	}
}