package com.emusicstore.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class CartItem {
	private int quantity=0;
	private double totalPrice=0;
	@ManyToOne
	@JoinColumn(name="productId")
	private Product product;
	@ManyToOne
	@JoinColumn(name ="cartId")
	private Cart cart;
	

	
	public Cart getCart() {
		return cart;
	}


	public void setCart(Cart cart) {
		this.cart = cart;
	}


	@Id	
	@GeneratedValue
	private int cartitemId;
	
	


	public Product getProduct() {
		return product;
	}


	public void setProduct(Product product) {
		this.product = product;
	}


	public int getCartitemId() {
		return cartitemId;
	}


	public void setCartitemId(int cartitemId) {
		this.cartitemId = cartitemId;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity += quantity;
	}


	public double getTotalPrice() {
		return totalPrice;
	}


	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}


		
		
	}


