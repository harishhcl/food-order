package com.hcl.foodorder.order.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.foodorder.domain.order.Order;
import com.hcl.foodorder.order.exception.OrderDetailsNotFoundException;
import com.hcl.foodorder.order.service.OrderService;
import com.netflix.discovery.converters.Auto;

@RestController
@RequestMapping("/orders/v1")
public class OrderController {
	
	@Auto
	private OrderService orderService;


	@GetMapping("/get")
	public ResponseEntity<List<Order>> get() throws OrderDetailsNotFoundException {
		
		return new ResponseEntity<>(orderService.get(), HttpStatus.OK);
	}
	
	@GetMapping("/get/{orderNumber}")
	public ResponseEntity<Order> get(@RequestParam("orderNumber") Long orderNumber) throws OrderDetailsNotFoundException {
		
		return new ResponseEntity<>(orderService.get(orderNumber), HttpStatus.OK);
	}
	
	@PostMapping("/create")
	public ResponseEntity<Order> create(@RequestBody Order order) {

		return new ResponseEntity<>(order, HttpStatus.CREATED);
	}
}
