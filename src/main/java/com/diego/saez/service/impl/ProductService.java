package com.diego.saez.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.diego.saez.dto.ProductDto;
import com.diego.saez.dto.mapper.IMapper;
import com.diego.saez.exception.BussinessException;
import com.diego.saez.exception.MapperException;
import com.diego.saez.model.Product;
import com.diego.saez.repository.ProductRepository;
import com.diego.saez.service.IProductService;

@Service
public class ProductService implements IProductService {
	private static final Logger logger = LoggerFactory.getLogger(ProductService.class);

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private IMapper<Product, ProductDto> productMapper;

	@Override
	public List<ProductDto> findAll() throws BussinessException {
		logger.debug("Init findAll()");
		List<ProductDto> productsDto = new ArrayList<ProductDto>();
		try {
			List<Product> products = productRepository.findAll();
			productsDto = productMapper.toDto(products);
		} catch (MapperException | DataAccessException e) {
			logger.error("Error al listar todos los productos", e);
			throw new BussinessException("Error al listar todos los productos", e);
		}
		logger.debug("End findAll()");
		return productsDto;
	}

	@Override
	@Transactional
	public ProductDto create(ProductDto product) throws BussinessException {
		logger.debug("Init create(product)");

		Product productCreated = null;
		ProductDto productDtoCreated = null;
		try {
			Assert.notNull(product, "El producto no puede ser nulo.");
			Assert.notNull(product.getNameProduct(), "El producto debe tener nombre.");
			Assert.notNull(product.getIdCategory(), "El producto debe tener una categoría.");
			Assert.notNull(product.getUnitPrice(), "El precio unitario del producto no debe ser null.");
			Assert.notNull(product.getStockProduct(), "El stock del producto no debe ser null.");
			Assert.isTrue(product.getStockProduct() >= 0, "El stock del producto no puede ser negativo.");
			Assert.isTrue(product.getUnitPrice() >= 0, "El precio unitario no puede ser negativo.");
			Assert.hasLength(product.getNameProduct(), "El producto debe tener nombre.");
			Assert.isNull(product.getIdProduct(), "El producto no debe contener id.");
			productCreated = productRepository.save(productMapper.toEntity(product));
			productDtoCreated = productMapper.toDto(productCreated);
		} catch (MapperException | DataAccessException e) {
			logger.error("Se ha producido un error al crear un producto", e);
			throw new BussinessException("Se ha producido un error al crear un producto.", e);
		} catch (IllegalArgumentException e) {
			logger.error("Error en los argumentos al crear producto", e);
			throw new BussinessException(e.getMessage());
		}
		logger.debug("Init create(product)");
		return productDtoCreated;
	}

	@Override
	@Transactional
	public ProductDto update(ProductDto product) throws BussinessException {
		logger.debug("Init update(product)");
		Product productUpdated = null;
		ProductDto productDtoUpdated = null;
		try {
			Assert.notNull(product, "El producto no puede ser nulo.");
			Assert.notNull(product.getNameProduct(), "El producto debe tener nombre.");
			Assert.notNull(product.getStockProduct(), "El stock del producto no debe ser null.");
			Assert.notNull(product.getUnitPrice(), "El precio unitario del producto no debe ser null.");
			Assert.notNull(product.getIdCategory(), "El producto debe tener una categoría.");
			Assert.isTrue(product.getStockProduct() >= 0, "El stock del producto no puede ser negativo.");
			Assert.isTrue(product.getUnitPrice() >= 0, "El precio unitario no puede ser negativo.");
			Assert.hasLength(product.getNameProduct(), "El producto debe tener nombre.");
			Optional<Product> productToUpdateOptional = productRepository.findById(product.getIdProduct());
			productToUpdateOptional
					.orElseThrow(() -> new BussinessException("El producto que se desea actualizar no existe."));
			productUpdated = productRepository.save(productMapper.toEntity(product));
			productDtoUpdated = productMapper.toDto(productUpdated);
		} catch (MapperException | DataAccessException e) {
			logger.error("Se ha producido un error al actualizar un producto.", e);
			throw new BussinessException("Se ha producido un error al actualizar un producto.", e);
		} catch (IllegalArgumentException e) {
			logger.error("Error en los argumentos al actualizar producto", e);
			throw new BussinessException(e.getMessage());
		}
		logger.debug("End update(product)");
		return productDtoUpdated;
	}

	@Override
	public ProductDto findById(Long id) throws BussinessException {
		logger.debug("Init findById(id)");
		ProductDto productDto = null;
		try {
			Assert.notNull(id, "El id del producto no puede ser null");
			Product product = productRepository.getOne(id);
			productDto = productMapper.toDto(product);
		} catch (MapperException | DataAccessException e) {
			logger.error("Se ha producido un error al buscar un producto.", e);
			throw new BussinessException("Se ha producido un error al buscar un producto.", e);
		} catch (IllegalArgumentException e) {
			logger.error("Error en los argumentos al buscar un producto", e);
			throw new BussinessException(e.getMessage());
		}
		logger.debug("End findById(id)");
		return productDto;
	}

	@Override
	@Transactional
	public void delete(Long id) throws BussinessException {
		logger.debug("Init delete(id)");
		try {
			Assert.notNull(id, "El id del producto no puede ser null");
			Optional<Product> productToUpdateOptional = productRepository.findById(id);
			productToUpdateOptional
					.orElseThrow(() -> new BussinessException("El producto que se desea elimina no se encuentra."));
			productRepository.deleteById(id);
		} catch (DataAccessException e) {
			logger.error("Se ha producido un error al eliminar un producto");
			throw new BussinessException("Se ha producido un error al eliminar un producto.", e);
		} catch (IllegalArgumentException e) {
			logger.error("Error en los argumentos al buscar un producto", e);
			throw new BussinessException(e.getMessage());
		}
		logger.debug("End delete(id)");
	}
}
