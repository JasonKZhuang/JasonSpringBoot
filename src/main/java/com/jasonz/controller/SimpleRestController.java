package com.jasonz.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import springApp.beans.Production;

//@RestController annotation, 
//you no longer need to add @ResponseBody to all the request mapping methods. 
//The @ResponseBody annotation is active by default. 

@RestController
@RequestMapping("productions")//http://localhost:8080/context/productions
public class SimpleRestController
{
	Production production = new Production();

	@RequestMapping(value = "/{name}", method = RequestMethod.GET, produces = "application/json")
	public Production getEmployeeInJSON(@PathVariable String name)
	{
		production.setName(name);
		production.setPrice(123.456d);
		return production;
	}

	@RequestMapping(value = "/{name}.xml", method = RequestMethod.GET, produces = "application/xml")
	public Production getEmployeeInXML(@PathVariable String name)
	{
		production.setName(name);
		production.setPrice(123.456d);
		return production;
	}

}
