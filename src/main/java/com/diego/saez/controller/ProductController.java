package com.diego.saez.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.diego.saez.dto.CategoryDto;
import com.diego.saez.dto.ProductDto;
import com.diego.saez.exception.BussinessException;
import com.diego.saez.exception.WebException;
import com.diego.saez.service.ICategoryService;
import com.diego.saez.service.IProductService;

@Controller
public class ProductController {

	@Autowired
	private IProductService productService;

	@Autowired
	private ICategoryService categoryService;

	@GetMapping(value = { "/products", "/" })
	public String findAll(Model modelo) throws WebException {
		List<ProductDto> productsDto;
		try {
			productsDto = productService.findAll();
			modelo.addAttribute("products", productsDto);
		} catch (BussinessException e) {
			throw new WebException(e.getMessage());
		}
		return "products";
	}

	@GetMapping("/products/new")
	public String newProduct(Model modelo) throws WebException {
		List<CategoryDto> categoriesDto = null;
		try {
			categoriesDto = categoryService.findAll();
			modelo.addAttribute("categories", categoriesDto);
		} catch (BussinessException e) {
			throw new WebException(e.getMessage());
		}
		return "product_new";
	}

	@GetMapping("/products/edit/{id}")
	public String editProduct(@PathVariable Long id, Model modelo) throws WebException {
		try {
			List<CategoryDto> categoriesDto = new ArrayList<CategoryDto>();
			ProductDto productDto = productService.findById(id);
			categoriesDto = categoryService.findAll();
			modelo.addAttribute("categories", categoriesDto);
			modelo.addAttribute("product", productDto);
		} catch (BussinessException e) {
			throw new WebException(e.getMessage());
		}
		return "product_edit";
	}

	@DeleteMapping(value = "/products", params = "id")
	public String deleteProduct(@RequestParam Long id) throws WebException {
		try {
			productService.delete(id);
		} catch (BussinessException e) {
			throw new WebException(e.getMessage());
		}
		return "redirect:/products";
	}

	@PostMapping("/products")
	public String saveProduct(@ModelAttribute ProductDto productDto) throws WebException {
		try {
			if (productDto.getIdProduct() == null) {
				productService.create(productDto);
			} else {
				productService.update(productDto);
			}
		} catch (BussinessException e) {
			throw new WebException(e.getMessage());
		}
		return "redirect:/products";
	}

	@ExceptionHandler(WebException.class)
	public ModelAndView handleError(HttpServletRequest req, Exception ex) {
		ModelAndView mav = new ModelAndView();
		mav.getModelMap().addAttribute("message", ex.getMessage());
		mav.setViewName("error");
		return mav;
	}
}
