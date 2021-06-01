/**
 * 
 */
package com.hcl.foodorder.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.foodorder.customer.service.CustomerService;
import com.hcl.foodorder.domain.customer.Customer;
import com.hcl.foodorder.domain.exception.CustomerDetailsNotFoundException;
import com.hcl.foodorder.domain.exception.DuplicateCustomerCreationException;

/**
 * @author Harishkumar Reddy
 *
 */
@RestController
@RequestMapping("/customers/v1/")
public class CustomerController {
	@Autowired
	private CustomerService customerService;

	@PostMapping("/create")
	public ResponseEntity<Customer> create(@RequestBody Customer customer) throws DuplicateCustomerCreationException {
		return new ResponseEntity<>(customerService.create(customer), HttpStatus.CREATED);
	}

	@GetMapping("/get/{customerId}")
	public ResponseEntity<Customer> create(@PathVariable("customerId") String customerId) throws CustomerDetailsNotFoundException {
		return new ResponseEntity<>(customerService.getCustomerDetails(customerId), HttpStatus.OK);
	}
}
