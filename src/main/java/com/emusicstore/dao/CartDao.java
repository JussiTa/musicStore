package com.emusicstore.dao;

import com.emusicstore.model.Cart;

public interface CartDao {
	public void create(Cart cart);
	public Cart read(String read);
	public void update(String cartId, Cart cart);	
	public void delete(String id);
	

}
