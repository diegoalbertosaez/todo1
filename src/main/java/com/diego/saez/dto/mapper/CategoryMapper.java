package com.diego.saez.dto.mapper;

import static com.diego.saez.functional.LambdaExceptionWrappers.throwingConsumerWrapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.diego.saez.dto.CategoryDto;
import com.diego.saez.exception.MapperException;
import com.diego.saez.model.Category;

@Component
public class CategoryMapper implements IMapper<Category, CategoryDto> {

	@Override
	public Category toEntity(CategoryDto categoryDto) throws MapperException {
		throw new MapperException("No implementado");
	}

	@Override
	public CategoryDto toDto(Category categoryEntity) throws MapperException {
		throw new MapperException("No implementado");
	}

	@Override
	public List<CategoryDto> toDto(List<Category> categories) throws MapperException {
		Optional<List<Category>> categoriesOptional = Optional.ofNullable(categories);
		categoriesOptional.orElseThrow(() -> new MapperException(
				"Error al mapear una lista de categorías entity a una lista de dtos: La lista a convertir no puede ser null"));
		List<Category> categoriesToConvert = categoriesOptional.get();
		List<CategoryDto> categoriesDtoToReturn = new ArrayList<CategoryDto>();
		categoriesToConvert.forEach(throwingConsumerWrapper(c -> categoriesDtoToReturn.add(this.toDto(c))));
		return categoriesDtoToReturn;
	}

}
