package com.emusicstore.Service.impl;

import org.springframework.stereotype.Service;

import com.emusicstore.Service.CustomerService;
import com.emusicstore.model.Customer;
@Service
public class CustomerServiceImpl implements CustomerService {

	@Override
	public Customer getcustomerByUsername(String getUsername) {
		Customer customer = new Customer();
		
		return customer;
		
	}

}
