package com.jasonz.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author Jason Zhuang
 * @version Create Date：Aug 15, 2018 11:15:34 AM
 */

@Entity
public class UserRecord
{
	@Id
    @Column(name = "id", nullable = false, length = 10 )
    private int id;
	
	@Column(name = "name", length = 100)
    private String name;
	
	@Column(name = "email", length = 100)
	private String email;

	public UserRecord()
	{
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}
	
	
}