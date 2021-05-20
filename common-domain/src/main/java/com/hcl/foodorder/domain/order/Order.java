package com.hcl.foodorder.domain.order;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.hcl.foodorder.domain.restaurant.MenuItem;

import lombok.Data;

@Data
@Entity
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String orderNumber;
	private Set<MenuItem> itemList;
	
}
