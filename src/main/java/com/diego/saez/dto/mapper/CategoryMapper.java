package com.diego.saez.dto.mapper;

import static com.diego.saez.functional.LambdaExceptionWrappers.throwingConsumerWrapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.diego.saez.dto.CategoryDto;
import com.diego.saez.dto.builder.CategoryDtoBuilder;
import com.diego.saez.exception.MapperException;
import com.diego.saez.model.Category;

/**
 * Mapper to convert category entity object to dto object and vice versa.
 * 
 * @author diegosaez
 *
 */
@Component
public class CategoryMapper implements IMapper<Category, CategoryDto> {

	private static final Logger logger = LoggerFactory.getLogger(CategoryMapper.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.diego.saez.dto.mapper.IMapper#toEntity(java.lang.Object)
	 */
	@Override
	public Category toEntity(CategoryDto categoryDto) throws MapperException {
		logger.debug("Init toEntity toDto(categoryDto)");
		logger.error("Método no implementado");
		logger.debug("End toEntity toDto(categoryDto)");
		throw new MapperException("Método no implementado");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.diego.saez.dto.mapper.IMapper#toDto(java.lang.Object)
	 */
	@Override
	public CategoryDto toDto(Category categoryEntity) throws MapperException {
		logger.debug("Init toDto(categoryEntity)");
		Optional<Category> categoryOptional = Optional.ofNullable(categoryEntity);
		categoryOptional.orElseThrow(() -> new MapperException(
				"Error al mapear una categoryEntity a un dto: La categoría a convertir no puede ser null"));
		Category categoryToConvert = categoryOptional.get();
		CategoryDtoBuilder categoryDtoBuilder = CategoryDtoBuilder.getInstance();
		CategoryDto productDtoToReturn = categoryDtoBuilder.withId(categoryToConvert.getId())
				.withName(categoryToConvert.getName()).build();
		logger.debug("End toDto(categoryEntity)");
		return productDtoToReturn;
	}

	@Override
	public List<CategoryDto> toDto(List<Category> categories) throws MapperException {
		logger.debug("Init toDto(categories");
		Optional<List<Category>> categoriesOptional = Optional.ofNullable(categories);
		categoriesOptional.orElseThrow(() -> new MapperException(
				"Error al mapear una lista de categorías entity a una lista de dtos: La lista a convertir no puede ser null"));
		List<Category> categoriesToConvert = categoriesOptional.get();
		List<CategoryDto> categoriesDtoToReturn = new ArrayList<CategoryDto>();
		categoriesToConvert.forEach(throwingConsumerWrapper(c -> categoriesDtoToReturn.add(this.toDto(c))));
		logger.debug("End toDto(categories");
		return categoriesDtoToReturn;
	}

}
