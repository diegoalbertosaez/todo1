package com.diego.saez.dto;

import java.io.Serializable;

/**
 * Data Transfer Object for category
 * 
 * @author diegosaez
 *
 */
public class CategoryDto implements Serializable {

	private static final long serialVersionUID = -3346745419802208802L;
	/**
	 * Id of category
	 */
	private Long id;

	/**
	 * Name of category
	 */
	private String name;

	/**
	 * Return attribute id
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
	 * Return attribute name
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
}
