package com.diego.saez.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diego.saez.dto.CategoryDto;
import com.diego.saez.dto.mapper.IMapper;
import com.diego.saez.dto.mapper.MapperFactory;
import com.diego.saez.dto.mapper.TypeMapper;
import com.diego.saez.model.Category;
import com.diego.saez.repository.CategoryRepository;
import com.diego.saez.service.ICategoryService;

@Service
public class CategoryService implements ICategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	/** TODO agregar métodos crud **/

	public CategoryDto create(CategoryDto categoryDto) {

		@SuppressWarnings("unchecked")
		IMapper<Category, CategoryDto> categoryMapper = MapperFactory.getMapper(TypeMapper.CATEGORY);
		Category categoryEntity = categoryMapper.toEntity(categoryDto);
		Category categoryCreated = categoryRepository.save(categoryEntity);
		return categoryMapper.toDto(categoryCreated);
	}

}
