package com.hcl.foodorder.domain.exception;

/**
 * 
 * @author Harishkumar Reddy
 *
 */
public class OrderDetailsNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	public OrderDetailsNotFoundException() {
		super();
	}

	public OrderDetailsNotFoundException(String message) {
		super(message);
	}
}
