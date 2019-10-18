package springApp.beans;

import java.util.List;
import java.util.Map;
import java.util.Properties;

public class BeanSampleWithProp
{
	private Properties   p;

	private List<String> l;
	
	private Map<String, Integer> m;
	
	private BeanSample pbs;
	
	public Properties getP()
	{
		return p;
	}

	public void setP(Properties p)
	{
		this.p = p;
	}

	public List<String> getL()
	{
		return l;
	}

	public void setL(List<String> l)
	{
		this.l = l;
	}

	public Map<String, Integer> getM()
	{
		return m;
	}

	public void setM(Map<String, Integer> m)
	{
		this.m = m;
	}

	public BeanSample getPbs()
	{
		return pbs;
	}

	public void setPbs(BeanSample pbs)
	{
		this.pbs = pbs;
	}

	
	
	
	
}
