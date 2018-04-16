package com.emusicstore.model;

public class Authorities {
	
	private String authorities="USER_ROLE";
	private String username="jussi";
	private String password="jusa";
			

	public String getName() {
		return username;
	}

	public void setName(String name) {
		this.username = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAuth() {
		return authorities;
	}

	public void setAuth(String auth) {
		this.authorities = auth;
	}

}
