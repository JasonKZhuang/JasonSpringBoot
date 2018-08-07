package com.jasonz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

// 启动方式: 使用 spring-boot 的内嵌的 tomcat启动 项目
@ComponentScan(basePackages={"com.jasonz"})
@SpringBootApplication
public class JasonSpringBootApplication 
{

//	@Override
//	protected SpringApplicationBuilder configure(SpringApplicationBuilder application)
//	{
//		return application.sources(JasonSpringBootApplication.class);
//	}

	public static void main(String[] args)
	{
		// 默认使用 tomcat 容器 ，端口 8080
		// 如果要 启动容器加载 这个 web 类，必须在类上加上 @EnableAutoConfiguration
		// SpringApplication.run(WebController.class, args);
		// System.out.println(">>>>>>>>>>>>>>>");
		// SpringApplication.run(TestController.class, args);

		// 启动项目，默认是 tomcat 启动 端口 8080 ,
		// 不管有没有写controller 都会一直启动的，和以前启动tomcat项目一样的
		SpringApplication.run(JasonSpringBootApplication.class, args);

		// 需要 注意该类是否 和 controller 在同一个包，必须在同一个包下面，才可以访问的，或者是配置了包扫描的路径
		// 默认包扫描的路径是 这个启动类的 同一级目录下的
	}
}
