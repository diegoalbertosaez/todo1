package com.diego.saez.service;

import java.util.List;

import com.diego.saez.dto.ProductDto;
import com.diego.saez.exception.BussinessException;

public interface IProductService {

	List<ProductDto> findAll() throws BussinessException;

	ProductDto create(ProductDto product) throws BussinessException;

	ProductDto update(ProductDto product) throws BussinessException;

	void delete(Long id) throws BussinessException;

	ProductDto findById(Long id) throws BussinessException;
	
}
