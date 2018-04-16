package com.emusicstore.model;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Cart {
	
	private double grandTotal;
	private String id;
	@OneToMany (mappedBy ="cart", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private Map<String, CartItem> cartItems;
	@OneToOne
	@JoinColumn(name="customerId")
	@JsonIgnore
	private Customer customer;
	
	private Cart() {
		cartItems= new HashMap<String, CartItem>();
		
	}

	public Cart(String cartId) {
		this();
		this.id=cartId;
	}

	public double getGrandTotal() {
		return grandTotal;
	}

	public void setGrandTotal(double grandTotal) {
		this.grandTotal = grandTotal;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Map<String, CartItem> getCartItems() {
		return cartItems;
	}

	public void setCartItems(Map<String, CartItem> cartItems) {
		this.cartItems = cartItems;
	}
	
	public void addItem(CartItem item) {
		cartItems.put(item.getId(), item);
	}
	public void removeItem(CartItem item) {
		cartItems.remove(item.getId());
		
		
	}

}
