package com.diego.saez.service.impl;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;

import com.diego.saez.dto.ProductDto;
import com.diego.saez.dto.mapper.IMapper;
import com.diego.saez.exception.BussinessException;
import com.diego.saez.exception.MapperException;
import com.diego.saez.mode.builder.ProductDtoBuilder;
import com.diego.saez.model.Product;
import com.diego.saez.service.IProductService;

@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
public class ProductServiceTestInt {

	@Autowired
	private IProductService productService;
	
	@Autowired
	private IMapper<Product, ProductDto> productMapper;

	@Test
	public void testFindAll() throws BussinessException {
		List<ProductDto> products = productService.findAll();
		Assertions.assertFalse(products.isEmpty());
		Assertions.assertTrue(products.size() == 1);
	}

	@Test
	@Transactional(readOnly=true)
	public void testCreate() throws MapperException, BussinessException {
		Product product = new Product();
		product.setName("Nuevo Producto");
		product.setStock(5);
		ProductDto productDto = productMapper.toDto(product);
		ProductDto newProduct = productService.create(productDto);
		Assertions.assertNotNull(newProduct.getIdProduct());
	}
	
	@Test
	@Transactional(readOnly=true)
	public void testUpdate() throws BussinessException{
		final String nameProduct = "Nuevo nombre";
		ProductDto productDtoToUpdate = ProductDtoBuilder.getInstance().withIdProduct(1L).withIdCategory(3L).withNameProduct(nameProduct).build();		
		ProductDto productDtoUpdated = productService.update(productDtoToUpdate);
		Assertions.assertNotNull(productDtoUpdated);
		Assertions.assertNotNull(productDtoUpdated.getIdProduct());
		Assertions.assertNotNull(productDtoUpdated.getIdCategory());
		Assertions.assertNotNull(productDtoUpdated.getNameProduct());
		Assertions.assertEquals(nameProduct, productDtoUpdated.getNameProduct());
	}
	
	@Test
	@Transactional(readOnly=true)
	public void testDelete() throws BussinessException{
		productService.delete(1L);		
		List<ProductDto> products = productService.findAll();
		Assertions.assertNotNull(products);
		Assertions.assertEquals(0, products);
	}

}
