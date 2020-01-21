package com.diego.saez.dto.mapper;

import java.util.Optional;

import com.diego.saez.dto.ProductDto;
import com.diego.saez.dto.builder.CategoryBuilder;
import com.diego.saez.dto.builder.ProductBuilder;
import com.diego.saez.mode.builder.ProductDtoBuilder;
import com.diego.saez.model.Category;
import com.diego.saez.model.Product;

public class ProductMapper implements IMapper<Product, ProductDto> {

	@Override
	public Product toEntity(ProductDto producDto) {

		Optional<ProductDto> productDtoOptional = Optional.ofNullable(producDto);
		// productDtoOptional.orElseThrow(exceptionSupplier);
		ProductDto productDtoToConvert = productDtoOptional.get();
		CategoryBuilder categoryBuilder = CategoryBuilder.getInstance();
		Category category = categoryBuilder.withId(productDtoToConvert.getIdCategory())
				.withName(productDtoToConvert.getNameCategory()).build();
		ProductBuilder productBuilder = ProductBuilder.getInstance();
		Product productToReturn = productBuilder.withId(productDtoToConvert.getIdProduct())
				.withName(productDtoToConvert.getNameProduct()).withStock(productDtoToConvert.getStockProduct())
				.withUnitPrice(productDtoToConvert.getUnitPrice()).withCategory(category).build();
		return productToReturn;
	}

	@Override
	public ProductDto toDto(Product productEntity) {
		Optional<Product> productOptional = Optional.ofNullable(productEntity);
		// productOptional.orElseThrow(exceptionSupplier);
		Product productToConvert = productOptional.get();
		Optional<Category> categoryOptional = Optional.ofNullable(productEntity.getCategory());
		// categoryOptional.orElseThrow(exceptionSupplier);
		Category category = categoryOptional.get();
		ProductDtoBuilder productDtoBuilder = ProductDtoBuilder.getInstance();
		ProductDto productDtoToReturn = productDtoBuilder.withIdProduct(productToConvert.getId())
				.withIdCategory(category.getId()).withNameProduct(productToConvert.getName())
				.withNameCategory(category.getName()).withStockProduct(productToConvert.getStock())
				.withUnitPrice(productToConvert.getUnitPrice()).build();
		return productDtoToReturn;
	}

}
