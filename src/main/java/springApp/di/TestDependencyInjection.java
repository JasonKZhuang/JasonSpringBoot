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

		// Get bean instance
		DIConstructorBased constructorBased = appContext
				.getBean("constructorBased", DIConstructorBased.class);
		constructorBased.execute();

		// Get bean instance
		DISetterBased setterBased = appContext
				.getBean("setterBased", DISetterBased.class);
		setterBased.execute();

	}

}
