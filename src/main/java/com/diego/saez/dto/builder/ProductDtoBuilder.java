package com.diego.saez.dto.builder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.diego.saez.dto.ProductDto;

/**
 * Builder for data transfer object productDto
 * 
 * @author diegosaez
 *
 */
public class ProductDtoBuilder {
	private static final Logger logger = LoggerFactory.getLogger(ProductDtoBuilder.class);

	/**
	 * Id of product
	 */
	private Long idProduct;

	/**
	 * Name of product
	 */
	private String nameProduct;

	/**
	 * Stock of product
	 */
	private Integer stockProduct;

	/**
	 * Id of category
	 */
	private Long idCategory;

	/**
	 * Name of category
	 */
	private String nameCategory;

	/**
	 * UnitPrice of product
	 */
	private Double unitPrice;

	/**
	 * Private constructor
	 */
	private ProductDtoBuilder() {

	}

	/**
	 * Returns an instance of {@link ProductDtoBuilder}
	 * 
	 * @return {@link ProductDtoBuilder}
	 */
	public static ProductDtoBuilder getInstance() {
		logger.debug("Generando instancia para ProductDtoBuilder");
		return new ProductDtoBuilder();
	}

	/**
	 * Set value for attribute idProduct
	 * 
	 * @param idProduct
	 * @return {@link ProductDtoBuilder}
	 */
	public ProductDtoBuilder withIdProduct(Long idProduct) {
		logger.debug("Init withIdProduct(idProduct)");
		logger.debug("Creando productDto con idProduct ".concat(idProduct == null ? "null" : idProduct.toString()));
		this.idProduct = idProduct;
		logger.debug("End withIdProduct(idProduct)");
		return this;
	}

	/**
	 * Set value for attribute nameProduct
	 * 
	 * @param nameProduct
	 * @return
	 */
	public ProductDtoBuilder withNameProduct(String nameProduct) {
		logger.debug("Init withNameProduct(nameProduct)");
		logger.debug("Creando productDto con nameProduct ".concat(nameProduct == null ? "null" : nameProduct));
		this.nameProduct = nameProduct;
		logger.debug("Init withNameProduct(nameProduct)");
		return this;
	}

	/**
	 * Set value for attribute stockProduct
	 * 
	 * @param stockProduct
	 * @return {@link ProductDtoBuilder}
	 */
	public ProductDtoBuilder withStockProduct(Integer stockProduct) {
		logger.debug("Init withStockProduct(nameProduct)");
		logger.debug(
				"Creando productDto con stockProduct ".concat(stockProduct == null ? "null" : stockProduct.toString()));
		this.stockProduct = stockProduct;
		logger.debug("Init withStockProduct(nameProduct)");
		return this;
	}

	/**
	 * Set value for attribute nameCategory
	 * 
	 * @param nameCategory
	 * @return {@link ProductDtoBuilder}
	 */
	public ProductDtoBuilder withNameCategory(String nameCategory) {
		logger.debug("Init withNameCategory(nameCategory)");
		logger.debug("Creando productDto con nameCategory ".concat(nameCategory == null ? "null" : nameCategory));
		this.nameCategory = nameCategory;
		logger.debug("Init withNameCategory(nameCategory)");
		return this;
	}

	/**
	 * Set value for attribute idCategory
	 * 
	 * @param idCategory
	 * @return {@link ProductDtoBuilder}
	 */
	public ProductDtoBuilder withIdCategory(Long idCategory) {
		logger.debug("Init withIdCategory(idCategory)");
		logger.debug("Creando productDto con idCategory ".concat(idCategory == null ? "null" : idCategory.toString()));
		this.idCategory = idCategory;
		logger.debug("Init withIdCategory(idCategory)");
		return this;
	}

	/**
	 * Set value for attribute unitPrice
	 * 
	 * @param unitPrice
	 * @return {@link ProductDtoBuilder}
	 */
	public ProductDtoBuilder withUnitPrice(Double unitPrice) {
		logger.debug("Init withUnitPrice(unitPrice)");
		logger.debug("Creando productDto con unitPrice ".concat(unitPrice == null ? "null" : unitPrice.toString()));
		this.unitPrice = unitPrice;
		logger.debug("Init withUnitPrice(unitPrice)");
		return this;
	}

	/**
	 * Build and return an instance of {@link ProductDto}
	 * 
	 * @return {@link ProductDto}
	 */
	public ProductDto build() {
		logger.debug("Init build");
		ProductDto productDtoBuilt = new ProductDto();
		productDtoBuilt.setIdProduct(this.idProduct);
		productDtoBuilt.setIdCategory(this.idCategory);
		productDtoBuilt.setNameCategory(this.nameCategory);
		productDtoBuilt.setNameProduct(this.nameProduct);
		productDtoBuilt.setStockProduct(this.stockProduct);
		productDtoBuilt.setUnitPrice(this.unitPrice);
		logger.debug("End build");
		return productDtoBuilt;
	}
}
