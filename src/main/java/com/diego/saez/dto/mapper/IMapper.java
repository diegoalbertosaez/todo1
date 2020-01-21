package com.diego.saez.dto.mapper;

public interface IMapper<E,D> {

	E toEntity(D dto);
	D toDto(E entity);
}
