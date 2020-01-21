package com.diego.saez.dto.mapper;

import java.util.Optional;

import com.diego.saez.dto.CategoryDto;
import com.diego.saez.dto.builder.CategoryBuilder;
import com.diego.saez.mode.builder.CategoryDtoBuilder;
import com.diego.saez.model.Category;

public class CategoryMapper implements IMapper<Category, CategoryDto> {

	@Override
	public Category toEntity(CategoryDto categoryDto) {
		Optional<CategoryDto> categoryDtoOptional = Optional.ofNullable(categoryDto);
		// categoryDtoOptional.orElseThrow(exceptionSupplier);
		CategoryDto categoryDtoToConvert = categoryDtoOptional.get();
		CategoryBuilder categoryBuilder = CategoryBuilder.getInstance();
		Category categoryToReturn = categoryBuilder.withId(categoryDtoToConvert.getId())
				.withName(categoryDtoToConvert.getName()).build();
		return categoryToReturn;
	}

	@Override
	public CategoryDto toDto(Category categoryEntity) {
		Optional<Category> categoryOptional = Optional.ofNullable(categoryEntity);
		// categoryOptional.orElseThrow(exceptionSupplier);
		Category categoryToConvert = categoryOptional.get();
		CategoryDtoBuilder categoryDtoBuilder = CategoryDtoBuilder.getInstance();
		CategoryDto productDtoToReturn = categoryDtoBuilder.withId(categoryToConvert.getId())
				.withName(categoryToConvert.getName()).build();
		return productDtoToReturn;
	}

}
