package com.diego.saez.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.easymock.EasyMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.dao.RecoverableDataAccessException;
import org.springframework.test.util.ReflectionTestUtils;

import com.diego.saez.dto.ProductDto;
import com.diego.saez.dto.builder.CategoryBuilder;
import com.diego.saez.dto.builder.ProductBuilder;
import com.diego.saez.dto.mapper.ProductMapper;
import com.diego.saez.exception.BussinessException;
import com.diego.saez.model.Category;
import com.diego.saez.model.Product;
import com.diego.saez.model.builder.ProductDtoBuilder;
import com.diego.saez.repository.ProductRepository;

/**
 * Test case para ProductService
 * @author diegosaez
 *
 */
public class ProductServiceTest {

	/**
	 * Test positivo findAll
	 * 
	 * @throws BussinessException
	 */
	@Test
	public void testFindAll() throws BussinessException {
		ProductRepository productRepositoryMock = getProductRepositoryMock();
		final int amountProductDummies = 10;
		EasyMock.expect(productRepositoryMock.findAll()).andReturn(getDummyProductList(amountProductDummies));
		EasyMock.replay(productRepositoryMock);
		ProductService productService = new ProductService();
		ProductMapper productMapper = new ProductMapper();
		ReflectionTestUtils.setField(productService, "productRepository", productRepositoryMock);
		ReflectionTestUtils.setField(productService, "productMapper", productMapper);
		List<ProductDto> products = productService.findAll();
		Assertions.assertNotNull(products);
		Assertions.assertEquals(amountProductDummies, products.size());
	}

	/**
	 * Caso negativo para findAll, productRepository lanza
	 * RecoverableDataAccessException. Se espera BussinessException
	 * 
	 * @throws BussinessException
	 */
	@Test
	public void testFindAllThrowException() throws BussinessException {
		ProductRepository productRepositoryMock = getProductRepositoryMock();
		EasyMock.expect(productRepositoryMock.findAll())
				.andThrow(new RecoverableDataAccessException("Error en repositorio"));
		EasyMock.replay(productRepositoryMock);
		ProductService productService = new ProductService();
		ProductMapper productMapper = new ProductMapper();
		ReflectionTestUtils.setField(productService, "productRepository", productRepositoryMock);
		ReflectionTestUtils.setField(productService, "productMapper", productMapper);
		Assertions.assertThrows(BussinessException.class, () -> productService.findAll());
		EasyMock.verify(productRepositoryMock);
	}

	/**
	 * Caso positivo para create
	 * 
	 * @throws BussinessException
	 */
	@Test
	public void testCreate() throws BussinessException {
		ProductRepository productRepositoryMock = getProductRepositoryMock();
		EasyMock.expect(productRepositoryMock.save(EasyMock.anyObject(Product.class))).andReturn(getDummyProduct(0));
		EasyMock.replay(productRepositoryMock);
		ProductService productService = new ProductService();
		ProductMapper productMapper = new ProductMapper();
		ReflectionTestUtils.setField(productService, "productRepository", productRepositoryMock);
		ReflectionTestUtils.setField(productService, "productMapper", productMapper);
		ProductDto productCreated = productService.create(getDummyProductDto());
		Assertions.assertNotNull(productCreated);
		Assertions.assertNotNull(productCreated.getIdProduct());
		Assertions.assertNotNull(productCreated.getNameProduct());
		Assertions.assertNotNull(productCreated.getNameCategory());
		Assertions.assertEquals(1L, productCreated.getIdProduct());
		EasyMock.verify(productRepositoryMock);
	}

	/**
	 * Caso negativo para create. Se envía producto con valores no válidos. Se
	 * espera BussinessException.
	 * 
	 * @throws BussinessException
	 */
	@Test
	public void testCreateInvalidParameter() throws BussinessException {
		ProductService productService = new ProductService();
		ProductDto dummyProductDtoToCreate = getDummyProductDto();
		dummyProductDtoToCreate.setStockProduct(-1);
		Assertions.assertThrows(BussinessException.class, () -> productService.create(dummyProductDtoToCreate));
	}

	/**
	 * Caso negativo para create, productRepository lanza
	 * RecoverableDataAccessException. Se espera BussinessException
	 * 
	 * @throws BussinessException
	 */
	@Test
	public void testCreateThrowsException() throws BussinessException {
		ProductRepository productRepositoryMock = getProductRepositoryMock();
		EasyMock.expect(productRepositoryMock.save(EasyMock.anyObject(Product.class)))
				.andThrow(new RecoverableDataAccessException("Error en repositorio"));
		EasyMock.replay(productRepositoryMock);
		ProductService productService = new ProductService();
		ProductMapper productMapper = new ProductMapper();
		ReflectionTestUtils.setField(productService, "productRepository", productRepositoryMock);
		ReflectionTestUtils.setField(productService, "productMapper", productMapper);
		Assertions.assertThrows(BussinessException.class, () -> productService.create(getDummyProductDto()));
		EasyMock.verify(productRepositoryMock);
	}

	/**
	 * Caso positivo para update
	 * 
	 * @throws BussinessException
	 */
	@Test
	public void testUpdate() throws BussinessException {
		ProductRepository productRepositoryMock = getProductRepositoryMock();
		EasyMock.expect(productRepositoryMock.findById(EasyMock.anyLong())).andReturn(Optional.of(getDummyProduct(0)));
		EasyMock.expect(productRepositoryMock.save(EasyMock.anyObject(Product.class))).andReturn(getDummyProduct(0));
		EasyMock.replay(productRepositoryMock);
		ProductService productService = new ProductService();
		ProductMapper productMapper = new ProductMapper();
		ReflectionTestUtils.setField(productService, "productRepository", productRepositoryMock);
		ReflectionTestUtils.setField(productService, "productMapper", productMapper);
		ProductDto productUpdated = productService.update(getDummyProductDto());
		Assertions.assertNotNull(productUpdated);
		Assertions.assertNotNull(productUpdated.getIdProduct());
		Assertions.assertNotNull(productUpdated.getNameProduct());
		Assertions.assertNotNull(productUpdated.getNameCategory());
		Assertions.assertEquals(1L, productUpdated.getIdProduct());
	}

	/**
	 * Caso negativo para update, el producto que se desea actualizar no existe. Se
	 * espera BussinessException
	 * 
	 * @throws BussinessException
	 */
	@Test
	public void testUpdateProductToUpdateNotExists() throws BussinessException {
		ProductRepository productRepositoryMock = getProductRepositoryMock();
		EasyMock.expect(productRepositoryMock.findById(EasyMock.anyLong())).andReturn(Optional.empty());
		EasyMock.replay(productRepositoryMock);
		ProductService productService = new ProductService();
		ReflectionTestUtils.setField(productService, "productRepository", productRepositoryMock);
		Assertions.assertThrows(BussinessException.class, () -> productService.update(getDummyProductDto()));
		EasyMock.verify(productRepositoryMock);
	}

	/**
	 * Caso negativo para update, el poducto enviado es null. Se espera
	 * BussinessException
	 * 
	 * @throws BussinessException
	 */
	@Test
	public void testUpdateProductIsNull() throws BussinessException {
		ProductService productService = new ProductService();
		Assertions.assertThrows(BussinessException.class, () -> productService.update(null));
	}

	/**
	 * Caso positivo para findById
	 * 
	 * @throws BussinessException
	 */
	@Test
	public void testFindById() throws BussinessException {
		ProductRepository productRepositoryMock = getProductRepositoryMock();
		EasyMock.expect(productRepositoryMock.getOne(EasyMock.anyLong())).andReturn(getDummyProduct(1));
		EasyMock.replay(productRepositoryMock);
		ProductService productService = new ProductService();
		ProductMapper productMapper = new ProductMapper();
		ReflectionTestUtils.setField(productService, "productRepository", productRepositoryMock);
		ReflectionTestUtils.setField(productService, "productMapper", productMapper);
		ProductDto productFound = productService.findById(1L);
		Assertions.assertNotNull(productFound);
		Assertions.assertNotNull(productFound.getIdProduct());
		Assertions.assertEquals(2L, productFound.getIdProduct());
		EasyMock.verify(productRepositoryMock);
	}

	/**
	 * Caso negativo para findById, el id del producto que se desea buscar en null.
	 * Se espera BussinessException
	 * 
	 * @throws BussinessException
	 */
	@Test
	public void testFindByIdProductIdIsNull() throws BussinessException {
		ProductService productService = new ProductService();
		Assertions.assertThrows(BussinessException.class, () -> productService.findById(null));
	}

	/**
	 * Caso negativo para findById, productRepository lanza RecoverableDataAccessException. Se espera BussinessException
	 * @throws BussinessException
	 */
	@Test
	public void testFindByIdThrowException() throws BussinessException {
		ProductRepository productRepositoryMock = getProductRepositoryMock();
		EasyMock.expect(productRepositoryMock.getOne(EasyMock.anyLong())).andThrow(new RecoverableDataAccessException("Error en repositorio"));
		EasyMock.replay(productRepositoryMock);
		ProductService productService = new ProductService();
		ReflectionTestUtils.setField(productService, "productRepository", productRepositoryMock);
		Assertions.assertThrows(BussinessException.class, () -> productService.findById(1L));
		EasyMock.verify(productRepositoryMock);
	}
	
	/**
	 * Caso positivo para delete
	 * @throws BussinessException
	 */
	@Test
	public void testDelete() throws BussinessException {
		ProductRepository productRepositoryMock = getProductRepositoryMock();
		EasyMock.expect(productRepositoryMock.findById(EasyMock.anyLong())).andReturn(Optional.of(getDummyProduct(0)));
		productRepositoryMock.deleteById(EasyMock.anyLong());
		EasyMock.expectLastCall();
		EasyMock.replay(productRepositoryMock);
		ProductService productService = new ProductService();
		ReflectionTestUtils.setField(productService, "productRepository", productRepositoryMock);		
		productService.delete(1L);
		EasyMock.verify(productRepositoryMock);
	}

	/**
	 * Caso negativo para delete, el producto que se desea eliminar no existe. Se espera BussinessException
	 * @throws BussinessException
	 */
	@Test
	public void testDeleteThrowException() throws BussinessException {
		ProductRepository productRepositoryMock = getProductRepositoryMock();
		EasyMock.expect(productRepositoryMock.findById(EasyMock.anyLong())).andReturn(Optional.empty());
		EasyMock.replay(productRepositoryMock);
		ProductService productService = new ProductService();
		ReflectionTestUtils.setField(productService, "productRepository", productRepositoryMock);		
		Assertions.assertThrows(BussinessException.class, () -> productService.delete(1L));
		EasyMock.verify(productRepositoryMock);
	}
	
	/**
	 * Caso negativo para delete, el id del producto que se desea eliminar es null. Se espera BussinessException
	 * @throws BussinessException
	 */
	@Test
	public void testDeleteProductIdIsNull() throws BussinessException {
		ProductService productService = new ProductService();
		Assertions.assertThrows(BussinessException.class, () -> productService.delete(null));
	}
	
	private List<Product> getDummyProductList(Integer amount) {
		List<Product> productsDummy = new ArrayList<Product>();
		for (int i = 0; i < amount; i++) {
			productsDummy.add(getDummyProduct(i));
		}
		return productsDummy;
	}

	private ProductRepository getProductRepositoryMock() {
		ProductRepository productRepositoryMock = (ProductRepository) EasyMock.createMock(ProductRepository.class);
		EasyMock.reset(productRepositoryMock);
		return productRepositoryMock;
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

	private ProductDto getDummyProductDto() {
		ProductDtoBuilder productDtoBuilder = ProductDtoBuilder.getInstance();
		ProductDto productDto = productDtoBuilder.withIdProduct(null).withIdCategory(1L)
				.withNameCategory("Category Dummy").withNameProduct("Product Dummy").withStockProduct(120)
				.withUnitPrice(12.80).build();
		return productDto;
	}

}