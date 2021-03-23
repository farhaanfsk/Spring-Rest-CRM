package com.fsk.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fsk.spring.dao.CustomerDao;
import com.fsk.spring.entity.Customer;

@Controller
@RequestMapping("/api")
public class CustomerController {
	@Autowired
	CustomerDao customer;

	@GetMapping("/customer")
	public List<Customer> getCustomer() {
		return customer.listCustomer();

	}
}
