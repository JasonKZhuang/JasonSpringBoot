package com.jasonz.controller.simple;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Jason Zhuang
 * @version Create Date：Aug 7, 2018 2:35:15 PM
 */
@RestController
public class HelloController
{
	// The @RequestMapping annotation is used to provide routing information. It
	// tells to the Spring that any HTTP request should map to the corresponding
	// method.
	
	@RequestMapping("/hello")
	public String hello()
	{
		System.out.println(">>>>>>hello");
		return "hello";
	}
	
	@RequestMapping(value = "/example", method=RequestMethod.GET)  
    public String example(){  
        return "Example!";  
    }  

}
