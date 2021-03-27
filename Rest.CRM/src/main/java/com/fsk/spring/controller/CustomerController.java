package com.fsk.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fsk.spring.entity.Customer;
import com.fsk.spring.entity.CustomerSuccessResponse;
import com.fsk.spring.exceptions.CustomerNotFound;
import com.fsk.spring.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerController {
	@Autowired
	CustomerService customer;

	@GetMapping("/customers")
	public List<Customer> getCustomers() {
		return customer.listCustomers();
	}

	@GetMapping("/customers/{customerId}")
	public Customer getCustomer(@PathVariable int customerId) {
		return getCustomerIfExists(customerId);
	}

	private Customer getCustomerIfExists(int customerId) {
		Customer c = customer.getCustomer(customerId);
		if (c == null) {
			throw new CustomerNotFound("Customer is not found : " + customerId);
		}
		return c;
	}

	@PostMapping("/customers")
	public CustomerSuccessResponse addCustomer(@RequestBody Customer c) {
		return new CustomerSuccessResponse(HttpStatus.OK.value(),
				"Customer is added successfully with ID : " + customer.addCustomer(c));
	}
	
	@PutMapping("/customers")
	public CustomerSuccessResponse updateCustomer(@RequestBody Customer c) {
		getCustomerIfExists(c.getId());
		customer.updateCustomer(c);
		return new CustomerSuccessResponse(HttpStatus.OK.value(),
				"Customer is updated successfully ");
	}
	
	@DeleteMapping("/customers/{customerId}")
	public CustomerSuccessResponse updateCustomer(@PathVariable int customerId) {
		customer.deleteCustomer(customerId);
		return new CustomerSuccessResponse(HttpStatus.OK.value(),
				"Customer is Deleted successfully ");
	}

}