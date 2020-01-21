package com.diego.saez.dto.builder;

import com.diego.saez.model.Category;

public class CategoryBuilder {

	private long id;
	private String name;

	private CategoryBuilder() {

	}

	public static CategoryBuilder getInstance() {
		return new CategoryBuilder();
	}

	public CategoryBuilder withId(long id) {
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
