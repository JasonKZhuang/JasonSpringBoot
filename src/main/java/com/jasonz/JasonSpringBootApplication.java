package com.jasonz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

//spring-boot embeded tomcat start
@ComponentScan(basePackages={"com.jasonz"})
@SpringBootApplication
public class JasonSpringBootApplication 
{
	public static void main(String[] args)
	{
		SpringApplication.run(JasonSpringBootApplication.class, args);
		//System.out.println("=============");
	}
}
