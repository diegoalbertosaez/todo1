package com.diego.saez.service;

import java.util.List;

import com.diego.saez.dto.ProductDto;
import com.diego.saez.exception.BussinessException;

/**
 * Service proxy interface for product
 * 
 * @author diegosaez
 *
 */
public interface IProductService {

	/**
	 * Returns a list of all products
	 * 
	 * @return {@link List}
	 * @throws BussinessException - if there is an unexpected error
	 */
	List<ProductDto> findAll() throws BussinessException;

	/**
	 * Create a product
	 * 
	 * @param product
	 * @return {@link ProductDto}
	 * @throws BussinessException - if product is invalid
	 */
	ProductDto create(ProductDto product) throws BussinessException;

	/**
	 * Update a product
	 * 
	 * @param product
	 * @return {@link ProductDto}
	 * @throws BussinessException - if product is invalid
	 */
	ProductDto update(ProductDto product) throws BussinessException;

	/**
	 * Delete a product
	 * 
	 * @param id id of product
	 * @throws BussinessException - if the id is invalid or the product does not
	 *                            exist
	 */
	void delete(Long id) throws BussinessException;

	/**
	 * Search for a product by its id
	 * 
	 * @param id - id of product
	 * @return {@link ProductDto}
	 * @throws BussinessException
	 */
	ProductDto findById(Long id) throws BussinessException;

}
