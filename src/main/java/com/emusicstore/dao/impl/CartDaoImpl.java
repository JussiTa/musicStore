package com.emusicstore.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.emusicstore.dao.CartDao;
import com.emusicstore.model.Cart;
@Repository
@Transactional



public class CartDaoImpl implements CartDao {
	

	   @Autowired
	     SessionFactory sessionFactory;
	
	private Cart cart;
	private Map<String, Cart> listOfCarts;

	public CartDaoImpl() {
		listOfCarts = new HashMap<String, Cart>();
	}

	public Cart read(String cartId) {

		return listOfCarts.get(cartId);

	}

	public void update(String cartId, Cart cart) {
		if (!listOfCarts.keySet().contains(cartId)) {
			throw new IllegalArgumentException(
					String.format("Cannot find cart given id(%)" + "doesn't" + "exist", cart.getId()));

		}

		listOfCarts.put(cartId, cart);

	}

	public void delete(String id) {
		// TODO Auto-generated method stub

	}

	public void create(Cart cart) {
		if (listOfCarts.keySet().contains(cart.getId())) {
			throw new IllegalArgumentException(
					String.format("Cart already (%)"  + "exist", cart.getId()));
		}
		listOfCarts.put(cart.getId(), cart);
		

	}
	

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public Map<String, Cart> getListOfCarts() {
		return listOfCarts;
	}

	public void setListOfCarts(Map<String, Cart> listOfCarts) {
		this.listOfCarts = listOfCarts;
	}

}
