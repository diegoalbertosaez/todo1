package com.diego.saez.service.impl;

import java.util.List;

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

@Service
public class CategoryService implements ICategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private IMapper<Category, CategoryDto> categoryMapper;

	@Override
	public List<CategoryDto> findAll() throws BussinessException {
		List<CategoryDto> categoriesDto;
		try {
			categoriesDto = categoryMapper.toDto(categoryRepository.findAll());
		} catch (MapperException | DataAccessException e) {
			throw new BussinessException("Se ha producido un error al listar todas las categorías de producto", e);
		}
		return categoriesDto;
	}

}
