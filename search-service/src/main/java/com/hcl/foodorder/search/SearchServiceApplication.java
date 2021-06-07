package com.hcl.foodorder.search;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.hcl.foodorder.search.model.MenuItem;
import com.hcl.foodorder.search.repository.MenuItemRepository;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Search Service API", version = "2.0", description = "Search Service Information"))
public class SearchServiceApplication {
	
	/*
	 * @Autowired
	private MenuItemRepository menuItemRepository;

	
	 * @PostConstruct public void preparaDatabase() throws Exception {
	 * 
	 * menuItemRepository.save(new MenuItem(12L, 5L, "Pizza", "Italian Food",
	 * 340.40, 5, true)); menuItemRepository.save(new MenuItem(234L, 4L,
	 * "Biryani Rice", "South Indian Food", 560.40, 3, true));
	 * menuItemRepository.save(new MenuItem(456L, 5L, "White Sauce Pasta",
	 * "Italian Food", 240.40, 2, true)); menuItemRepository.save(new MenuItem(789L,
	 * 2L, "SandWitches", "Indian Food", 190.40, 10, true));
	 * menuItemRepository.save(new MenuItem(678L, 1L, "Manchurian", "Chinese Food",
	 * 140.40, 5, true)); menuItemRepository.save(new MenuItem(235L, 590L,
	 * "Hot Chocolate Brownie", "Desert Food", 350.40, 3, true));
	 * 
	 * }
	 */
	public static void main(String[] args) {
		SpringApplication.run(SearchServiceApplication.class, args);
	}

}
