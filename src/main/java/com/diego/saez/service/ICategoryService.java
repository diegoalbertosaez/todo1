package com.diego.saez.service;

import java.util.List;

import com.diego.saez.dto.CategoryDto;
import com.diego.saez.exception.BussinessException;

public interface ICategoryService {

	List<CategoryDto> findAll() throws BussinessException;

}
