package com.hcl.foodorder.domain.restaurant;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

import com.hcl.foodorder.domain.common.Address;

import lombok.Data;

@Data
@Document
public class Restaurant {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String description;
	private Address address;
}
