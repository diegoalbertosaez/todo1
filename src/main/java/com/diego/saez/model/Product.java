package com.diego.saez.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Entity class for the product table in the database
 * 
 * @author diegosaez
 *
 */
@Entity
@Table(name = "PRODUCT")
public class Product {

	/**
	 * Id of product
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/**
	 * Name of product
	 */
	private String name;

	/**
	 * Stock of product
	 */
	private Integer stock;

	/**
	 * UnitPrice for product
	 */
	private Double unitPrice;

	/**
	 * Category of product
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CATEGORYID")
	private Category category;

	/**
	 * Return attribute for id
	 * 
	 * @return id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Set value for attribute id
	 * 
	 * @param id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Return attribute for name
	 * 
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set value for attribute name
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Return attribute for stock
	 * 
	 * @return stock
	 */
	public int getStock() {
		return stock;
	}

	/**
	 * Set value for attribute stock
	 * 
	 * @param stock
	 */
	public void setStock(Integer stock) {
		this.stock = stock;
	}

	/**
	 * Return attribute for unitPrice
	 * 
	 * @return unitPrice
	 */
	public Double getUnitPrice() {
		return unitPrice;
	}

	/**
	 * Set value for attribute unitPrice
	 * 
	 * @param unitPrice
	 */
	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}

	/**
	 * Return attribute for category
	 * 
	 * @return category
	 */
	public Category getCategory() {
		return category;
	}

	/**
	 * Set value for attribute category
	 * 
	 * @param category
	 */
	public void setCategory(Category category) {
		this.category = category;
	}

}
