package com.jasonz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

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
@ComponentScan({ "com.jasonz.service", "com.jasonz.controller", "com.jasonz.security" })
@EnableJpaRepositories(basePackages = "com.jasonz.repositories", repositoryBaseClass = CustomRepositoryImpl.class)
@Configuration
public class JasonSpringBootApplication extends SpringBootServletInitializer
{
	public static void main(String[] args)
	{
		// https://docs.spring.io/spring-boot/docs/current/reference/html/common-application-properties.html
		System.setProperty("server.servlet.context-path", "/jasonSpringBoot");
		System.setProperty("server.port", "8080");

		SpringApplication.run(JasonSpringBootApplication.class, args);

		// System.out.println("=============");
		// ImportDataCSV imp = new ImportDataCSV();
		// imp.importFiles();
	}

	/**
	 * Global CORS configuration add a method to configure how to handle
	 * cross-origin resource sharing.
	 * https://howtodoinjava.com/spring5/webmvc/spring-mvc-cors-configuration/
	 * 
	 * @return
	 */
	@Bean
	public WebMvcConfigurer corsConfigurer()
	{
		String[] allowURL = { "http://localhost:4200", "http://localhost:3000" };

		return new WebMvcConfigurer()
		{
			@Override
			public void addCorsMappings(CorsRegistry registry)
			{
				registry.addMapping("*").allowedOrigins(allowURL);
			}
		};
	}

}
