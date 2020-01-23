package com.diego.saez.dto.builder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.diego.saez.dto.CategoryDto;

/**
 * Builder for data transfer object categoryDto
 * 
 * @author diegosaez
 *
 */
public class CategoryDtoBuilder {
	private static final Logger logger = LoggerFactory.getLogger(CategoryDtoBuilder.class);

	/**
	 * Id of category
	 */
	private Long id;

	/**
	 * Id of category
	 */
	private String name;

	/**
	 * Private constructor
	 */
	private CategoryDtoBuilder() {

	}

	/**
	 * Returns an instance of {@link CategoryDtoBuilder}
	 * 
	 * @return {@link CategoryDtoBuilder}
	 */
	public static CategoryDtoBuilder getInstance() {
		logger.debug("Generando instancia para CategoryDtoBuilder");
		return new CategoryDtoBuilder();
	}

	/**
	 * Set value for attribute id
	 * 
	 * @param id
	 * @return {@link CategoryDtoBuilder}
	 */
	public CategoryDtoBuilder withId(Long id) {
		logger.debug("Init withId(id)");
		logger.debug("Creando categoryDto con id ".concat(id == null ? "null" : id.toString()));
		this.id = id;
		logger.debug("End withId(id)");
		return this;
	}

	/**
	 * Set value for attribute name
	 * 
	 * @param name
	 * @return {@link CategoryDtoBuilder}
	 */
	public CategoryDtoBuilder withName(String name) {
		logger.debug("Init withName(name)");
		logger.debug("Creando categoryDto con nombre ".concat(name == null ? "null" : name.toString()));
		this.name = name;
		logger.debug("End withName(name)");
		return this;
	}

	/**
	 * Build and return an instance of {@link CategoryDto}
	 * 
	 * @return {@link CategoryDto}
	 */
	public CategoryDto build() {
		logger.debug("Init build");
		CategoryDto categoryDto = new CategoryDto();
		categoryDto.setId(this.id);
		categoryDto.setName(this.name);
		logger.debug("End build");
		return categoryDto;
	}
}
