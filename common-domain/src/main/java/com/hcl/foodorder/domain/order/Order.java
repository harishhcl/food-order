package com.hcl.foodorder.domain.order;

import java.time.LocalDateTime;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.hcl.foodorder.domain.restaurant.MenuItem;

import lombok.Data;

@Data
@Document
public class Order {
	@Id
	private Long id;
	private String orderNumber;
	private LocalDateTime createdDate;
	private LocalDateTime lastUpdatedDate;
	private Set<MenuItem> itemList;
	private OrderStatus status;
	private Double total;
	private Double taxPercentage;
	private Double totalTaxAmount;
	private Long restaurantId;
	private Long customerId;
	private Long driverId;

}
