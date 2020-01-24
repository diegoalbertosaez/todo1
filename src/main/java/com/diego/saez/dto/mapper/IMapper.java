package com.diego.saez.dto.mapper;

import java.util.List;

import com.diego.saez.exception.MapperException;

/**
 * Interface that defines the behavior for mapper.
 * 
 * @author diegosaez
 *
 * @param <E>
 * @param <D>
 */
public interface IMapper<E, D> {

	/**
	 * Convert dto object of type D(Dto) to entity object of type E(Entity).
	 * 
	 * @param dto
	 * @return E - entity object
	 * @throws MapperException - if object to convert is invalid
	 */
	E toEntity(D dto) throws MapperException;

	/**
	 * Convert entity object of type E(Entity) to dto object of type E(Dto).
	 * 
	 * @param entity
	 * @return D - dto object
	 * @throws MapperException- if object to convert is invalid.
	 */
	D toDto(E entity) throws MapperException;

	/**
	 * Convert a list of type E(entity) to list of type D(Dto).
	 * 
	 * @param entities
	 * @return {@link List}
	 * @throws MapperException - if object to convert is invalid.
	 */
	List<D> toDto(List<E> entities) throws MapperException;
}
