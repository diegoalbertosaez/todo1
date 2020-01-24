package com.diego.saez.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.diego.saez.dto.CategoryDto;
import com.diego.saez.dto.mapper.IMapper;
import com.diego.saez.exception.BussinessException;
import com.diego.saez.exception.MapperException;
import com.diego.saez.model.Category;
import com.diego.saez.repository.CategoryRepository;
import com.diego.saez.service.ICategoryService;

/**
 * Category service implementation for business layer.
 * 
 * @author diegosaez
 *
 */
@Service
public class CategoryService implements ICategoryService {

	private static final Logger logger = LoggerFactory.getLogger(CategoryService.class);

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private IMapper<Category, CategoryDto> categoryMapper;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.diego.saez.service.ICategoryService#findAll()
	 */
	@Override
	public List<CategoryDto> findAll() throws BussinessException {
		logger.debug("Init findAll()");
		List<CategoryDto> categoriesDto;
		try {
			logger.debug("Buscanco las categorías de producto");
			categoriesDto = categoryMapper.toDto(categoryRepository.findAll());
		} catch (MapperException | DataAccessException e) {
			logger.error("Error al listar las categorías de producto", e);
			throw new BussinessException("Se ha producido un error al listar todas las categorías de producto", e);
		}
		logger.debug("End findAll()");
		return categoriesDto;
	}

}
