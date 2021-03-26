package com.fsk.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fsk.spring.entity.Customer;

@Repository
public class CustomerDaoImpl implements CustomerDao {
	@Autowired
	SessionFactory sessionFactory;

	public List<Customer> listCustomer() {
		Session session = sessionFactory.getCurrentSession();
		Query<Customer> query = session.createQuery("from Customer order by lastName", Customer.class);
		return query.getResultList();
	}

	public Customer getCustomer(int customerId) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(Customer.class, customerId);
	}

}
