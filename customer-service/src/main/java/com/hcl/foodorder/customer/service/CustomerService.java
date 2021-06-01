/**
 * 
 */
package com.hcl.foodorder.customer.service;

import java.util.Objects;

import org.springframework.stereotype.Service;

import com.hcl.foodorder.customer.repository.CustomerRepository;
import com.hcl.foodorder.domain.customer.Customer;
import com.hcl.foodorder.domain.exception.CustomerDetailsNotFoundException;
import com.hcl.foodorder.domain.exception.DuplicateCustomerCreationException;

/**
 * @author Harishkumar Reddy
 *
 */
@Service
public class CustomerService {
	private CustomerRepository customerRepository;

	/**
	 * @param customer
	 * @return
	 * @throws DuplicateCustomerCreationException
	 */
	public Customer create(Customer customer) throws DuplicateCustomerCreationException {
		Customer result = customerRepository.findByMobileNumber(customer.getMobileNumber());
		if (Objects.nonNull(result)) {
			throw new DuplicateCustomerCreationException("Duplicate Customer Mobile Number");
		}
		return customerRepository.save(customer);
	}

	/**
	 * @param customerId
	 * @return
	 * @throws CustomerDetailsNotFoundException
	 */
	public Customer getCustomerDetails(String customerId) throws CustomerDetailsNotFoundException {
		Customer result = customerRepository.findByMobileNumber(customerId);
		if (result == null) {
			throw new CustomerDetailsNotFoundException("Customer Details Not Fund");
		}
		return result;
	}

}
