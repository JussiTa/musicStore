package com.emusicstore.Service;

import com.emusicstore.model.Cart;
import com.emusicstore.model.CartItem;

public interface CartService {



public void addItem(CartItem item);



public Cart getCartById(String id);

}