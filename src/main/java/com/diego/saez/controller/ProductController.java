package com.diego.saez.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

/**
 * Controller for operations create, update and delete product.
 * 
 * @author diegosaez
 *
 */
@Controller
public class ProductController {
	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
	@Autowired
	private IProductService productService;

	@Autowired
	private ICategoryService categoryService;

	/**
	 * Returns a list of all products.
	 * 
	 * @param model
	 * @return {@link String} view
	 * @throws WebException
	 */
	@GetMapping(value = { "/products", "/" })
	public String findAll(Model model) throws WebException {
		logger.debug("Init findAll(model)");
		List<ProductDto> productsDto;
		try {
			productsDto = productService.findAll();
			model.addAttribute("products", productsDto);
		} catch (BussinessException e) {
			logger.error("Error al listar todos los productos", e);
			throw new WebException(e.getMessage());
		}
		logger.debug("End findAll(model)");
		return "products";
	}

	/**
	 * Returns the view with the model to create a product.
	 * 
	 * @param model
	 * @return {@link String} view
	 * @throws WebException
	 */
	@GetMapping("/products/new")
	public String newProduct(Model model) throws WebException {
		logger.debug("Init newProduct(model)");
		List<CategoryDto> categoriesDto = null;
		try {
			categoriesDto = categoryService.findAll();
			model.addAttribute("categories", categoriesDto);
		} catch (BussinessException e) {
			logger.error("Error al mostrar el formulario para crear producto", e);
			throw new WebException(e.getMessage());
		}
		logger.debug("End newProduct(model)");
		return "product_new";
	}

	/**
	 * Returns the view with the model to edit a product.
	 * 
	 * @param id    - product id to edit
	 * @param model
	 * @return {@link String} view
	 * @throws WebException
	 */
	@GetMapping("/products/edit/{id}")
	public String editProduct(@PathVariable Long id, Model model) throws WebException {
		logger.debug("Init editProduct(id,model)");
		try {
			List<CategoryDto> categoriesDto = new ArrayList<CategoryDto>();
			ProductDto productDto = productService.findById(id);
			categoriesDto = categoryService.findAll();
			model.addAttribute("categories", categoriesDto);
			model.addAttribute("product", productDto);
		} catch (BussinessException e) {
			logger.error("Error al mostrar el formulario para editar producto", e);
			throw new WebException(e.getMessage());
		}
		logger.debug("End editProduct(id,model)");
		return "product_edit";
	}

	/**
	 * Delete a product.
	 * 
	 * @param id - product id to delete
	 * @return {@link String} redirect to /products
	 * @throws WebException
	 */
	@PostMapping(value = "/products", params = "id")
	public String deleteProduct(@RequestParam Long id) throws WebException {
		logger.debug("Init deleteProduct(id)");
		try {
			productService.delete(id);
		} catch (BussinessException e) {
			logger.error("Error al eliminar un producto", e);
			throw new WebException(e.getMessage());
		}
		logger.debug("End deleteProduct(id)");
		return "redirect:/products";
	}

	/**
	 * Save a product. If the product has id it is updated in another case it is
	 * created.
	 * 
	 * @param productDto - product to save
	 * @return {@link String} redirect to /products
	 * @throws WebException
	 */
	@PostMapping("/products")
	public String saveProduct(@ModelAttribute ProductDto productDto) throws WebException {
		logger.debug("Init saveProduct(productDto)");
		try {
			if (productDto.getIdProduct() == null) {
				logger.debug("Creando producto");
				productService.create(productDto);
			} else {
				logger.debug("Actualizando producto");
				productService.update(productDto);
			}
		} catch (BussinessException e) {
			logger.error("Error al guardar producto", e);
			throw new WebException(e.getMessage());
		}
		logger.debug("End saveProduct(productDto)");
		return "redirect:/products";
	}

	/**
	 * Catch controller exceptions and redirect to error view with a message.
	 * 
	 * @param req - Servlet Request
	 * @param ex  - Exception to catch
	 * @return {@link ModelAndView} redirect to error view
	 */
	@ExceptionHandler(WebException.class)
	public ModelAndView handleError(HttpServletRequest req, Exception ex) {
		logger.debug("Init handleError");
		logger.error("Atrapando error ", ex);
		ModelAndView mav = new ModelAndView();
		mav.getModelMap().addAttribute("message", ex.getMessage());
		mav.setViewName("error");
		logger.debug("End handleError");
		return mav;
	}
}
