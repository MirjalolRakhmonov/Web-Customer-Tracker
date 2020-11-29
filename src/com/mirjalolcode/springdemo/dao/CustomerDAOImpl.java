package com.mirjalolcode.springdemo.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mirjalolcode.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	// need to inject the session factory
	@Autowired
	private SessionFactory SessionFactory;
	
	@Override
	public List<Customer> getCustomers() {
		// get the current hibernate session
		Session currentSession=SessionFactory.getCurrentSession();
		
		// create a query
		Query<Customer> theQuery=currentSession.createQuery("from Customer", Customer.class);
		
		// execute query and get result list
		List<Customer> customers=theQuery.getResultList();
		
		// return results
		return customers;
	}

	@Override
	public void saveCustomer(Customer theCustomer) {
		// get current hibernate session
		Session currentSession=SessionFactory.getCurrentSession();
		
		// save the customer 
		currentSession.save(theCustomer);
	}

}
