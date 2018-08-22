package com.jasonz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jasonz.service.ShareServices;

/**
 * @author Jason Zhuang
 * @version Create Date：Aug 7, 2018 2:35:15 PM
 */
@RestController
public class ShareController
{
	// The @RequestMapping annotation is used to provide routing information. 
	// It tells to the Spring that 
	// any HTTP request should map to the corresponding method.
	
	@Autowired
	private ShareServices shareService;
	
	@RequestMapping(value = "/imp", method=RequestMethod.GET)  
    public String example()
	{  
		System.out.println(">>>>>>import data from csv");
		shareService.importFiles();
		return "hello";
    }  

}
