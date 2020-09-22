package com.emusicstore.Service.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.emusicstore.Service.CartService;
import com.emusicstore.dao.impl.CartDaoImpl;
import com.emusicstore.model.Cart;
import com.emusicstore.model.CartItem;
@Service
public class CartServiceImpl implements CartService {
	
	private CartDaoImpl repository;
	
  public CartServiceImpl(@Qualifier("cart") CartDaoImpl repository) {
	  this.repository =repository;
  }
	@Override
	public void addItem(CartItem item) {
		// TODO Auto-generated method stub

	}

	@Override
	public Cart getCartById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
