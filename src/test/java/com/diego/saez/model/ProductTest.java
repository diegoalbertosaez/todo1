package com.diego.saez.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 
 * Test Case para {@link Product}
 * 
 * @author diegosaez
 *
 */
public class ProductTest {

	private Product product = new Product();

	/**
	 * Caso positivo para getId()
	 */
	@Test
	public void testGetId() {
		product.setId(1L);
		Assertions.assertNotNull(product.getId());
		Assertions.assertEquals(1L, product.getId());
	}

	/**
	 * Caso positivo para getName()
	 */
	@Test
	public void testGetName() {
		product.setName("Name");
		Assertions.assertNotNull(product.getName());
		Assertions.assertEquals("Name", product.getName());
	}

	/**
	 * Caso positivo para getStock()
	 */
	@Test
	public void testGetStock() {
		product.setStock(120);
		Assertions.assertNotNull(product.getStock());
		Assertions.assertEquals(120, product.getStock());
	}

	/**
	 * Caso positivo para getUnitPrice()
	 */
	@Test
	public void testGetUnitPrice() {
		product.setUnitPrice(21.0);
		Assertions.assertNotNull(product.getUnitPrice());
		Assertions.assertEquals(21, product.getUnitPrice());
	}

	/**
	 * Caso positivo para getCategory()
	 */
	@Test
	public void testGetCategory() {
		Category category = new Category();
		category.setId(2L);
		product.setCategory(category);
		Assertions.assertNotNull(product.getCategory());
		Assertions.assertEquals(2L, product.getCategory().getId());
	}

}
