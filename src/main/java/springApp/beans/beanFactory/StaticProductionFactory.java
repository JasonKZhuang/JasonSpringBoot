package springApp.beans.beanFactory;

public class StaticProductionFactory
{
	private static StaticProductionFactory service = new StaticProductionFactory();

	private StaticProductionFactory()
	{
		
	}
	
	public static StaticProductionFactory createInstance()
    {
		return service;
		
    }
	
	public void execute()
	{
		System.out.println("This is execute method in StaticProductionFactory.class");
	}
}
