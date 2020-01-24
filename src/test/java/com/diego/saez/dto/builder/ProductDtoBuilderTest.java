package com.diego.saez.dto.builder;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.diego.saez.dto.ProductDto;

/**
 * Test Case for {@link ProductDtoBuilder}.
 * 
 * @author diegosaez
 *
 */
public class ProductDtoBuilderTest {

	/**
	 * Positive case for build().
	 */
	@Test
	public void testBuild() {
		ProductDtoBuilder productDtoBuilder = ProductDtoBuilder.getInstance();
		ProductDto productDto = productDtoBuilder.withIdProduct(1L).withIdCategory(1L).withNameCategory("Name Category")
				.withNameProduct("Name Product").withStockProduct(120).withUnitPrice(12.50).build();
		Assertions.assertNotNull(productDto.getIdProduct());
		Assertions.assertNotNull(productDto.getIdCategory());
		Assertions.assertNotNull(productDto.getNameCategory());
		Assertions.assertNotNull(productDto.getNameProduct());
		Assertions.assertNotNull(productDto.getStockProduct());
		Assertions.assertNotNull(productDto.getUnitPrice());
		Assertions.assertEquals(1L, productDto.getIdProduct());
		Assertions.assertEquals(1L, productDto.getIdCategory());
		Assertions.assertEquals("Name Category", productDto.getNameCategory());
		Assertions.assertEquals("Name Product", productDto.getNameProduct());
		Assertions.assertEquals(120, productDto.getStockProduct());
		Assertions.assertEquals(12.50, productDto.getUnitPrice());
	}

}
