package com.diego.saez.service.impl;

import java.util.List;

import org.easymock.EasyMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.dao.RecoverableDataAccessException;
import org.springframework.test.util.ReflectionTestUtils;

import com.diego.saez.dto.CategoryDto;
import com.diego.saez.dto.mapper.CategoryMapper;
import com.diego.saez.exception.BussinessException;
import com.diego.saez.repository.CategoryRepository;
import com.diego.saez.test.common.UnitTest;

/**
 * TestCase para CategoryService
 * 
 * @author diegosaez
 *
 */
public class CategoryServiceTest extends UnitTest {

	/**
	 * Test positivo findAll
	 * 
	 * @throws BussinessException
	 */
	@Test
	public void testFindAll() throws BussinessException {
		CategoryRepository categoryRepositoryMock = getCategoryRepositoryMock();
		final int amountCategoriesDummy = 5;
		EasyMock.expect(categoryRepositoryMock.findAll()).andReturn(getDummyCategoryList(amountCategoriesDummy));
		EasyMock.replay(categoryRepositoryMock);
		CategoryMapper categoryMapper = new CategoryMapper();
		CategoryService categoryService = new CategoryService();
		ReflectionTestUtils.setField(categoryService, "categoryRepository", categoryRepositoryMock);
		ReflectionTestUtils.setField(categoryService, "categoryMapper", categoryMapper);
		List<CategoryDto> categories = categoryService.findAll();
		Assertions.assertNotNull(categories);
		Assertions.assertEquals(amountCategoriesDummy, categories.size());
		EasyMock.verify(categoryRepositoryMock);
	}

	/**
	 * Test negativo, categoryRepository lanza RecoverableDataAccessException. Se
	 * espera BussinessException
	 */
	@Test
	public void testFindAllThrownException() {
		CategoryRepository categoryRepositoryMock = getCategoryRepositoryMock();
		EasyMock.expect(categoryRepositoryMock.findAll())
				.andThrow(new RecoverableDataAccessException("Error en repositorio"));
		EasyMock.replay(categoryRepositoryMock);
		CategoryMapper categoryMapper = new CategoryMapper();
		CategoryService categoryService = new CategoryService();
		ReflectionTestUtils.setField(categoryService, "categoryRepository", categoryRepositoryMock);
		ReflectionTestUtils.setField(categoryService, "categoryMapper", categoryMapper);
		Assertions.assertThrows(BussinessException.class, () -> categoryService.findAll());
		EasyMock.verify(categoryRepositoryMock);
	}

}
