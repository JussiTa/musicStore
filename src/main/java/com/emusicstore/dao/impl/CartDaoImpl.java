package com.emusicstore.dao.impl;

import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.emusicstore.dao.CartDao;
import com.emusicstore.model.Cart;
@Repository
@Qualifier("cart")
public class CartDaoImpl implements CartDao {	
	
	@Autowired
	private SessionFactory sessionFactory;
	private int cartId;
	
	public void update(int cartId) {
		 this.setCartId(cartId); 
		
		}
		
	
	


    public Cart getCartById (int cartId) {
    	Session session = sessionFactory.getCurrentSession();
		return (Cart) session.get(Cart.class,cartId);
    	
    }





	public int getCartId() {
		return cartId;
	}





	public void setCartId(int cartId) {
		this.cartId = cartId;
	}



}
