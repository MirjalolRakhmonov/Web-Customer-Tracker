package com.mirjalolcode.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mirjalolcode.springdemo.entity.Customer;
import com.mirjalolcode.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	// need to inject the customer service
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/list")
	public String listCustomers(Model theModel) {
		// get customers from the dao
		List<Customer> theCustomers=customerService.getCustomers();
		
		// add the customers to the model
		theModel.addAttribute("customers", theCustomers);
		
		return "list-customers";
	}
}
