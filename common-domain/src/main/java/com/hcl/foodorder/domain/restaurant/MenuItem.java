package com.hcl.foodorder.domain.restaurant;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
/**
 * 
 * @author Harishkumar Reddy
 *
 */
@Data
@Document
public class MenuItem {
	@Id
	private Long id;
	private Long restaurantId;
	private String name;
	private String description;
	private Double price;
	private Integer quantity;
	private Boolean isAvailable;
}
