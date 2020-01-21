package com.diego.saez.dto.builder;

import com.diego.saez.model.Category;
import com.diego.saez.model.Product;

public class ProductBuilder {
	private long id;
	private String name;
	private int stock;
	private double unitPrice;
	private Category category;

	private ProductBuilder() {

	}

	public static ProductBuilder getInstance() {
		return new ProductBuilder();
	}

	public ProductBuilder withId(long id) {
		this.id = id;
		return this;
	}

	public ProductBuilder withName(String name) {
		this.name = name;
		return this;
	}

	public ProductBuilder withStock(int stock) {
		this.stock = stock;
		return this;
	}

	public ProductBuilder withUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
		return this;
	}

	public ProductBuilder withCategory(Category category) {
		this.category = category;
		return this;
	}

	public Product build() {
		Product productBuilt = new Product();
		productBuilt.setId(this.id);
		productBuilt.setName(this.name);
		productBuilt.setStock(this.stock);
		productBuilt.setUnitPrice(this.unitPrice);
		productBuilt.setCategory(this.category);
		return productBuilt;
	}

}