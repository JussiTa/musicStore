package com.emusicstore.model;

public class CartItem {
	private int quantity=0;
	private double totalPrice=0;
	private Product product;
	
	
	public CartItem(Product product) {
		this.product=product;
		this.quantity=1;
		
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


	public Product getProduct() {
		return product;
	}


	public void setProduct(Product product) {
		this.product = product;
	}
	
	public String getId() {
		return String.valueOf(product.getProductId());
		
		
		
	}

}
