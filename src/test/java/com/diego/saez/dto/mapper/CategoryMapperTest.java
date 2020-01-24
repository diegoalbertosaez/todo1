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
 * Test Case for {@link CategoryMapper}.
 * 
 * @author diegosaez
 *
 */
public class CategoryMapperTest extends UnitTest {

	private CategoryMapper categoryMapper = new CategoryMapper();

	/**
	 * Positive case for toEntity. There is an exception because the method is not
	 * implemented.
	 * 
	 * @throws MapperException
	 */
	@Test
	public void testToEntity() throws MapperException {
		Assertions.assertThrows(MapperException.class, () -> categoryMapper.toEntity(new CategoryDto()));
	}

	/**
	 * Positive case for toDto(categoryEntity).
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
	 * Positive case for toDto(categoriesEntity).
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
	 * Negative case for toDto(categoryEntity): The category entered is null.
	 * 
	 * @throws MapperException
	 */
	@Test
	public void testToDtoCategoryThrowException() throws MapperException {
		Category category = null;
		Assertions.assertThrows(MapperException.class, () -> categoryMapper.toDto(category));
	}

	/**
	 * Negative case for toDto(categoriesEntity): The list of categories entered is
	 * null.
	 * 
	 * @throws MapperException
	 */
	@Test
	public void testToDtoListOfCategoryThrowException() throws MapperException {
		List<Category> categories = null;
		Assertions.assertThrows(MapperException.class, () -> categoryMapper.toDto(categories));
	}

	/**
	 * Negative case for toDto(categoriesEntity): The category list contains null
	 * elements.
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
