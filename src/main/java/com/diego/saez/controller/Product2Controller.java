package com.diego.saez.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.diego.saez.dto.ProductDto;
import com.diego.saez.exception.BussinessException;
import com.diego.saez.service.impl.ProductService;

//@RestController
//@RequestMapping(value = "/products", produces = MediaType.APPLICATION_JSON_VALUE)
public class Product2Controller {

	@Autowired
	private ProductService productService;
	
	@RequestMapping(path="/",method= RequestMethod.GET)
	public ResponseEntity<List<ProductDto>> findAll() {
		
		List<ProductDto> products = null;
		try {
			products = productService.findAll();
		} catch (BussinessException e) {
			e.printStackTrace();
		}
		
		return new ResponseEntity<List<ProductDto>>(products, HttpStatus.OK);
	}
	
	@RequestMapping(path="/{id}",method= RequestMethod.GET)
	public ResponseEntity<List<ProductDto>> findById(@PathVariable long id) {
		
		List<ProductDto> products = null;
		try {
			products = productService.findAll();
		} catch (BussinessException e) {
			
			e.printStackTrace();
		}
		
		return new ResponseEntity<List<ProductDto>>(products, HttpStatus.OK);
	}
	
}
