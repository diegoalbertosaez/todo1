package com.diego.saez.service;

import java.util.List;

import com.diego.saez.model.Product;

public interface IProductService {

	List<Product> findAll();

	Product create(Product product);

	Product update(Product product) throws Exception;
	
}
