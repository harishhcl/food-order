package com.hcl.foodorder.order.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.hcl.foodorder.domain.exception.DuplicateOrderCreationException;
import com.hcl.foodorder.domain.exception.OrderDetailsNotFoundException;
import com.hcl.foodorder.domain.order.Order;
import com.hcl.foodorder.order.repository.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;

	public Order create(Order order) throws DuplicateOrderCreationException {
		List<Order> existingOrder = orderRepository.findByOrderNumber(order.getOrderNumber());
		if(!CollectionUtils.isEmpty(existingOrder))
			throw new DuplicateOrderCreationException("Duplicate Order Details Found For orderNumber=" + order.getOrderNumber());
		
		order.setCreatedDate(new Date());
		order.setLastUpdatedDate(new Date());
		return orderRepository.save(order);
	}

	public List<Order> getOrdersByRestaurant(Long restaurantId) throws OrderDetailsNotFoundException {
		List<Order> orderDetails = orderRepository.findByRestaurantId(restaurantId);
		if(CollectionUtils.isEmpty(orderDetails))
			throw new OrderDetailsNotFoundException("Order Details Not Available For restaurantId " + restaurantId);
		
		return orderDetails;
	}

	public List<Order> getOrdersByCustomer(Long customerId) throws OrderDetailsNotFoundException {
		List<Order> orderDetails = orderRepository.findByCustomerId(customerId);
		if(CollectionUtils.isEmpty(orderDetails))
			throw new OrderDetailsNotFoundException("Order Details Not Available For customerId " + customerId);
		
		return orderDetails;
	}

	public List<Order> getOrdersByOrderNumber(Long orderNumber) throws OrderDetailsNotFoundException {
		List<Order> orderDetails = orderRepository.findByOrderNumber(orderNumber);
		if(CollectionUtils.isEmpty(orderDetails))
			throw new OrderDetailsNotFoundException("Order Details Not Available For orderNumber " + orderNumber);
		
		return orderDetails;
	}

}
