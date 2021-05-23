package com.hcl.foodorder.restaurant.service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.foodorder.domain.exception.RestaurantDetailsNotFoundException;
import com.hcl.foodorder.domain.restaurant.MenuItem;
import com.hcl.foodorder.domain.restaurant.Restaurant;
import com.hcl.foodorder.restaurant.repository.MenuRepository;

@Service
public class MenuService {

	@Autowired
	private RestaurantService restaurantService;

	@Autowired
	private MenuRepository menuRepository;

	public List<MenuItem> createMenu(List<MenuItem> menuItems, Long restaurantId) {
		try {
			Restaurant restaurantDetails = restaurantService.getRestaurant(restaurantId);
			if (restaurantDetails != null) {
				List<MenuItem> data = menuItems.stream().map(item -> {
					item.setRestaurantId(restaurantId);
					return item;
				}).collect(Collectors.toList());

				return menuRepository.saveAll(data);
			}
		} catch (RestaurantDetailsNotFoundException e) {
			e.printStackTrace();
		}
		return Collections.emptyList();

	}
	
	public List<MenuItem> getMenu(Long restaurantId) {
		try {
			Restaurant restaurantDetails = restaurantService.getRestaurant(restaurantId);
			if (restaurantDetails != null) {
				return menuRepository.findByRestaurantId(restaurantId);
			}
		} catch (RestaurantDetailsNotFoundException e) {
			e.printStackTrace();
		}
		return Collections.emptyList();

	} 
}
