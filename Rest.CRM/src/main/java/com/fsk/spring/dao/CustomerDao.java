package com.fsk.spring.dao;

import java.util.List;

import com.fsk.spring.entity.Customer;

public interface CustomerDao {

	public List<Customer> listCustomer();

	public Customer getCustomer(int customerId);

	public int addCustomer(Customer c);

	public void updateCustomer(Customer c);

	public void deleteCustomer(int customerId);
}
