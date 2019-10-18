package springApp.beans;

import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestBeanProperties
{

	public static void main(String[] args)
	{
		@SuppressWarnings("resource")
		ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext(
				new String[]{"instanceBeanSamples.xml"});
		BeanFactory fac = (BeanFactory)appContext;
		
		BeanSampleWithProp bsp = (BeanSampleWithProp)fac.getBean("beanSampleWithProp");
		
		Properties p = bsp.getP();
		String value="";
		value = p.getProperty("key1");
		System.out.println("--------------"+value);

		List<String>   l  = bsp.getL();
		System.out.println("--------------"+l);
		
		Map<String, Integer> m= bsp.getM();
		System.out.println("--------------"+m);
		
		BeanSample bs = bsp.getPbs();
		System.out.println("--------------"+bs);
		
	}

}
