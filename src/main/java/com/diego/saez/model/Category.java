package com.diego.saez.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entity class for the category table in the database
 * 
 * @author diegosaez
 *
 */
@Entity
@Table(name = "CATEGORY")
public class Category {

	/**
	 * Id of category
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

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
	 * Return attribute
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
