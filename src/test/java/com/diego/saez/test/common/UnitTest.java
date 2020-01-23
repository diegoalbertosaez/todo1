package com.diego.saez.test.common;

import java.util.ArrayList;
import java.util.List;

import org.easymock.EasyMock;

import com.diego.saez.dto.CategoryDto;
import com.diego.saez.dto.ProductDto;
import com.diego.saez.dto.builder.CategoryDtoBuilder;
import com.diego.saez.dto.builder.ProductDtoBuilder;
import com.diego.saez.model.Category;
import com.diego.saez.model.Product;
import com.diego.saez.model.builder.CategoryBuilder;
import com.diego.saez.model.builder.ProductBuilder;
import com.diego.saez.repository.CategoryRepository;
import com.diego.saez.repository.ProductRepository;
import com.diego.saez.service.impl.CategoryService;
import com.diego.saez.service.impl.ProductService;

public class UnitTest {

	protected List<Product> getDummyProductList(Integer amount) {
		List<Product> productsDummy = new ArrayList<Product>();
		for (int i = 0; i < amount; i++) {
			productsDummy.add(getDummyProduct(i));
		}
		return productsDummy;
	}

	protected ProductRepository getProductRepositoryMock() {
		ProductRepository productRepositoryMock = (ProductRepository) EasyMock.createMock(ProductRepository.class);
		EasyMock.reset(productRepositoryMock);
		return productRepositoryMock;
	}

	protected Product getDummyProduct(Integer index) {
		ProductBuilder productBuilder = ProductBuilder.getInstance();
		CategoryBuilder categoryBuilder = CategoryBuilder.getInstance();
		Category category = categoryBuilder.withId(index + 1L).withName("Category ".concat(Integer.toString(index + 1)))
				.build();
		Product product = productBuilder.withId(index + 1L).withName("Product ".concat(Integer.toString(index + 1)))
				.withStock(index + 1).withStock(10).withCategory(category).build();
		return product;
	}

	protected ProductDto getDummyProductDto(Integer index) {
		ProductDtoBuilder productDtoBuilder = ProductDtoBuilder.getInstance();
		ProductDto productDto = productDtoBuilder.withIdProduct(index + 1L).withIdCategory(index + 1L)
				.withNameCategory("Category Dummy").withNameProduct("Product Dummy").withStockProduct(120 + index)
				.withUnitPrice(12.80 * index).build();
		return productDto;
	}

	protected List<Category> getDummyCategoryList(Integer amount) {
		List<Category> categoriesDummy = new ArrayList<Category>();

		for (int i = 0; i < amount; i++) {
			categoriesDummy.add(getDummyCategory(i));
		}
		return categoriesDummy;
	}

	protected Category getDummyCategory(Integer i) {
		CategoryBuilder categoryBuilder = CategoryBuilder.getInstance();
		return categoryBuilder.withId(i + 1L).withName("Category ".concat(Integer.toString(i + 1))).build();
	}

	protected List<CategoryDto> getDummyCategoryDtoList(Integer amount) {
		List<CategoryDto> categoriesDtoDummy = new ArrayList<CategoryDto>();
		CategoryDtoBuilder categoryDtoBuilder = CategoryDtoBuilder.getInstance();
		for (int i = 0; i < amount; i++) {
			categoriesDtoDummy.add(
					categoryDtoBuilder.withId(i + 1L).withName("Category ".concat(Integer.toString(i + 1))).build());
		}
		return categoriesDtoDummy;
	}

	protected CategoryRepository getCategoryRepositoryMock() {
		CategoryRepository categoryRepositoryMock = (CategoryRepository) EasyMock.createMock(CategoryRepository.class);
		EasyMock.reset(categoryRepositoryMock);
		return categoryRepositoryMock;
	}

	protected ProductService getProductServiceMock() {
		ProductService productServiceMock = (ProductService) EasyMock.createMock(ProductService.class);
		EasyMock.reset(productServiceMock);
		return productServiceMock;
	}

	protected CategoryService getCategoryServiceMock() {
		CategoryService categoryServiceMock = (CategoryService) EasyMock.createMock(CategoryService.class);
		EasyMock.reset(categoryServiceMock);
		return categoryServiceMock;
	}

	protected List<ProductDto> getDummyProductDtoList(Integer amount) {
		List<ProductDto> productsDtoDummy = new ArrayList<ProductDto>();
		for (int i = 0; i < amount; i++) {
			productsDtoDummy.add(getDummyProductDto(i));
		}
		return productsDtoDummy;
	}

}
