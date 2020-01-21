package com.diego.saez.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.diego.saez.dto.ProductDto;
import com.diego.saez.dto.mapper.IMapper;
import com.diego.saez.exception.BussinessException;
import com.diego.saez.exception.MapperException;
import com.diego.saez.model.Product;
import com.diego.saez.repository.ProductRepository;
import com.diego.saez.service.IProductService;

@Service
public class ProductService implements IProductService {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private IMapper<Product, ProductDto> productMapper;

	@Override
	public List<ProductDto> findAll() throws BussinessException {
		List<Product> products = productRepository.findAll();
		List<ProductDto> productsDto = new ArrayList<ProductDto>();
		try {
			productsDto = productMapper.toDto(products);
		} catch (MapperException | DataAccessException e) {
			throw new BussinessException();
		}
		return productsDto;
	}

	@Override
	public ProductDto create(ProductDto product) throws BussinessException {
		Product productCreated = null;
		ProductDto productDtoCreated = null;
		try {			
			Assert.notNull(product, "El producto no puede ser nulo");
			Assert.isNull(product.getIdProduct(), "El producto no debe contener id");
			Assert.isTrue(product.getStockProduct() >= 0, "El stock del producto no puede ser negativo");
			Assert.notNull(product.getNameProduct(), "El producto debe tener nombre");
			Assert.hasLength(product.getNameProduct(), "El producto debe tener nombre");
			Assert.notNull(product.getIdCategory(), "El producto debe tener una categoría");
			productCreated = productRepository.save(productMapper.toEntity(product));
			productDtoCreated = productMapper.toDto(productCreated);
		} catch (MapperException |DataAccessException e) {
			throw new BussinessException("Se ha producido un error al crear un producto.",e);
		} catch(IllegalArgumentException e){
			throw new BussinessException(e.getMessage());
		}
		return productDtoCreated;
	}

	@Override
	public ProductDto update(ProductDto product) throws BussinessException {
		Product productUpdated = null;
		ProductDto productDtoUpdated = null;
		try {
			Assert.notNull(product, "El producto no puede ser nulo");
			Assert.notNull(product.getNameProduct(), "El producto debe tener nombre");
			Assert.hasLength(product.getNameProduct(), "El producto debe tener nombre");
			Optional<Product> productToUpdateOptional = productRepository.findById(product.getIdProduct());
			productToUpdateOptional.orElseThrow(() -> new BussinessException("El producto que se desea actualizar no se encuentra"));
			productUpdated = productRepository.save(productMapper.toEntity(product));
			productDtoUpdated = productMapper.toDto(productUpdated);
		} catch (MapperException |DataAccessException e) {
			throw new BussinessException("Se ha producido un error al actualizar un producto.",e);
		} catch (IllegalArgumentException e){
			throw new BussinessException(e.getMessage());
		}
		return productDtoUpdated;
	}
}
