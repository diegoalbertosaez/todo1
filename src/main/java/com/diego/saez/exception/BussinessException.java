package com.diego.saez.exception;

public class BussinessException extends Exception {

	private static final long serialVersionUID = 4067444725426470567L;

	public BussinessException() {
	}
	
	public BussinessException(String message, Throwable cause) {
		super(message, cause);
	}
	
	
	public BussinessException(String message){
		super(message);
	}
}
