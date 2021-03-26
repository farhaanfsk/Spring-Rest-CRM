package com.fsk.spring.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fsk.spring.dao.CustomerDao;
import com.fsk.spring.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	CustomerDao customer;

	@Transactional
	public List<Customer> listCustomers() {
		return customer.listCustomer();
	}

	@Transactional
	public Customer getCustomer(int customerId) {
		return customer.getCustomer(customerId);
	}

}
