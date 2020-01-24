package com.diego.saez.dto.mapper;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.diego.saez.dto.ProductDto;
import com.diego.saez.exception.MapperException;
import com.diego.saez.model.Product;
import com.diego.saez.test.common.UnitTest;

/**
 * Test Case for {@link ProductMapper}.
 * 
 * @author diegosaez
 *
 */
public class ProductMapperTest extends UnitTest {

	private ProductMapper productMapper = new ProductMapper();

	/**
	 * Positive case for toEntity(productDto).
	 * 
	 * @throws MapperException
	 */
	@Test
	public void testToEntity() throws MapperException {
		ProductDto productDto = getDummyProductDto(0);
		productDto.setIdProduct(1L);
		Product productEntity = productMapper.toEntity(productDto);
		Assertions.assertNotNull(productEntity);
		Assertions.assertEquals(1L, productEntity.getId());
		Assertions.assertEquals("Product Dummy", productEntity.getName());
		Assertions.assertNotNull(productEntity.getCategory());
	}

	/**
	 * Negative case for toEntity: The product entered is null.
	 * 
	 * @throws MapperException
	 */
	@Test
	public void testToEntityThrowException() throws MapperException {
		Assertions.assertThrows(MapperException.class, () -> productMapper.toEntity(null));
	}

	/**
	 * Positive case for toDto(product).
	 * 
	 * @throws MapperException
	 */
	@Test
	public void testToDtoProduct() throws MapperException {
		ProductDto productDto = productMapper.toDto(getDummyProduct(0));
		Assertions.assertNotNull(productDto);
		Assertions.assertEquals(1L, productDto.getIdProduct());
		Assertions.assertEquals("Product 1", productDto.getNameProduct());
		Assertions.assertNotNull(productDto.getIdCategory());
	}

	/**
	 * Negative case for toDto: The product entered is null.
	 * 
	 * @throws MapperException
	 */
	@Test
	public void testToDtoProductThrowException() throws MapperException {
		Product product = null;
		Assertions.assertThrows(MapperException.class, () -> productMapper.toDto(product));
	}

	/**
	 * Positive case for toDto(List<Product>).
	 * 
	 * @throws MapperException
	 */
	@Test
	public void testToDtoListOfProduct() throws MapperException {
		List<ProductDto> productsDto = productMapper.toDto(getDummyProductList(5));
		Assertions.assertNotNull(productsDto);
		Assertions.assertEquals(5, productsDto.size());
	}

	/**
	 * Negative case for toDto: The product list entered is null.
	 * 
	 * @throws MapperException
	 */
	@Test
	public void testToDtoListOfProductThrowException() throws MapperException {
		List<Product> products = null;
		Assertions.assertThrows(MapperException.class, () -> productMapper.toDto(products));
	}

}
