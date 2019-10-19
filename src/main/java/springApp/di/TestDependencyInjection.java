package springApp.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestDependencyInjection
{
	public static void main(String[] args)
	{
		// Read the Configuration file using ApplicationContext
		@SuppressWarnings("resource")
		ApplicationContext appContext = new ClassPathXmlApplicationContext(
				"springApp/di/services.xml");

		// Get DIConstructorBased instance
		DIConstructorBased constructorBased = appContext
				.getBean("constructorBased", DIConstructorBased.class);
		constructorBased.execute();

		// Get DISetterBased instance
		DISetterBased setterBased = appContext
				.getBean("setterBased", DISetterBased.class);
		setterBased.execute();
		
		// Get DIDetails instance
		DIDetails diDetails = appContext
						.getBean("diDetails", DIDetails.class);
		diDetails.execute();
		
		// Get DIUsingDependsOn instance
		DIUsingDependsOn diUsingDependsOn = appContext
								.getBean("diUsingDependsOn", DIUsingDependsOn.class);
		//diUsingDependsOn.execute();

	}

}
