package com.diego.saez.dto.builder;

import com.diego.saez.dto.CategoryDto;

public class CategoryDtoBuilder {

	private Long id;
	private String name;

	private CategoryDtoBuilder() {

	}

	public static CategoryDtoBuilder getInstance() {
		return new CategoryDtoBuilder();
	}

	public CategoryDtoBuilder withId(Long id) {
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
