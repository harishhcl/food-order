package com.hcl.foodorder.domain.restaurant;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data

public class MenuItem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long restaurantId;
	private String name;
	private String description;
	private Double price;

}
