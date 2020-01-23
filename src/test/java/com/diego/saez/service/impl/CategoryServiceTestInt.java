package com.diego.saez.service.impl;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import com.diego.saez.dto.CategoryDto;
import com.diego.saez.exception.BussinessException;
import com.diego.saez.service.ICategoryService;

/**
 * Integration test for {@link CategoryService}
 * 
 * @author diegosaez
 *
 */
@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
public class CategoryServiceTestInt {

	@Autowired
	private ICategoryService categoryService;

	/**
	 * Positive case for findAll
	 * 
	 * @throws BussinessException
	 */
	@Test
	public void testFindAll() throws BussinessException {
		List<CategoryDto> categories = categoryService.findAll();
		Assertions.assertNotNull(categories);
		Assertions.assertEquals(5, categories.size());
	}

}
