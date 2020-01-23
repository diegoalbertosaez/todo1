/**
 * 
 */
package com.diego.saez.dto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Test Case para {@link ProductDto}
 * 
 * @author diegosaez
 *
 */
public class ProductDtoTest {

	private ProductDto productDto = new ProductDto();

	/**
	 * Caso positivo para constructor
	 */
	public void testConstructor() {
		ProductDto productDto = new ProductDto();
		Assertions.assertTrue(productDto.getClass().getName().equals("ProductDto"));

	}

	/**
	 * Caso positivo para getIdProduct()
	 */
	@Test
	public void testGetIdProduct() {
		productDto.setIdProduct(1L);
		Assertions.assertNotNull(productDto.getIdProduct());
		Assertions.assertEquals(1L, productDto.getIdProduct());
	}

	/**
	 * Caso positivo para getNameProduct
	 */
	@Test
	public void testGetNameProduct() {
		productDto.setNameProduct("Name");
		Assertions.assertNotNull(productDto.getNameProduct());
		Assertions.assertEquals("Name", productDto.getNameProduct());
	}

	/**
	 * Caso positivo para getStockProduct
	 */
	@Test
	public void testGetStockProduct() {
		productDto.setStockProduct(20);
		Assertions.assertNotNull(productDto.getStockProduct());
		Assertions.assertEquals(20, productDto.getStockProduct());
	}

	/**
	 * Caso positivo para getIdCategory
	 */
	@Test
	public void testGetIdCategory() {
		productDto.setIdCategory(15L);
		Assertions.assertNotNull(productDto.getIdCategory());
		Assertions.assertEquals(15L, productDto.getIdCategory());
	}

	/**
	 * Caso positivo para getNameCategory
	 */
	@Test
	public void testGetNameCategory() {
		productDto.setNameCategory("Name Category");
		Assertions.assertNotNull(productDto.getNameCategory());
		Assertions.assertEquals("Name Category", productDto.getNameCategory());
	}

	/**
	 * Caso positivo para getUnitPrice
	 */
	@Test
	public void testGetUnitPrice() {
		productDto.setUnitPrice(20.50);
		Assertions.assertNotNull(productDto.getUnitPrice());
		Assertions.assertEquals(20.50, productDto.getUnitPrice());
	}

}
