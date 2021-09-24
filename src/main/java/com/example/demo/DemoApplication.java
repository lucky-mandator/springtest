package com.example.demo;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public GroupedOpenApi greetingOpenApi() {
		String[] paths = { "/hello/**" };
		return GroupedOpenApi.builder().group("helloGroup").pathsToMatch(paths)
				.build();
	}
}
