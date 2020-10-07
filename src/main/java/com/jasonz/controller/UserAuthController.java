package com.jasonz.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jasonz.bean.AuthenticationBean;

@RestController
@RequestMapping("usr")
@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200" })
public class UserAuthController
{
	@GetMapping(path="/auth")
	public AuthenticationBean login()
	{
		return new AuthenticationBean("You are authenticated!");
	}
}
