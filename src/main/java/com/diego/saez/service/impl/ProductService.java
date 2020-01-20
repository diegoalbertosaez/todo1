package com.diego.saez.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.diego.saez.model.Product;
import com.diego.saez.repository.ProductRepository;
import com.diego.saez.service.IProductService;

@Service
public class ProductService implements IProductService {

	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public List<Product> findAll() {
		List<Product> products = productRepository.findAll();
		return products;
	}
	
	@Override
	public Product create(Product product) {
		Assert.notNull("product", "El producto no puede ser nulo");
		Product newProduct = productRepository.save(product);
		return newProduct;
	}

	@Override
	public Product update(Product product) throws Exception{
		Assert.notNull("product", "El producto no puede ser nulo");
		Product productUpdated = null;
		Optional<Product> productToUpdateOptional = productRepository.findById(product.getId());
		productToUpdateOptional.orElseThrow(Exception::new);		
		productUpdated = productRepository.save(product);
		return productUpdated;
	}
}
