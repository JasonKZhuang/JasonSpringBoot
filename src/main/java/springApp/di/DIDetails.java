package springApp.di;

import java.util.List;
import java.util.Map;
import java.util.Properties;

public class DIDetails
{
	//Dependencies - Straight values (primitives, Strings, and so on)
	private String driverClassName;
	private String url;
	private String username;
	private String password;
	
	//<!-- Dependencies - typed as a java.util.Properties -->
	private Properties properties;
	
	//<!-- results in a setAdminEmails(java.util.Properties) call -->
	private Properties adminEmails;
	
	//<!-- results in a setSomeList(java.util.List) call -->
	private List someList;
	
	private Map<Integer, String> someMap;
	
	public void execute()
	{
		System.out.println("==Dependencies Details =====================");
		System.out.println("==>driverClassName:"+this.getDriverClassName());
		System.out.println("==>Properties:"+this.getProperties());
		System.out.println("==>adminEmails:"+this.getAdminEmails());
		System.out.println("==>SomeList:"+this.getSomeList().size());
		System.out.println("==>SomeMap:"+this.getSomeMap().get(1));
		
		
		
		System.out.println("============================================");
	}
	
	public void close()
	{
		;
	}
	
	//get set methods
	public String getDriverClassName()
	{
		return driverClassName;
	}
	public void setDriverClassName(String driverClassName)
	{
		this.driverClassName = driverClassName;
	}
	public String getUrl()
	{
		return url;
	}
	public void setUrl(String url)
	{
		this.url = url;
	}
	public String getUsername()
	{
		return username;
	}
	public void setUsername(String username)
	{
		this.username = username;
	}
	public String getPassword()
	{
		return password;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}

	public Properties getProperties()
	{
		return properties;
	}

	public void setProperties(Properties properties)
	{
		this.properties = properties;
	}

	public Properties getAdminEmails()
	{
		return adminEmails;
	}

	public void setAdminEmails(Properties adminEmails)
	{
		this.adminEmails = adminEmails;
	}

	public List getSomeList()
	{
		return someList;
	}

	public void setSomeList(List someList)
	{
		this.someList = someList;
	}

	public Map<Integer, String> getSomeMap()
	{
		return someMap;
	}

	public void setSomeMap(Map<Integer, String> someMap)
	{
		this.someMap = someMap;
	}

	
	
	

}
