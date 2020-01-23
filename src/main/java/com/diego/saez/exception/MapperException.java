package com.diego.saez.exception;

/**
 * Exception for mappers
 * 
 * @author diegosaez
 *
 */
public class MapperException extends Exception {

	private static final long serialVersionUID = 2243801232702541992L;

	/**
	 * Default constructor
	 */
	public MapperException() {

	}

	/**
	 * Constructor with message
	 * 
	 * @param message
	 */
	public MapperException(String message) {
		super(message);
	}

}
