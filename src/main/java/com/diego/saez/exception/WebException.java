package com.diego.saez.exception;

/**
 * Exception for the web layer.
 * 
 * @author diegosaez
 *
 */
public class WebException extends Exception {

	private static final long serialVersionUID = 4497218444336525673L;

	/**
	 * Defaults constructor.
	 */
	public WebException() {

	}

	/**
	 * Constructor with message.
	 * 
	 * @param message
	 */
	public WebException(String message) {
		super(message);
	}
}
