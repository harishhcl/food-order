/**
 * 
 */
package com.hcl.foodorder.customer.controller;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.hcl.foodorder.domain.exception.CustomerDetailsNotFoundException;
import com.hcl.foodorder.domain.exception.DuplicateDriverCreationException;
import com.hcl.foodorder.domain.exception.ErrorDetails;

/**
 * @author Harishkumar Reddy
 *
 */
@RestControllerAdvice
public class CustomerControllerAdvice {
	
	@ExceptionHandler(CustomerDetailsNotFoundException.class)
	public ResponseEntity<ErrorDetails> orderDetailsNotFoundException(CustomerDetailsNotFoundException exception) {
		ErrorDetails error = new ErrorDetails(new Date(), exception.getMessage(), HttpStatus.BAD_REQUEST.name());
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST) ;
	}
	
	@ExceptionHandler(DuplicateDriverCreationException.class)
	public ResponseEntity<ErrorDetails> orderDetailsNotFoundException(DuplicateDriverCreationException exception) {
		ErrorDetails error = new ErrorDetails(new Date(), exception.getMessage(), HttpStatus.BAD_REQUEST.name());
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST) ;
	}
	
}
