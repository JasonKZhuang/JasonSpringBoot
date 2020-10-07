package com.jasonz.controller.simple;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jasonz.bean.HelloWorldBean;

/**
 * @author Jason Zhuang
 * @version Create Date：Aug 7, 2018 2:35:15 PM
 */
@CrossOrigin(origins = { "http://localhost:4200","http://localhost:3000" })
@RestController
@RequestMapping("welcome") // http://localhost:8080/jasonSpringBoot/welcome
public class HelloExampleController
{
	// The @RequestMapping annotation is used to provide routing information. It
	// tells to the Spring that any HTTP request should map to the corresponding
	// method.
	@RequestMapping(value = "/HelloWorld", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	// http://localhost:8080/jasonSpringBoot/welcome/HelloWorld
	public HelloWorldBean HelloWorldBean()
	{
		HelloWorldBean bean = new HelloWorldBean();
		bean.setName("Hello World Bean Class");
		return bean;
	}

	// http://localhost:8080/jasonSpringBoot/welcome/HelloWorld/path-variable
	@RequestMapping(value = "/HelloWorld/path-variable/{name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public HelloWorldBean HelloWorldBeanParameter(@PathVariable String name)
	{
		//String[] a = new String[]{"aa","bb"};
		HelloWorldBean bean = new HelloWorldBean();
		try
		{
			//a[3] = "fasfsd";
			bean.setName(String.format("Hello World Bean Class %s", name));
			return bean;
		}catch(Exception exp)
		{
			throw new RuntimeException(exp.getMessage());
		}
	}
}
