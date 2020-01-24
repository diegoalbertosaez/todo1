package com.diego.saez.model.builder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.diego.saez.model.Category;

/**
 * Builder for entity object category.
 * 
 * @author diegosaez
 *
 */
public class CategoryBuilder {
	private static final Logger logger = LoggerFactory.getLogger(CategoryBuilder.class);

	/**
	 * Id of category.
	 */
	private Long id;

	/**
	 * Name of category.
	 */
	private String name;

	/**
	 * Private constructor.
	 */
	private CategoryBuilder() {

	}

	/**
	 * Returns an instance of {@link CategoryBuilder}.
	 * 
	 * @return {@link CategoryBuilder}
	 */
	public static CategoryBuilder getInstance() {
		logger.debug("Generando instancia para CategoryBuilder");
		return new CategoryBuilder();
	}

	/**
	 * Set value for attribute id.
	 * 
	 * @param id
	 * @return {@link CategoryBuilder}
	 */
	public CategoryBuilder withId(Long id) {
		logger.debug("Init withId(id)");
		logger.debug("Creando category con id ".concat(id == null ? "null" : id.toString()));
		this.id = id;
		logger.debug("End withId(id)");
		return this;
	}

	/**
	 * Set value for attribute name.
	 * 
	 * @param name
	 * @return {@link CategoryBuilder}
	 */
	public CategoryBuilder withName(String name) {
		logger.debug("Init withName(name)");
		logger.debug("Creando category con nombre ".concat(name == null ? "null" : name.toString()));
		this.name = name;
		logger.debug("End withName(name)");
		return this;
	}

	/**
	 * Build and return an instance of {@link Category}.
	 * 
	 * @return {@link Category}
	 */
	public Category build() {
		logger.debug("Init build");
		Category categoryBuilt = new Category();
		categoryBuilt.setId(this.id);
		categoryBuilt.setName(this.name);
		logger.debug("End build");
		return categoryBuilt;
	}
}
