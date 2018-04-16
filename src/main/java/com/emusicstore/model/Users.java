package com.emusicstore.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/*@Entity
@Table(name = "user")*/
public class Users {

	@Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	private int Id;
	@NotNull
	private String username;
	@NotNull
	private String password;
	private int useId;
	private CustomerOrder order;
	public int getUseId() {
		return useId;
	}
	public void setUseId(int useId) {
		this.useId = useId;
	}
	public CustomerOrder getOrder() {
		return order;
	}
	public void setOrder(CustomerOrder order) {
		this.order = order;
	}

}
