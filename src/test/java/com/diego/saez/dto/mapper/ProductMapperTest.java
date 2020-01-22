package com.diego.saez.dto.mapper;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.diego.saez.dto.ProductDto;
import com.diego.saez.dto.builder.CategoryBuilder;
import com.diego.saez.dto.builder.ProductBuilder;
import com.diego.saez.exception.MapperException;
import com.diego.saez.model.Category;
import com.diego.saez.model.Product;
import com.diego.saez.model.builder.ProductDtoBuilder;

public class ProductMapperTest {

	private ProductMapper productMapper = new ProductMapper();

	@Test
	void testToEntity() throws MapperException {
		Product productEntity = productMapper.toEntity(getDummyProductDto());
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
	
	
	private ProductDto getDummyProductDto() {
		ProductDtoBuilder productDtoBuilder = ProductDtoBuilder.getInstance();
		ProductDto productDto = productDtoBuilder.withIdProduct(1L).withIdCategory(1L)
				.withNameCategory("Category Dummy").withNameProduct("Product Dummy").withStockProduct(120)
				.withUnitPrice(12.80).build();
		return productDto;
	}
	
	private List<Product> getDummyProductList(Integer amount) {
		List<Product> productsDummy = new ArrayList<Product>();
		for (int i = 0; i < amount; i++) {
			productsDummy.add(getDummyProduct(i));
		}
		return productsDummy;
	}
	
	private Product getDummyProduct(Integer index) {
		ProductBuilder productBuilder = ProductBuilder.getInstance();
		CategoryBuilder categoryBuilder = CategoryBuilder.getInstance();
		Category category = categoryBuilder.withId(index + 1L).withName("Category ".concat(Integer.toString(index + 1)))
				.build();
		Product product = productBuilder.withId(index + 1L).withName("Product ".concat(Integer.toString(index + 1)))
				.withStock(index + 1).withStock(10).withCategory(category).build();
		return product;
	}

}
