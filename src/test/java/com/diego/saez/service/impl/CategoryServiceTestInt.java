package com.diego.saez.service.impl;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.diego.saez.dto.CategoryDto;
import com.diego.saez.exception.BussinessException;
import com.diego.saez.service.ICategoryService;

public class CategoryServiceTestInt {

	@Autowired
	private ICategoryService categoryService;
	
	@Test
	public void testFindAll() throws BussinessException {
		List<CategoryDto> categories = categoryService.findAll();
		Assertions.assertNotNull(categories);
		Assertions.assertEquals(6, categories.size());
	}

}
