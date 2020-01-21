package com.diego.saez.dto;

import java.io.Serializable;

public class CategoryDto implements Serializable{

	private static final long serialVersionUID = -3346745419802208802L;
	private long id;
	private String name;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
