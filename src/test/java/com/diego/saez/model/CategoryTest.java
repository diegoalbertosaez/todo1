package com.diego.saez.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Test Case for {@link Category}.
 * 
 * @author diegosaez
 *
 */
public class CategoryTest {

	private Category category = new Category();

	/**
	 * Positive case for getId().
	 */
	@Test
	public void testGetId() {
		category.setId(1L);
		Assertions.assertNotNull(category.getId());
		Assertions.assertEquals(1L, category.getId());
	}

	/**
	 * Positive case for getName().
	 */
	@Test
	public void testGetName() {
		category.setName("Name");
		Assertions.assertNotNull(category.getName());
		Assertions.assertEquals("Name", category.getName());
	}

}
