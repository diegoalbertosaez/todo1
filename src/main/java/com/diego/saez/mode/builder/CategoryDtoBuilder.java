package com.diego.saez.mode.builder;

import com.diego.saez.dto.CategoryDto;

public class CategoryDtoBuilder {

	private long id;
	private String name;

	private CategoryDtoBuilder() {

	}

	public static CategoryDtoBuilder getInstance() {
		return new CategoryDtoBuilder();
	}

	public CategoryDtoBuilder withId(long id) {
		this.id = id;
		return this;
	}

	public CategoryDtoBuilder withName(String name) {
		this.name = name;
		return this;
	}

	public CategoryDto build() {
		CategoryDto categoryDto = new CategoryDto();
		categoryDto.setId(this.id);
		categoryDto.setName(this.name);
		return categoryDto;
	}
}
