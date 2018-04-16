package com.emusicstore.model;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

public class Customer {
	
@Id	
@GeneratedValue
private int customerId;
	

@OneToMany(mappedBy="customer", cascade=CascadeType.ALL, fetch=FetchType.EAGER)	
private CustomerOrder order;

}
