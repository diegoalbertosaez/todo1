package com.diego.saez;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EntityScan("com.diego.saez.model")
@EnableWebMvc
@EnableJpaRepositories(basePackages = "com.diego.saez.repository")
@EnableAutoConfiguration
@EnableTransactionManagement
public class DiegoSaezApp {
	private static final Logger logger = LoggerFactory.getLogger(DiegoSaezApp.class);

	public static void main(String[] args) {
		logger.debug("Starting DiegoSaezApp");
		SpringApplication.run(DiegoSaezApp.class, args);
	}
}
