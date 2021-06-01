package com.hcl.foodorder.domain.exception;

/**
 * 
 * @author Harishkumar Reddy
 *
 */
public class DuplicateOrderCreationException extends Exception {

	private static final long serialVersionUID = 1L;

	public DuplicateOrderCreationException() {
		super();
	}

	public DuplicateOrderCreationException(String message) {
		super(message);
	}

}
