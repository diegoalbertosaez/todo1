package com.diego.saez.model.builder;

import com.diego.saez.model.Category;

public class CategoryBuilder {

	private Long id;
	private String name;

	private CategoryBuilder() {

	}

	public static CategoryBuilder getInstance() {
		return new CategoryBuilder();
	}

	public CategoryBuilder withId(Long id) {
		this.id = id;
		return this;
	}

	public CategoryBuilder withName(String name) {
		this.name = name;
		return this;
	}

	public Category build() {
		Category categoryBuilt = new Category();
		categoryBuilt.setId(this.id);
		categoryBuilt.setName(this.name);
		return categoryBuilt;
	}
}
