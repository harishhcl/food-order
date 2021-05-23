package com.hcl.foodorder.restaurant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.foodorder.domain.exception.RestaurantDetailsNotFoundException;
import com.hcl.foodorder.domain.restaurant.Restaurant;
import com.hcl.foodorder.restaurant.service.RestaurantService;

@RestController
@RequestMapping("/restaurants/v1")
public class RestaurantController {
	
	@Autowired
	private RestaurantService restaurantService;
	
	@PostMapping("/create")
	public ResponseEntity<Restaurant> create(@RequestBody Restaurant restaurant) {
		Restaurant restaurantDetails = restaurantService.createRestaurant(restaurant);
		return new ResponseEntity<>(restaurantDetails,HttpStatus.CREATED);
	}
	
	@GetMapping("/get/{restaurantId}")
	public ResponseEntity<Restaurant> get(@PathVariable("restaurantId") Long restaurantId) throws RestaurantDetailsNotFoundException {
		Restaurant restaurantDetails = restaurantService.getRestaurant(restaurantId);
		return new ResponseEntity<>(restaurantDetails,HttpStatus.OK);
	}

}
