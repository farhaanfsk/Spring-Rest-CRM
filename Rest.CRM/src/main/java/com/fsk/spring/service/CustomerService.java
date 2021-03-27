package com.fsk.spring.service;

import java.util.List;

import com.fsk.spring.entity.Customer;

public interface CustomerService {
	
	public List<Customer> listCustomers();
	
	public Customer getCustomer(int customerId);

	public int addCustomer(Customer c);

	public void updateCustomer(Customer c);

	public void deleteCustomer(int customerID);
}
