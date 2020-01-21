package com.diego.saez.service.impl;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import com.diego.saez.dto.ProductDto;
import com.diego.saez.dto.mapper.IMapper;
import com.diego.saez.exception.BussinessException;
import com.diego.saez.exception.MapperException;
import com.diego.saez.model.Product;

@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
public class ProductServiceTestInt {

	@Autowired
	private ProductService productService;
	
	@Autowired
	private IMapper<Product, ProductDto> productMapper;

	@Test
	public void testFindAll() throws BussinessException {
		List<ProductDto> products = productService.findAll();
		Assertions.assertFalse(products.isEmpty());
		Assertions.assertTrue(products.size() == 1);
	}

	@Test
	public void testCreate() throws MapperException, BussinessException {
		Product product = new Product();
		product.setName("Nuevo Producto");
		product.setStock(5);
		ProductDto productDto = productMapper.toDto(product);
		ProductDto newProduct = productService.create(productDto);
		Assertions.assertNotNull(newProduct.getIdProduct());
	}

}
