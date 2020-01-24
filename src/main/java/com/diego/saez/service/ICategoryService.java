package com.diego.saez.service;

import java.util.List;

import com.diego.saez.dto.CategoryDto;
import com.diego.saez.exception.BussinessException;

/**
 * Service proxy interface for category.
 * 
 * @author diegosaez
 *
 */
public interface ICategoryService {

	/**
	 * Returns a list of all categories.
	 * 
	 * @return {@link List}
	 * @throws BussinessException
	 */
	List<CategoryDto> findAll() throws BussinessException;

}
