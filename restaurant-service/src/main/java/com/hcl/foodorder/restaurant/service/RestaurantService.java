package com.hcl.foodorder.restaurant.service;

import org.springframework.stereotype.Service;

import com.hcl.foodorder.restaurant.repository.RestaurantRepository;
import com.netflix.discovery.converters.Auto;

@Service
public class RestaurantService {
	
	@Auto
	RestaurantRepository restaurantRepository;
	

}
