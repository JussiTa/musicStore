package com.emusicstore.model;


import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class Cart {
	
	private double grandTotal;
	@Id	
	@GeneratedValue
	private int cartId;
	@OneToMany (mappedBy ="cart", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private Map<String, CartItem> cartItems;
	
	public Map<String, CartItem> getCartItems() {
		return cartItems;
	}

	public void setCartItems(Map<String, CartItem> cartItems) {
		this.cartItems = cartItems;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@OneToOne
	@JoinColumn(name="customerId")
	@JsonIgnore
	private Customer customer;


	public double getGrandTotal() {
		return grandTotal;
	}

	public void setGrandTotal(double grandTotal) {
		this.grandTotal = grandTotal;
	}

	public int getId() {
		return cartId ;
	}
	
	public void setId(int id) {
		this.cartId = id;
	}

	
		
		
	}


////gggegegegegegege

