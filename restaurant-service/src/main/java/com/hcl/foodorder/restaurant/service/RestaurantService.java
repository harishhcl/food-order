package com.hcl.foodorder.restaurant.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.foodorder.domain.exception.RestaurantDetailsNotFoundException;
import com.hcl.foodorder.domain.restaurant.Restaurant;
import com.hcl.foodorder.restaurant.repository.RestaurantRepository;

@Service
public class RestaurantService {
	
	@Autowired
	private RestaurantRepository restaurantRepository;
	
	public Restaurant createRestaurant(Restaurant restaurant){
		return restaurantRepository.save(restaurant);
	}
	
	public Restaurant getRestaurant(Long restaurantId) throws RestaurantDetailsNotFoundException{
		
		Optional<Restaurant> restaurantDetails = restaurantRepository.findById(restaurantId);
		if(restaurantDetails.isPresent())
			return restaurantDetails.get();
		else
			throw new RestaurantDetailsNotFoundException();
	}
	
}
