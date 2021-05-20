package com.hcl.foodorder.order.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.hcl.foodorder.order.exception.OrderDetailsNotFoundException;

@RestControllerAdvice
public class OrderControllerAdvice {
	@ExceptionHandler(OrderDetailsNotFoundException.class)
	public ResponseEntity<String> orderDetailsNotFoundException(OrderDetailsNotFoundException exception) {
		return new ResponseEntity<String>(exception.toString(), HttpStatus.EXPECTATION_FAILED) ;
		
	}
}
