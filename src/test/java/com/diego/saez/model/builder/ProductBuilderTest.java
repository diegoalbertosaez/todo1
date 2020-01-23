package com.diego.saez.model.builder;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.diego.saez.model.Category;
import com.diego.saez.model.Product;

/**
 * Test Case para {@link ProductBuilder}
 * 
 * @author diegosaez
 *
 */
public class ProductBuilderTest {

	/**
	 * Caso positivo para build()
	 */
	@Test
	public void testBuild() {
		ProductBuilder productBuilder = ProductBuilder.getInstance();
		Category category = new Category();
		Product product = productBuilder.withId(1L).withName("Name").withStock(120).withUnitPrice(15.50)
				.withCategory(category).build();
		Assertions.assertNotNull(product);
		Assertions.assertNotNull(product.getId());
		Assertions.assertNotNull(product.getName());
		Assertions.assertNotNull(product.getStock());
		Assertions.assertNotNull(product.getUnitPrice());
		Assertions.assertNotNull(product.getCategory());
		Assertions.assertEquals(1L, product.getId());
		Assertions.assertEquals("Name", product.getName());
		Assertions.assertEquals(120, product.getStock());
		Assertions.assertEquals(15.50, product.getUnitPrice());
	}

}
