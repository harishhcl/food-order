package com.hcl.foodorder.order.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.hcl.foodorder.domain.order.Order;
import com.hcl.foodorder.order.exception.OrderDetailsNotFoundException;
import com.hcl.foodorder.order.repository.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;

	public List<Order> get() throws OrderDetailsNotFoundException {

		List<Order> order = orderRepository.findAll();
		if (CollectionUtils.isEmpty(order)) {
			throw new OrderDetailsNotFoundException();
		}
		return order;

	}

	public Order get(Long orderNumber) throws OrderDetailsNotFoundException {

		Optional<Order> order = orderRepository.findById(orderNumber);
		if (order.isPresent()) {
			return order.get();
		}
		
		throw new OrderDetailsNotFoundException();

	}

	public Order create(Order order) {
		return orderRepository.save(order);
	}
}
