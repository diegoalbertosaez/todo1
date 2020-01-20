package com.diego.saez;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EntityScan("com.diego.saez.model")
@EnableWebMvc
@EnableJpaRepositories(basePackages="com.diego.saez.repository")
@EnableAutoConfiguration
public class DiegoSaezApp {

	public static void main(String[] args) {
		SpringApplication.run(DiegoSaezApp.class, args);
	}
}
