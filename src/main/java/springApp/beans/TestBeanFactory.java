package springApp.beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import springApp.beans.beanFactory.InstanceProductionFactory;
import springApp.beans.beanFactory.StaticProductionFactory;
import springApp.servicesSamples.AccountService;
import springApp.servicesSamples.ClientService;

public class TestBeanFactory
{
	@SuppressWarnings("resource")
	public static void main(String[] args)
	{
		// Read the Configuration file using ApplicationContext
		ApplicationContext appContext = new ClassPathXmlApplicationContext(
				"springApp/beans/services.xml");

		// Get BeanSample instance
		BeanSample bSample = appContext.getBean("beanSample", BeanSample.class);
		bSample.Method1();
		bSample.Method2();

		// get BaseInstanceBean instance
		BaseInstanceBean baseInstanceBean = appContext.getBean("baseInstanceBean",
				BaseInstanceBean.class);
		baseInstanceBean.execute();

		// get StaticProductionFactory instance
		StaticProductionFactory staticFactory = (StaticProductionFactory) appContext
				.getBean("myStaticProductionFactory");
		staticFactory.execute();
		
		// get InstanceProductionFactory instance
		InstanceProductionFactory instanceFactory = (InstanceProductionFactory) appContext
				.getBean("myInstanceProductionFactory");
		instanceFactory.execute();
		
		ClientService clientService = (ClientService) appContext
				.getBean("clientService");
		clientService.method1();
		
		AccountService accountService = (AccountService) appContext
				.getBean("accountService");
		accountService.method2();
		
		
	}

}
