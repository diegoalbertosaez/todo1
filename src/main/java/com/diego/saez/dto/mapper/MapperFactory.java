package com.diego.saez.dto.mapper;

public class MapperFactory<E,D> {

	private MapperFactory() {
		
	}
	
	@SuppressWarnings("rawtypes")
	public static IMapper getMapper(TypeMapper type) {
		IMapper<E,D> mapper = null;
		if (TypeMapper.CATEGORY.equals(type)) {
			mapper = new CategoryMapper();
		} else if (TypeMapper.PRODUCT.equals(type)) {
			mapper = new ProductMapper();
		} else {
			//throw Exception
		}
		return mapper;
	}
}
