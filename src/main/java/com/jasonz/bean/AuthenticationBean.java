package com.jasonz.bean;

public class AuthenticationBean
{
	private String username;
	private String message;
	
	
	public AuthenticationBean(String message)
	{
		super();
		this.message = message;
	}
	
	public String getUsername()
	{
		return username;
	}
	public void setUsername(String username)
	{
		this.username = username;
	}
	public String getMessage()
	{
		return message;
	}
	public void setMessage(String message)
	{
		this.message = message;
	}

	
	
}
