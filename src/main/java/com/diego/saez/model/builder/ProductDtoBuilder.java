package com.diego.saez.model.builder;

import com.diego.saez.dto.ProductDto;

public class ProductDtoBuilder {

	private Long idProduct;
	private String nameProduct;
	private Integer stockProduct;
	private Long idCategory;
	private String nameCategory;
	private Double unitPrice;

	private ProductDtoBuilder() {

	}

	public static ProductDtoBuilder getInstance() {
		return new ProductDtoBuilder();
	}

	public ProductDtoBuilder withIdProduct(Long idProduct) {
		this.idProduct = idProduct;
		return this;
	}

	public ProductDtoBuilder withNameProduct(String nameProduct) {
		this.nameProduct = nameProduct;
		return this;
	}

	public ProductDtoBuilder withStockProduct(Integer stockProduct) {
		this.stockProduct = stockProduct;
		return this;
	}
	
	public ProductDtoBuilder withNameCategory(String nameCategory) {
		this.nameCategory = nameCategory;
		return this;
	}
	
	public ProductDtoBuilder withIdCategory(Long idCategory) {
		this.idCategory = idCategory;
		return this;
	}
	
	public ProductDtoBuilder withUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
		return this;
	}
	
	public ProductDto build() {
		ProductDto productDtoBuilt = new ProductDto();
		productDtoBuilt.setIdProduct(this.idProduct);
		productDtoBuilt.setIdCategory(this.idCategory);
		productDtoBuilt.setNameCategory(this.nameCategory);
		productDtoBuilt.setNameProduct(this.nameProduct);
		productDtoBuilt.setStockProduct(this.stockProduct);		
		productDtoBuilt.setUnitPrice(this.unitPrice);
		return productDtoBuilt;
	}
}
