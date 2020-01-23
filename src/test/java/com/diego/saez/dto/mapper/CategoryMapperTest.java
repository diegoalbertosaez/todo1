package com.diego.saez.dto.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.diego.saez.dto.CategoryDto;
import com.diego.saez.exception.MapperException;
import com.diego.saez.model.Category;
import com.diego.saez.test.common.UnitTest;

/**
 * Test Case para {@link CategoryMapper}
 * 
 * @author diegosaez
 *
 */
public class CategoryMapperTest extends UnitTest {

	private CategoryMapper categoryMapper = new CategoryMapper();

	/**
	 * Caso positivo para toEntity. Hay excepción debido a que el método no está
	 * implementado
	 * 
	 * @throws MapperException
	 */
	@Test
	public void testToEntity() throws MapperException {
		Assertions.assertThrows(MapperException.class, () -> categoryMapper.toEntity(new CategoryDto()));
	}

	/**
	 * Caso positivo para toDto(categoryEntity)
	 * 
	 * @throws MapperException
	 */
	@Test
	public void testToDtoCategory() throws MapperException {
		CategoryDto categoryDto = categoryMapper.toDto(getDummyCategory(0));
		Assertions.assertNotNull(categoryDto);
		Assertions.assertEquals(1L, categoryDto.getId());
		Assertions.assertEquals("Category 1", categoryDto.getName());
	}

	/**
	 * Caso positivo para toDto(categoriesEntity)
	 * 
	 * @throws MapperException
	 */
	@Test
	public void testToDtoListOfCategory() throws MapperException {
		List<CategoryDto> categoriesDto = categoryMapper.toDto(getDummyCategoryList(10));
		Assertions.assertNotNull(categoriesDto);
		Assertions.assertEquals(10, categoriesDto.size());
		Assertions.assertTrue(categoriesDto.stream().filter(category -> category.getId() == null)
				.collect(Collectors.toList()).isEmpty());
	}

	/**
	 * Caso negativo para toDto(categoryEntity): La categoría enviada es null
	 * 
	 * @throws MapperException
	 */
	@Test
	public void testToDtoCategoryThrowException() throws MapperException {
		Category category = null;
		Assertions.assertThrows(MapperException.class, () -> categoryMapper.toDto(category));
	}

	/**
	 * Caso negativo para toDto(categoriesEntity): La lista de categorías enviada es
	 * null
	 * 
	 * @throws MapperException
	 */
	@Test
	public void testToDtoListOfCategoryThrowException() throws MapperException {
		List<Category> categories = null;
		Assertions.assertThrows(MapperException.class, () -> categoryMapper.toDto(categories));
	}

	/**
	 * Caso negativo para toDto(categoriesEntity): La lista de categorías contiene
	 * elementos en null
	 * 
	 * @throws MapperException
	 */
	@Test
	public void testToDtoListOfCategoryThrowException2() throws MapperException {
		List<Category> categories = new ArrayList<Category>();
		categories.add(null);
		Assertions.assertThrows(RuntimeException.class, () -> categoryMapper.toDto(categories));
	}

}
