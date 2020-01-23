package com.diego.saez.controller;

import java.util.List;

import org.easymock.EasyMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import com.diego.saez.dto.CategoryDto;
import com.diego.saez.dto.ProductDto;
import com.diego.saez.exception.BussinessException;
import com.diego.saez.exception.WebException;
import com.diego.saez.service.impl.CategoryService;
import com.diego.saez.service.impl.ProductService;
import com.diego.saez.test.common.UnitTest;

/**
 * Test case para {@link ProductController}
 * 
 * @author diegosaez
 *
 */
public class ProductControllerTest extends UnitTest {

	/**
	 * Caso positivo para findAll
	 * 
	 * @throws BussinessException
	 * @throws WebException
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testFindAll() throws BussinessException, WebException {
		ProductService productServiceMock = getProductServiceMock();
		EasyMock.expect(productServiceMock.findAll()).andReturn(getDummyProductDtoList(5));
		EasyMock.replay(productServiceMock);
		ProductController productController = new ProductController();
		ReflectionTestUtils.setField(productController, "productService", productServiceMock);
		Model modelo = new ExtendedModelMap();
		String view = productController.findAll(modelo);
		Assertions.assertNotNull(view);
		Assertions.assertEquals("products", view);
		List<ProductDto> productsDto = (List<ProductDto>) modelo.getAttribute("products");
		Assertions.assertEquals(5, productsDto.size());
		EasyMock.verify(productServiceMock);
	}

	/**
	 * Caso positivo para newProduct
	 * 
	 * @throws BussinessException
	 * @throws WebException
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testNewProduct() throws BussinessException, WebException {
		CategoryService categoryServiceMock = getCategoryServiceMock();
		EasyMock.expect(categoryServiceMock.findAll()).andReturn(getDummyCategoryDtoList(5));
		EasyMock.replay(categoryServiceMock);
		ProductController productController = new ProductController();
		ReflectionTestUtils.setField(productController, "categoryService", categoryServiceMock);
		Model modelo = new ExtendedModelMap();
		String view = productController.newProduct(modelo);
		Assertions.assertNotNull(view);
		Assertions.assertEquals("product_new", view);
		List<CategoryDto> categoriesDto = (List<CategoryDto>) modelo.getAttribute("categories");
		Assertions.assertEquals(5, categoriesDto.size());
		EasyMock.verify(categoryServiceMock);
	}

	/**
	 * Caso positivo para editProduct
	 * 
	 * @throws BussinessException
	 * @throws WebException
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testEditProduct() throws BussinessException, WebException {
		CategoryService categoryServiceMock = getCategoryServiceMock();
		ProductService productServiceMock = getProductServiceMock();
		EasyMock.expect(productServiceMock.findById(EasyMock.anyLong())).andReturn(getDummyProductDto(1));
		EasyMock.expect(categoryServiceMock.findAll()).andReturn(getDummyCategoryDtoList(5));
		EasyMock.replay(categoryServiceMock, productServiceMock);
		ProductController productController = new ProductController();
		ReflectionTestUtils.setField(productController, "categoryService", categoryServiceMock);
		ReflectionTestUtils.setField(productController, "productService", productServiceMock);
		Model modelo = new ExtendedModelMap();
		String view = productController.editProduct(2L, modelo);
		Assertions.assertNotNull(view);
		Assertions.assertEquals("product_edit", view);
		List<CategoryDto> categoriesDto = (List<CategoryDto>) modelo.getAttribute("categories");
		ProductDto product = (ProductDto) modelo.getAttribute("product");
		Assertions.assertEquals(5, categoriesDto.size());
		Assertions.assertNotNull(product);
		Assertions.assertEquals(2L, product.getIdProduct());
		EasyMock.verify(categoryServiceMock, productServiceMock);
	}

	/**
	 * Caso positivo para deleteProduct
	 * 
	 * @throws BussinessException
	 * @throws WebException
	 */
	@Test
	public void testDeleteProduct() throws BussinessException, WebException {
		ProductService productServiceMock = getProductServiceMock();
		productServiceMock.delete(EasyMock.anyLong());
		EasyMock.expectLastCall();
		EasyMock.replay(productServiceMock);
		ProductController productController = new ProductController();
		ReflectionTestUtils.setField(productController, "productService", productServiceMock);
		String view = productController.deleteProduct(3L);
		Assertions.assertNotNull(view);
		Assertions.assertEquals("redirect:/products", view);
		EasyMock.verify(productServiceMock);
	}

	/**
	 * Caso positivo para saveProduct (create)
	 * 
	 * @throws BussinessException
	 * @throws WebException
	 */
	@Test
	public void testSaveProductCreate() throws BussinessException, WebException {
		ProductService productServiceMock = getProductServiceMock();
		EasyMock.expect(productServiceMock.create(EasyMock.anyObject(ProductDto.class)))
				.andReturn(getDummyProductDto(3));
		EasyMock.replay(productServiceMock);
		ProductController productController = new ProductController();
		ProductDto productDto = getDummyProductDto(0);
		productDto.setIdProduct(null);
		ReflectionTestUtils.setField(productController, "productService", productServiceMock);
		String view = productController.saveProduct(productDto);
		Assertions.assertNotNull(view);
		Assertions.assertEquals("redirect:/products", view);
		Assertions.assertNotNull(productDto);
		EasyMock.verify(productServiceMock);
	}

	/**
	 * Caso positivo para saveProduct (update)
	 * 
	 * @throws BussinessException
	 * @throws WebException
	 */
	@Test
	public void testSaveProductUpdate() throws BussinessException, WebException {
		ProductService productServiceMock = getProductServiceMock();
		EasyMock.expect(productServiceMock.update(EasyMock.anyObject(ProductDto.class)))
				.andReturn(getDummyProductDto(3));
		EasyMock.replay(productServiceMock);
		ProductController productController = new ProductController();
		ReflectionTestUtils.setField(productController, "productService", productServiceMock);
		String view = productController.saveProduct(getDummyProductDto(0));
		Assertions.assertNotNull(view);
		Assertions.assertEquals("redirect:/products", view);
		EasyMock.verify(productServiceMock);
	}

	/**
	 * Caso negativo para findAll: productService lanza {@link BussinessException}
	 * 
	 * @throws BussinessException
	 */
	@Test
	public void testFindAllThrowException() throws BussinessException {
		ProductService productServiceMock = getProductServiceMock();
		EasyMock.expect(productServiceMock.findAll())
				.andThrow(new BussinessException("Error al listar todo los productos"));
		EasyMock.replay(productServiceMock);
		ProductController productController = new ProductController();
		ReflectionTestUtils.setField(productController, "productService", productServiceMock);
		Model modelo = new ExtendedModelMap();
		Assertions.assertThrows(WebException.class, () -> productController.findAll(modelo));
		EasyMock.verify(productServiceMock);
	}

	/**
	 * Caso negativo para newProduct: categoryService lanza BussinessException
	 * 
	 * @throws BussinessException
	 * @throws WebException
	 */
	@Test
	public void testNewProductThrowException() throws BussinessException, WebException {
		CategoryService categoryServiceMock = getCategoryServiceMock();
		EasyMock.expect(categoryServiceMock.findAll())
				.andThrow(new BussinessException("Error al listar las categorías de productos"));
		EasyMock.replay(categoryServiceMock);
		ProductController productController = new ProductController();
		ReflectionTestUtils.setField(productController, "categoryService", categoryServiceMock);
		Model modelo = new ExtendedModelMap();
		Assertions.assertThrows(WebException.class, () -> productController.newProduct(modelo));
		EasyMock.verify(categoryServiceMock);
	}

	/**
	 * Caso negativo para editPruduct: productService lanza BussinessException
	 * 
	 * @throws BussinessException
	 * @throws WebException
	 */
	@Test
	public void testEditProductThrowException() throws BussinessException, WebException {
		ProductService productServiceMock = getProductServiceMock();
		EasyMock.expect(productServiceMock.findById(EasyMock.anyLong()))
				.andThrow(new BussinessException("Error al buscar el producto"));
		EasyMock.replay(productServiceMock);
		ProductController productController = new ProductController();
		ReflectionTestUtils.setField(productController, "productService", productServiceMock);
		Model modelo = new ExtendedModelMap();
		Assertions.assertThrows(WebException.class, () -> productController.editProduct(2L, modelo));
		EasyMock.verify(productServiceMock);
	}

	/**
	 * Caso negativo para deleteProduct: productService lanza BussinessException
	 * 
	 * @throws BussinessException
	 * @throws WebException
	 */
	@Test
	public void testDeleteProductThrowException() throws BussinessException, WebException {
		ProductService productServiceMock = getProductServiceMock();
		productServiceMock.delete(EasyMock.anyLong());
		EasyMock.expectLastCall().andThrow(new BussinessException("Error al eliminar el producto"));
		EasyMock.replay(productServiceMock);
		ProductController productController = new ProductController();
		ReflectionTestUtils.setField(productController, "productService", productServiceMock);
		Assertions.assertThrows(WebException.class, () -> productController.deleteProduct(3L));
		EasyMock.verify(productServiceMock);
	}

	/**
	 * Caso negativo para saveProduct (create): Se envía productoDto con stock
	 * negativo
	 * 
	 * @throws BussinessException
	 * @throws WebException
	 */
	@Test
	public void testSaveProductCreateThrowException() throws BussinessException, WebException {
		ProductController productController = new ProductController();
		ProductDto productDto = getDummyProductDto(0);
		productDto.setIdProduct(null);
		productDto.setStockProduct(-1);
		ReflectionTestUtils.setField(productController, "productService", new ProductService());
		Assertions.assertThrows(WebException.class, () -> productController.saveProduct(productDto));
	}

	/**
	 * Caso negativo para saveProduct (update): Se envía productoDto con nombre null
	 * 
	 * @throws BussinessException
	 * @throws WebException
	 */
	@Test
	public void testSaveProductUpdateThrowException() throws BussinessException, WebException {
		ProductController productController = new ProductController();
		ReflectionTestUtils.setField(productController, "productService", new ProductService());
		ProductDto productDto = getDummyProductDto(0);
		productDto.setNameProduct(null);
		Assertions.assertThrows(WebException.class, () -> productController.saveProduct(productDto));
	}

	/**
	 * Caso positivo para handleError
	 */
	@Test
	public void testHandleError() {
		ProductController productController = new ProductController();
		MockHttpServletRequest httpServletRequestMock = new MockHttpServletRequest();
		ModelAndView modelAndView = productController.handleError(httpServletRequestMock,
				new WebException("El producto debe tener nombre"));
		Assertions.assertNotNull(modelAndView);
		Assertions.assertEquals("error", modelAndView.getViewName());
		Assertions.assertNotNull(modelAndView.getModelMap());
		Assertions.assertEquals("El producto debe tener nombre", modelAndView.getModelMap().get("message"));
	}

}
