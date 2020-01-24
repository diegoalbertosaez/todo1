package com.diego.saez.dto;

import java.io.Serializable;

/**
 * Data Transfer Object for product.
 * 
 * @author diegosaez
 *
 */
public class ProductDto implements Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 * Id of product.
	 */
	private Long idProduct;

	/**
	 * Name of product.
	 */
	private String nameProduct;

	/**
	 * Stock of product.
	 */
	private Integer stockProduct;

	/**
	 * Id of category.
	 */
	private Long idCategory;

	/**
	 * Name of category.
	 */
	private String nameCategory;

	/**
	 * UnitPrice of product.
	 */
	private Double unitPrice;

	/**
	 * Return attribute idProduct.
	 * 
	 * @return idProduct
	 */
	public Long getIdProduct() {
		return idProduct;
	}

	/**
	 * Set value for attribute idProduct.
	 * 
	 * @param idProduct
	 */
	public void setIdProduct(Long idProduct) {
		this.idProduct = idProduct;
	}

	/**
	 * Return attribute nameProduct.
	 * 
	 * @return nameProduct
	 */
	public String getNameProduct() {
		return nameProduct;
	}

	/**
	 * Set value for attribute nameProduct.
	 * 
	 * @param nameProduct
	 */
	public void setNameProduct(String nameProduct) {
		this.nameProduct = nameProduct;
	}

	/**
	 * Return attribute stockProduct.
	 * 
	 * @return
	 */
	public Integer getStockProduct() {
		return stockProduct;
	}

	/**
	 * Set value for attribute stockProduct.
	 * 
	 * @param stockProduct
	 */
	public void setStockProduct(Integer stockProduct) {
		this.stockProduct = stockProduct;
	}

	/**
	 * Return attribute idCategory.
	 * 
	 * @return
	 */
	public Long getIdCategory() {
		return idCategory;
	}

	/**
	 * Set value for attribute idCategory.
	 * 
	 * @param idCategory
	 */
	public void setIdCategory(Long idCategory) {
		this.idCategory = idCategory;
	}

	/**
	 * Return attribute nameCategory.
	 * 
	 * @return nameCategory
	 */
	public String getNameCategory() {
		return nameCategory;
	}

	/**
	 * Set value for attribute nameCategory.
	 * 
	 * @param nameCategory
	 */
	public void setNameCategory(String nameCategory) {
		this.nameCategory = nameCategory;
	}

	/**
	 * Return attribute.
	 * 
	 * @return unitPrice
	 */
	public Double getUnitPrice() {
		return unitPrice;
	}

	/**
	 * Set value for attribute unitPrice.
	 * 
	 * @param unitPrice
	 */
	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}

}
