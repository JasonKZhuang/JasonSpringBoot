package com.jasonz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.jasonz.repositories.CustomRepositoryImpl;

//spring-boot embeded tomcat start
//@ComponentScan(basePackages={"com.jasonz"})
//@SpringBootApplication(scanBasePackages = {"com.jasonz","com.jasonz.entities","com.jasonz.dao","com.jasonz.service"}, exclude = JpaRepositoriesAutoConfiguration.class)
//@SpringBootApplication
//@Configuration
//@ComponentScan(basePackages={"com.jasonz"})
//@EnableJpaRepositories(basePackages = "com.jasonz.dao", repositoryBaseClass = CustomRepositoryImpl.class)


@SpringBootApplication(exclude = JpaRepositoriesAutoConfiguration.class)
@EntityScan("com.jasonz.entities")
@ComponentScan({"com.jasonz.service","com.jasonz.controller"})
@EnableJpaRepositories(basePackages = "com.jasonz.repositories", repositoryBaseClass = CustomRepositoryImpl.class)
public class JasonSpringBootApplication extends SpringBootServletInitializer
{
	public static void main(String[] args)
	{
		SpringApplication.run(JasonSpringBootApplication.class, args);
		
		
		
		//System.out.println("=============");
		//ImportDataCSV imp = new ImportDataCSV();
		//imp.importFiles();
	}
	
	
}

