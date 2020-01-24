package com.diego.saez.exception;

/**
 * Exception for the business layer.
 * 
 * @author diegosaez
 *
 */
public class BussinessException extends Exception {

	private static final long serialVersionUID = 4067444725426470567L;

	/**
	 * Default constructor.
	 */
	public BussinessException() {
	}

	/**
	 * Constructor with message and cause exception.
	 * 
	 * @param message
	 * @param cause
	 */
	public BussinessException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Constructor with message.
	 * 
	 * @param message
	 */
	public BussinessException(String message) {
		super(message);
	}
}
