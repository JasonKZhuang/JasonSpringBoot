/**
 * Reference: Spring Framework Reference Documentation 4.3.25.RELEASE
 * 7.2 Container overview
 */
package springApp.container;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import springApp.servicesSamples.ProductionServiceImpl;

/**
 * @author Jason.Zhuang Oct 18, 2019 ContainerExample.java Describe:
 */
public class ContainerExample
{
	public static void main(String[] args)
	{
		/*
		 * A Spring IoC container manages one or more beans. These beans are
		 * created with the configuration metadata that you supply to the
		 * container
		 */
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"springApp/container/services.xml",
				"springApp/container/daos.xml");

		// Using the method T getBean(String name, Class<T> requiredType)
		// You can retrieve instances of your beans.
		ProductionServiceImpl service = context.getBean("myProductionService",
				ProductionServiceImpl.class);

		service.getList();

	}

}
