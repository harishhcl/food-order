package com.hcl.foodorder.order.controller;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.hcl.foodorder.domain.exception.DuplicateOrderCreationException;
import com.hcl.foodorder.domain.exception.ErrorDetails;
import com.hcl.foodorder.domain.exception.OrderDetailsNotFoundException;

@RestControllerAdvice
public class OrderControllerAdvice {
	@ExceptionHandler(OrderDetailsNotFoundException.class)
	public ResponseEntity<ErrorDetails> orderDetailsNotFoundException(OrderDetailsNotFoundException exception) {
		ErrorDetails error = new ErrorDetails(new Date(), exception.getMessage(), HttpStatus.EXPECTATION_FAILED.name());
		return new ResponseEntity<>(error, HttpStatus.EXPECTATION_FAILED) ;
		
	}
	@ExceptionHandler(DuplicateOrderCreationException.class)
	public ResponseEntity<ErrorDetails> duplicateOrderCreationException(DuplicateOrderCreationException exception) {
		ErrorDetails error = new ErrorDetails(new Date(), exception.getMessage(), HttpStatus.BAD_REQUEST.name());
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST) ;
		
	}
	
}
