package com.emart.dto;

import com.emart.backend.Entity.User;

//import com.etour.entities.Customer_Master;

public class LoginResponse {
    private boolean success;
    private User user;
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public LoginResponse(boolean success, User user) {
		super();
		this.success = success;
		this.user = user;
	}
	public LoginResponse() {
		super();
	}

    
}