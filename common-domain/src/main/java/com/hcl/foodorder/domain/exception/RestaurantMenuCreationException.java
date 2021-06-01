package com.hcl.foodorder.domain.exception;

/**
 * 
 * @author Harishkumar Reddy
 *
 */
public class RestaurantMenuCreationException extends Exception {

	private static final long serialVersionUID = 1L;

	public RestaurantMenuCreationException() {
		super();
	}

	public RestaurantMenuCreationException(String message) {
		super(message);
	}
}