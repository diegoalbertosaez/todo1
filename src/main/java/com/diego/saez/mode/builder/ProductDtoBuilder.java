package com.diego.saez.mode.builder;

import com.diego.saez.dto.ProductDto;

public class ProductDtoBuilder {

	private Long idProduct;
	private String nameProduct;
	private int stockProduct;
	private Long idCategory;
	private String nameCategory;
	private double unitPrice;

	private ProductDtoBuilder() {

	}

	public static ProductDtoBuilder getInstance() {
		return new ProductDtoBuilder();
	}

	public ProductDtoBuilder withIdProduct(long idProduct) {
		this.idProduct = idProduct;
		return this;
	}

	public ProductDtoBuilder withNameProduct(String nameProduct) {
		this.nameProduct = nameProduct;
		return this;
	}

	public ProductDtoBuilder withStockProduct(int stockProduct) {
		this.stockProduct = stockProduct;
		return this;
	}
	
	public ProductDtoBuilder withNameCategory(String nameCategory) {
		this.nameCategory = nameCategory;
		return this;
	}
	
	public ProductDtoBuilder withIdCategory(long idCategory) {
		this.idCategory = idCategory;
		return this;
	}
	
	public ProductDtoBuilder withUnitPrice(double unitPrice) {
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
