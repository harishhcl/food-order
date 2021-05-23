package com.hcl.foodorder.order.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.foodorder.domain.order.Order;
import com.hcl.foodorder.order.service.OrderService;

@RestController
@RequestMapping("v1/orders")
public class OrderController {
	
	@Autowired
	private OrderService orderService;

	@PostMapping("/create")
	public ResponseEntity<Order> create(@RequestBody Order order) {
		Order orderDetails = orderService.create(order);
		return new ResponseEntity<>(orderDetails, HttpStatus.CREATED);
	}
	
	@GetMapping("/get/restaurants/{restaurantId}")
	public ResponseEntity<List<Order>> getRestaurantOrders(@PathVariable("restaurantId") Long restaurantId) {
		List<Order> orders = orderService.getOrdersByRestaurant(restaurantId);
		return new ResponseEntity<>(orders, HttpStatus.OK);
	}
	
	
	
}
