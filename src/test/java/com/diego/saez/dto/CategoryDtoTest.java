package com.diego.saez.dto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Test Case for {@link CategoryDto}.
 * 
 * @author diegosaez
 *
 */
public class CategoryDtoTest {

	CategoryDto categoryDto = new CategoryDto();

	/**
	 * Positive case for constructor.
	 */
	public void testConstructor() {
		CategoryDto categoryDto = new CategoryDto();
		Assertions.assertTrue(categoryDto.getClass().getName().equals("CategoryDto"));
	}

	/**
	 * Positive case for getId().
	 */
	@Test
	public void testGetId() {
		categoryDto.setId(1L);
		Assertions.assertNotNull(categoryDto.getId());
		Assertions.assertEquals(1L, categoryDto.getId());
	}

	/**
	 * Positive case for getName().
	 */
	@Test
	public void testGetName() {
		categoryDto.setName("Name");
		Assertions.assertNotNull(categoryDto.getName());
		Assertions.assertEquals("Name", categoryDto.getName());
	}

}
