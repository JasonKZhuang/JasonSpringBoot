package com.jasonz.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** 
* @author Jason Zhuang
* @version Create Date：Aug 7, 2018 2:35:15 PM 
*/
@RestController
public class HomeController
{

	@RequestMapping("/hello")
	public String hello()
	{
		System.out.println(">>>>>>hello");
		return "hello";
	}

}
