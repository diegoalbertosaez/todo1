package com.diego.saez.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;

import com.diego.saez.dto.ProductDto;
import com.diego.saez.dto.builder.ProductDtoBuilder;
import com.diego.saez.exception.BussinessException;
import com.diego.saez.exception.MapperException;
import com.diego.saez.service.IProductService;

/**
 * Integration test for {@link ProductService}.
 * 
 * @author diegosaez
 *
 */
@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
public class ProductServiceTestInt {

	@Autowired
	private IProductService productService;

	/**
	 * Positive case for findAll.
	 * 
	 * @throws BussinessException
	 */
	@Test
	@Transactional
	public void testFindAll() throws BussinessException {
		List<ProductDto> products = productService.findAll();
		Assertions.assertFalse(products.isEmpty());
		Assertions.assertTrue(products.size() > 2);
	}

	/**
	 * Positive case for create.
	 * 
	 * @throws MapperException
	 * @throws BussinessException
	 */
	@Test
	@Transactional(readOnly = true)
	public void testCreate() throws MapperException, BussinessException {
		ProductDtoBuilder productBuilder = ProductDtoBuilder.getInstance();
		ProductDto productDtoToSave = productBuilder.withNameProduct("Nuevo Producto").withUnitPrice(10D)
				.withStockProduct(120).withIdCategory(2L).build();
		ProductDto newProduct = productService.create(productDtoToSave);
		Assertions.assertNotNull(newProduct.getIdProduct());
		Assertions.assertEquals("Nuevo Producto", newProduct.getNameProduct());
		Assertions.assertNotNull(newProduct.getIdCategory());
		Assertions.assertEquals(2L, newProduct.getIdCategory());
	}

	/**
	 * Positive case for update.
	 * 
	 * @throws BussinessException
	 */
	@Test
	@Transactional(readOnly = true)
	public void testUpdate() throws BussinessException {
		final String nameProduct = "Nuevo nombre";
		ProductDto productDtoToUpdate = ProductDtoBuilder.getInstance().withIdProduct(1L).withIdCategory(3L)
				.withNameProduct(nameProduct).withStockProduct(120).withUnitPrice(2.60).build();
		ProductDto productDtoUpdated = productService.update(productDtoToUpdate);
		Assertions.assertNotNull(productDtoUpdated);
		Assertions.assertNotNull(productDtoUpdated.getIdProduct());
		Assertions.assertNotNull(productDtoUpdated.getIdCategory());
		Assertions.assertNotNull(productDtoUpdated.getNameProduct());
		Assertions.assertEquals(nameProduct, productDtoUpdated.getNameProduct());
	}

	/**
	 * Positive case for delete.
	 * 
	 * @throws BussinessException
	 */
	@Test
	@Transactional
	public void testDelete() throws BussinessException {
		productService.delete(3L);
		List<ProductDto> products = productService.findAll();
		Assertions.assertNotNull(products);
		Assertions.assertEquals(2, products.size());
	}

	/**
	 * Positive case for findById.
	 * 
	 * @throws BussinessException
	 */
	@Test
	@Transactional
	public void testFindById() throws BussinessException {
		ProductDto productDto = productService.findById(2L);
		Assertions.assertNotNull(productDto);
		assertEquals("PRODUCTO 2(IT)", productDto.getNameProduct());
	}
}
