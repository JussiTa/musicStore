package com.emusicstore.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class CustomerOrder {
	
	
	@Id	
	@GeneratedValue
	private int customerorderId;

	public int getCustomerorderId() {
		return customerorderId;
	}
	
	
	@ManyToOne
	@JoinColumn(name="customerId")
	private Customer customer;

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public void setCustomerorderId(int customerorderId) {
		this.customerorderId = customerorderId;
	}

}
