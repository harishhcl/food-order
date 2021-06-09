package com.hcl.foodorder.restaurant.service;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.hcl.foodorder.domain.exception.RestaurantDetailsNotFoundException;
import com.hcl.foodorder.domain.restaurant.MenuItem;
import com.hcl.foodorder.domain.restaurant.Restaurant;
import com.hcl.foodorder.restaurant.repository.MenuRepository;
import com.hcl.foodorder.restaurant.streams.SendMenuItemDetails;

/**
 * @author Harishkumar Reddy
 *
 */
@SpringBootTest
class MenuServiceTest {

	@Mock
	private RestaurantService restaurantService;

	@Mock
	private MenuRepository menuRepository;

	@Mock
	private SendMenuItemDetails sendMenuItemDetails;

	@InjectMocks
	private MenuService menuService;

	@Test
	public void createMenuWithEmptyArgumentsTest() throws RestaurantDetailsNotFoundException {

		Restaurant restaurant = new Restaurant();
		
		when(restaurantService.getRestaurant(Mockito.anyLong())).thenReturn(null);
		List<MenuItem> response = menuService.createMenu(null, null);
		Assertions.assertEquals(0, response.size()); 
		
		verify(menuService).createMenu(null, null);
		Assertions.assertNotNull(response);

	}
}
