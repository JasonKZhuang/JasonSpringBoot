package com.jasonz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import springApp.beans.Production;

//====================================
//@Controller is typically used in combination with a @RequestMapping annotation used on request handling methods.

//Notice the @ResponseBody added to each of the @RequestMapping methods in the return value. 
//After that, the following must be performed:
//Add the <context:component-scan> and <mvc:annotation-driven /> tags to the Spring configuration file.
//<context:component-scan> activates the annotations and scans the packages to find and register beans within the application context.
//<mvc:annotation-driven/> adds support for reading and writing JSON/XML if the Jackson/JAXB libraries are on the classpath.
//For JSON format, include the jackson-databind jar and for XML include the jaxb-api-osgi jar to the project classpath.

//====================================

@Controller
@RequestMapping("productions")//http://localhost:8080/context/productions
public class SimpleController
{
	Production production = new Production();

	@RequestMapping(value = "/{name}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Production getProductionInJSON(@PathVariable String name)
	{
		production.setName(name);
		production.setPrice(123.456d);
		return production;
	}

	@RequestMapping(value = "/{name}.xml", method = RequestMethod.GET, produces = "application/xml")
	public @ResponseBody Production getProductionInXML(@PathVariable String name)
	{
		production.setName(name);
		production.setPrice(123.456d);
		return production;
	}
}
