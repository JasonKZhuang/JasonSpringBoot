package springApp.beans.beanFactory;

import springApp.servicesSamples.AccountService;
import springApp.servicesSamples.AccountServiceImpl;
import springApp.servicesSamples.ClientService;
import springApp.servicesSamples.ClientServiceImpl;

public class InstanceProductionFactory
{
	private static ClientService clientService = new ClientServiceImpl();

    private static AccountService accountService = new AccountServiceImpl();
    
	private InstanceProductionFactory()
	{
		
	}
	
	public ClientService createClientServiceInstance() 
	{
        return clientService;
    }

    public AccountService createAccountServiceInstance() 
    {
        return accountService;
    }
	
    public void execute()
	{
		System.out.println("This is execute method in InstanceProductionFactory.class");
	}
}
