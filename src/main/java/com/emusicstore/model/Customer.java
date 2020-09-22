package com.emusicstore.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
@Entity
public class Customer implements Serializable {	

private static final long serialVersionUID = 816034666787808392L;


@Id	
@GeneratedValue
private int customerId;
	

@OneToMany(mappedBy="customer", cascade=CascadeType.ALL, fetch=FetchType.EAGER)	
private List<CustomerOrder> order;

@OneToOne
@JoinColumn(name = "cartId")
private  Cart cart;


public int getCustomerId() {
	return customerId;
}


public void setCustomerId(int customerId) {
	this.customerId = customerId;
}


public List<CustomerOrder> getOrder() {
	return order;
}


public void setOrder(List<CustomerOrder> order) {
	this.order = order;
}


public void setCart(Cart cart) {
	this.cart = cart;
}


public static long getSerialversionuid() {
	return serialVersionUID;
}


public Cart getCart() {
	return cart;
}






}
