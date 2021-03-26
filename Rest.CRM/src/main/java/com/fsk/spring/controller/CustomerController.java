package com.fsk.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fsk.spring.entity.Customer;
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

	@GetMapping("/customer/{customerId}")
	public Customer getCustomer(@PathVariable int customerId) {
		return customer.getCustomer(customerId);
	}

}