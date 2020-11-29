package com.mirjalolcode.springdemo.service;

import java.util.List;

import com.mirjalolcode.springdemo.entity.Customer;

public interface CustomerService {

	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);
}
