package com.diego.saez.dto.mapper;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.diego.saez.dto.ProductDto;
import com.diego.saez.exception.MapperException;
import com.diego.saez.model.Product;
import com.diego.saez.test.common.UnitTest;

public class ProductMapperTest extends UnitTest {

	private ProductMapper productMapper = new ProductMapper();

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

	@Test
	public void testToEntityThrowException() throws MapperException {
		Assertions.assertThrows(MapperException.class, () -> productMapper.toEntity(null));
	}

	@Test
	public void testToDtoProduct() throws MapperException {
		ProductDto productDto = productMapper.toDto(getDummyProduct(0));
		Assertions.assertNotNull(productDto);
		Assertions.assertEquals(1L, productDto.getIdProduct());
		Assertions.assertEquals("Product 1", productDto.getNameProduct());
		Assertions.assertNotNull(productDto.getIdCategory());
	}

	@Test
	public void testToDtoProductThrowException() throws MapperException {
		List<Product> products = null;
		Assertions.assertThrows(MapperException.class, () -> productMapper.toDto(products));
	}

	@Test
	public void testToDtoListOfProduct() throws MapperException {
		List<ProductDto> productsDto = productMapper.toDto(getDummyProductList(5));
		Assertions.assertNotNull(productsDto);
		Assertions.assertEquals(5, productsDto.size());
	}

	@Test
	public void testToDtoListOfProductThrowException() throws MapperException {
		Product product = null;
		Assertions.assertThrows(MapperException.class, () -> productMapper.toDto(product));
	}

}
