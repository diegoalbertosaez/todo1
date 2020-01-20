package com.diego.saez.service.impl;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import com.diego.saez.model.Product;

@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
public class ProductServiceTestInt {

	@Autowired
	private ProductService productService;
	
	@Test
	public void testFindAll() {
		List<Product> products = productService.findAll();
		Assertions.assertFalse(products.isEmpty());
	}
	
	@Test
	public void testCreate() {
		Product product = new Product();
		product.setName("Nuevo Producto");
		product.setStock(5);
		Product newProduct = productService.create(product);
		Assertions.assertNotNull(newProduct.getId());
	}

}
