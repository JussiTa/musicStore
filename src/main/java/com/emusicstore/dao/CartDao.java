package com.emusicstore.dao;

import com.emusicstore.model.Cart;

public interface CartDao {
	public Cart getCartById(int cartID);
	
	public void update(int cartId);	
	
	

}
