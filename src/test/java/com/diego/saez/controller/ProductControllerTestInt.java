package com.diego.saez.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import com.diego.saez.dto.ProductDto;
import com.diego.saez.dto.builder.ProductDtoBuilder;

@ExtendWith(SpringExtension.class)
@WebAppConfiguration
@AutoConfigureMockMvc
@ComponentScan("com.diego.saez")
@TestPropertySource(locations = "classpath:application-test.properties")
public class ProductControllerTestInt {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testFindAll() throws Exception {
		ModelAndView modelAndView = mockMvc.perform(get("/products")).andExpect(status().isOk()).andReturn()
				.getModelAndView();
		Assertions.assertNotNull(modelAndView);
		Assertions.assertNotNull(modelAndView.getViewName());
		Assertions.assertNotNull(modelAndView.getModelMap());
		Assertions.assertNotNull(modelAndView.getModelMap().getAttribute("products"));
		Assertions.assertEquals("products", modelAndView.getViewName());
	}

	@Test
	public void testNewProduct() throws Exception {
		ModelAndView modelAndView = mockMvc.perform(get("/products/new")).andExpect(status().isOk()).andReturn()
				.getModelAndView();
		Assertions.assertNotNull(modelAndView);
		Assertions.assertNotNull(modelAndView.getViewName());
		Assertions.assertNotNull(modelAndView.getModelMap());
		Assertions.assertEquals(1, modelAndView.getModelMap().size());
		Assertions.assertNotNull(modelAndView.getModelMap().getAttribute("categories"));
		Assertions.assertEquals("product_new", modelAndView.getViewName());
	}

	@Test
	public void testEditProduct() throws Exception {
		ModelAndView modelAndView = mockMvc.perform(get("/products/edit/1")).andExpect(status().isOk()).andReturn()
				.getModelAndView();
		Assertions.assertNotNull(modelAndView);
		Assertions.assertNotNull(modelAndView.getViewName());
		Assertions.assertNotNull(modelAndView.getModelMap());
		Assertions.assertNotNull(modelAndView.getModelMap().getAttribute("categories"));
		Assertions.assertNotNull(modelAndView.getModelMap().getAttribute("product"));
		Assertions.assertEquals("product_edit", modelAndView.getViewName());
	}

	@Test
	@Transactional(readOnly = true)
	public void testDeleteProduct() throws Exception {
		ModelAndView modelAndView = mockMvc.perform(delete("/products?id=1")).andExpect(status().is3xxRedirection())
				.andReturn().getModelAndView();
		Assertions.assertNotNull(modelAndView);
		Assertions.assertTrue(modelAndView.getModelMap().isEmpty());
		Assertions.assertEquals("redirect:/products", modelAndView.getViewName());
	}

	@Test
	@Transactional(readOnly = true)
	public void testSaveProductCreate() throws Exception {
		ProductDto dummyProductDto = getDummyProductDto();
		RequestBuilder request = post("/products").param("nameProduct", dummyProductDto.getNameProduct())
				.param("stockProduct", dummyProductDto.getStockProduct().toString())
				.param("unitPrice", dummyProductDto.getUnitPrice().toString())
				.param("idCategory", dummyProductDto.getIdCategory().toString());
		mockMvc.perform(request).andExpect(status().is3xxRedirection());
	}

	@Test
	@Transactional(readOnly = true)
	public void testSaveProductCreateInvalidProductDto() throws Exception {
		ProductDto dummyProductDto = getDummyProductDto();
		dummyProductDto.setStockProduct(-5);
		RequestBuilder request = post("/products").param("nameProduct", dummyProductDto.getNameProduct())
				.param("stockProduct", dummyProductDto.getStockProduct().toString())
				.param("unitPrice", dummyProductDto.getUnitPrice().toString())
				.param("idCategory", dummyProductDto.getIdCategory().toString());
		ModelAndView modelAndView = mockMvc.perform(request).andExpect(status().isOk()).andReturn().getModelAndView();
		Assertions.assertNotNull(modelAndView.getModelMap());
		Assertions.assertEquals("El stock del producto no puede ser negativo.",
				modelAndView.getModelMap().get("message"));
		Assertions.assertEquals("error", modelAndView.getViewName());
	}

	@Test
	@Transactional(readOnly = true)
	public void testSaveProductUpdate() throws Exception {
		ProductDto dummyProductDto = getDummyProductDto();
		dummyProductDto.setIdProduct(2L);
		RequestBuilder request = post("/products").param("nameProduct", dummyProductDto.getNameProduct())
				.param("stockProduct", dummyProductDto.getStockProduct().toString())
				.param("unitPrice", dummyProductDto.getUnitPrice().toString())
				.param("idCategory", dummyProductDto.getIdCategory().toString());
		mockMvc.perform(request).andExpect(status().is3xxRedirection());
	}

	@Test
	@Transactional(readOnly = true)
	public void testSaveProductUpdateInvalidProductDto() throws Exception {
		ProductDto dummyProductDto = getDummyProductDto();
		dummyProductDto.setNameProduct(null);
		RequestBuilder request = post("/products").param("nameProduct", dummyProductDto.getNameProduct())
				.param("stockProduct", dummyProductDto.getStockProduct().toString())
				.param("unitPrice", dummyProductDto.getUnitPrice().toString())
				.param("idCategory", dummyProductDto.getIdCategory().toString());
		ModelAndView modelAndView = mockMvc.perform(request).andExpect(status().isOk()).andReturn().getModelAndView();
		Assertions.assertNotNull(modelAndView.getModelMap());
		Assertions.assertEquals("El producto debe tener nombre.", modelAndView.getModelMap().get("message"));
		Assertions.assertEquals("error", modelAndView.getViewName());
	}

	private ProductDto getDummyProductDto() {
		ProductDtoBuilder productDtoBuilder = ProductDtoBuilder.getInstance();
		ProductDto productDto = productDtoBuilder.withIdProduct(null).withIdCategory(1L)
				.withNameCategory("Category Dummy").withNameProduct("Product Dummy").withStockProduct(120)
				.withUnitPrice(12.80).build();
		return productDto;
	}

}
