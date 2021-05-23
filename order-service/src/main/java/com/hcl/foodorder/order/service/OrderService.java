package com.hcl.foodorder.order.service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.foodorder.domain.order.Order;
import com.hcl.foodorder.order.repository.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;

	public Order create(Order order) {
		LocalDateTime dateTime = LocalDateTime.ofInstant(new Date().toInstant(), ZoneId.systemDefault());
		order.setCreatedDate(dateTime);
		order.setLastUpdatedDate(dateTime);
		return orderRepository.save(order);
	}

	public List<Order> getOrdersByRestaurant(Long restaurantId) {
		return orderRepository.findByRestaurantId(restaurantId);
	}

}
