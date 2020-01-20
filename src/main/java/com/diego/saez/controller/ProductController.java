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

import com.diego.saez.model.Product;
import com.diego.saez.service.impl.ProductService;

@RestController
@RequestMapping(value = "/products", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@RequestMapping(path="/",method= RequestMethod.GET)
	public ResponseEntity<List<Product>> findAll() {
		
		List<Product> products = productService.findAll();
		
		return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
	}
	
	@RequestMapping(path="/{id}",method= RequestMethod.GET)
	public ResponseEntity<List<Product>> findById(@PathVariable long id) {
		
		List<Product> products = productService.findAll();
		
		return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
	}
	
}
