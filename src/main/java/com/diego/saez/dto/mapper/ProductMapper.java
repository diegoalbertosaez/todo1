package com.diego.saez.dto.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.diego.saez.dto.ProductDto;
import com.diego.saez.dto.builder.ProductDtoBuilder;
import com.diego.saez.exception.MapperException;
import com.diego.saez.model.Category;
import com.diego.saez.model.Product;
import com.diego.saez.model.builder.CategoryBuilder;
import com.diego.saez.model.builder.ProductBuilder;

import static com.diego.saez.functional.LambdaExceptionWrappers.throwingConsumerWrapper;

@Component
public class ProductMapper implements IMapper<Product, ProductDto> {
	private static final Logger logger = LoggerFactory.getLogger(ProductMapper.class);

	@Override
	public Product toEntity(ProductDto producDto) throws MapperException {
		logger.debug("Init toEntity(producDto)");
		Optional<ProductDto> productDtoOptional = Optional.ofNullable(producDto);
		productDtoOptional
				.orElseThrow(() -> new MapperException("Error al mapear productDto a entity:  dto no pude ser null"));
		ProductDto productDtoToConvert = productDtoOptional.get();
		CategoryBuilder categoryBuilder = CategoryBuilder.getInstance();
		Category category = categoryBuilder.withId(productDtoToConvert.getIdCategory())
				.withName(productDtoToConvert.getNameCategory()).build();
		ProductBuilder productBuilder = ProductBuilder.getInstance();
		Product productToReturn = productBuilder.withId(productDtoToConvert.getIdProduct())
				.withName(productDtoToConvert.getNameProduct()).withStock(productDtoToConvert.getStockProduct())
				.withUnitPrice(productDtoToConvert.getUnitPrice()).withCategory(category).build();
		logger.debug("End toEntity(producDto)");
		return productToReturn;
	}

	@Override
	public ProductDto toDto(Product productEntity) throws MapperException {
		logger.debug("Init toDto(productEntity)");

		Optional<Product> productOptional = Optional.ofNullable(productEntity);
		productOptional
				.orElseThrow(() -> new MapperException("Error al mapear productEntity a dto: entity no pude ser null"));
		Product productToConvert = productOptional.get();
		Optional<Category> categoryOptional = Optional.ofNullable(productEntity.getCategory());
		categoryOptional.orElseThrow(
				() -> new MapperException("Error al mapear productEntity a dto: La cateogoría no puede ser null"));
		Category category = categoryOptional.get();
		ProductDtoBuilder productDtoBuilder = ProductDtoBuilder.getInstance();
		ProductDto productDtoToReturn = productDtoBuilder.withIdProduct(productToConvert.getId())
				.withIdCategory(category.getId()).withNameProduct(productToConvert.getName())
				.withNameCategory(category.getName()).withStockProduct(productToConvert.getStock())
				.withUnitPrice(productToConvert.getUnitPrice()).build();
		logger.debug("End toDto(productEntity)");

		return productDtoToReturn;
	}

	@Override
	public List<ProductDto> toDto(List<Product> products) throws MapperException {
		logger.debug("Init toDto(products)");

		Optional<List<Product>> productsOptional = Optional.ofNullable(products);
		productsOptional.orElseThrow(() -> new MapperException(
				"Error al mapear una lista de productEntity a una lista de dto:  La lista a convertir no puede ser null"));
		List<Product> productsToConvert = productsOptional.get();
		List<ProductDto> productsDtoToReturn = new ArrayList<>();
		productsToConvert.stream().forEach(throwingConsumerWrapper(p -> productsDtoToReturn.add(this.toDto(p))));
		logger.debug("End toDto(products)");

		return productsDtoToReturn;
	}

}
