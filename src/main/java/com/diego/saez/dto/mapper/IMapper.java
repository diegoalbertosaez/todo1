package com.diego.saez.dto.mapper;

import java.util.List;

import com.diego.saez.exception.MapperException;

public interface IMapper<E,D> {

	E toEntity(D dto) throws MapperException;
	D toDto(E entity) throws MapperException;
	List<D> toDto(List<E> entities) throws MapperException;
}
