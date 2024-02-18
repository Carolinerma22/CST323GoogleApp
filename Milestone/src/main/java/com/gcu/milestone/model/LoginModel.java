package com.gcu.milestone.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


public class LoginModel 
{
	//Error messages for username
	private String username;
	
	//Error messages for password
	private String password;
	
	
	//Getters and Setters
	public String getUsername() 
	{
		return username;
	}
	
	
	public void setUsername(String username) 
	{
		this.username = username;
	}
	
	
	public String getPassword() 
	{
		return password;
	}
	
	
	public void setPassword(String password) {
		this.password = password;
	}
}