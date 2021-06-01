package com.hcl.foodorder.restaurant.service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.foodorder.domain.exception.RestaurantDetailsNotFoundException;
import com.hcl.foodorder.domain.restaurant.MenuItem;
import com.hcl.foodorder.domain.restaurant.Restaurant;
import com.hcl.foodorder.restaurant.repository.MenuRepository;

/**
 * 
 * @author Harishkumar Reddy
 *
 */
@Service
public class MenuService {
	private static final Logger logger = LoggerFactory.getLogger(MenuService.class);
	@Autowired
	private RestaurantService restaurantService;

	@Autowired
	private MenuRepository menuRepository;

	/**
	 * Create the menu item details for the registered restaurant.
	 * 
	 * @param menuItems
	 * @param restaurantId
	 * @return
	 */
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

	/**
	 * Get the Menu Item Details based on RestaurantID
	 * 
	 * @param restaurantId
	 * @return
	 */
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
