package com.diego.saez.model.builder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.diego.saez.model.Category;
import com.diego.saez.model.Product;

/**
 * Builder for entity object product.
 * 
 * @author diegosaez
 * 
 */
public class ProductBuilder {
	private static final Logger logger = LoggerFactory.getLogger(ProductBuilder.class);

	/**
	 * Id of product.
	 */
	private Long id;

	/**
	 * Name of product.
	 */
	private String name;

	/**
	 * Stock of product.
	 */
	private Integer stock;

	/**
	 * UnitPrice for product.
	 */
	private Double unitPrice;

	/**
	 * Category of product.
	 */
	private Category category;

	/**
	 * Private constructor.
	 */
	private ProductBuilder() {

	}

	/**
	 * Returns an instance of {@link ProductBuilder}.
	 * 
	 * @return {@link ProductBuilder}
	 */
	public static ProductBuilder getInstance() {
		logger.debug("Generando instancia para ProductBuilder");
		return new ProductBuilder();
	}

	/**
	 * Set value for attribute id.
	 * 
	 * @param id
	 * @return {@link ProductBuilder}
	 */
	public ProductBuilder withId(Long id) {
		logger.debug("Init withId(id)");
		logger.debug("Creando product con id ".concat(id == null ? "null" : id.toString()));
		this.id = id;
		logger.debug("End withId(id)");
		return this;
	}

	/**
	 * Set value for attribute name.
	 * 
	 * @param name
	 * @return {@link ProductBuilder}
	 */
	public ProductBuilder withName(String name) {
		logger.debug("Init withName(name)");
		logger.debug("Creando product con name ".concat(name == null ? "null" : name));
		this.name = name;
		logger.debug("End withName(name)");
		return this;
	}

	/**
	 * Set value for attribute stock.
	 * 
	 * @param stock
	 * @return {@link ProductBuilder}
	 */
	public ProductBuilder withStock(Integer stock) {
		logger.debug("Init withStock(stock)");
		logger.debug("Creando product con stock ".concat(stock == null ? "null" : stock.toString()));
		this.stock = stock;
		logger.debug("End withStock(stock)");
		return this;
	}

	/**
	 * Set value for attribute unitPrice.
	 * 
	 * @param unitPrice
	 * @return {@link ProductBuilder}
	 */
	public ProductBuilder withUnitPrice(Double unitPrice) {
		logger.debug("Init withUnitPrice(unitPrice)");
		logger.debug("Creando product con unitPrice ".concat(unitPrice == null ? "null" : unitPrice.toString()));
		this.unitPrice = unitPrice;
		logger.debug("End withUnitPrice(unitPrice)");
		return this;
	}

	/**
	 * Set value for attribute category.
	 * 
	 * @param category
	 * @return {@link ProductBuilder}
	 */
	public ProductBuilder withCategory(Category category) {
		logger.debug("Init withCategory(category)");
		logger.debug("Creando product con category ".concat(category == null ? "null" : category.toString()));
		this.category = category;
		logger.debug("End withCategory(category)");
		return this;
	}

	/**
	 * Build and return an instance of {@link Product}.
	 * 
	 * @return {@link Product}
	 */
	public Product build() {
		logger.debug("Init build");
		Product productBuilt = new Product();
		productBuilt.setId(this.id);
		productBuilt.setName(this.name);
		productBuilt.setStock(this.stock);
		productBuilt.setUnitPrice(this.unitPrice);
		productBuilt.setCategory(this.category);
		logger.debug("End build");
		return productBuilt;
	}

}
