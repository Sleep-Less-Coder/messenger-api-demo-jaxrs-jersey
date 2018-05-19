package com.hemant.restapi.messenger.exception;

public class DataNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8512650532111770404L;

	public DataNotFoundException(String message) {
		super(message);
	}
}
