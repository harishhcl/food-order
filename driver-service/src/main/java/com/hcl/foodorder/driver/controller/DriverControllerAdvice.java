package com.hcl.foodorder.driver.controller;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.hcl.foodorder.domain.exception.DriverDetailsNotFoundException;
import com.hcl.foodorder.domain.exception.DuplicateDriverCreationException;
import com.hcl.foodorder.domain.exception.ErrorDetails;

@RestControllerAdvice
public class DriverControllerAdvice {
	@ExceptionHandler(DuplicateDriverCreationException.class)
	public ResponseEntity<ErrorDetails> orderDetailsNotFoundException(DuplicateDriverCreationException exception) {
		ErrorDetails error = new ErrorDetails(new Date(), exception.getMessage(), HttpStatus.BAD_REQUEST.name());
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST) ;
	}
	
	@ExceptionHandler(DriverDetailsNotFoundException.class)
	public ResponseEntity<ErrorDetails> orderDetailsNotFoundException(DriverDetailsNotFoundException exception) {
		ErrorDetails error = new ErrorDetails(new Date(), exception.getMessage(), HttpStatus.BAD_REQUEST.name());
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST) ;
	}
	
}
