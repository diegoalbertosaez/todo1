package com.diegosaez.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Static Resource Configuration Class
 * 
 * @author diegosaez
 *
 */
@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {
	private static final Logger logger = LoggerFactory.getLogger(WebConfig.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.web.servlet.config.annotation.WebMvcConfigurer#
	 * addResourceHandlers(org.springframework.web.servlet.config.annotation.
	 * ResourceHandlerRegistry)
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		logger.debug("Init addResourceHandlers(registry)");
		logger.debug("Registrando recursos estáticos");
		registry.addResourceHandler("/js/**").addResourceLocations("classpath:/static/js/");
		logger.debug("End addResourceHandlers(registry)");
	}
}
