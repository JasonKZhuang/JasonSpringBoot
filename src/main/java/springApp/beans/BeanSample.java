package springApp.beans;

public class BeanSample
{
	private int a;
	private String b;
	private float c;
	private boolean d;
	
	public void init()
	{
		System.out.println("这个是 BeanSample 的初始化方法");
	}
	
	public void destroy()
	{
		System.out.println("这个是 BeanSample 的销毁方法");
	}
	
	public void Method1()
	{
		System.out.println("you call BeanSample.Method1 通过<静态工厂>方法实例化bean后调用方法");
	}
	
	public void Method2()
	{
		System.out.println("you call BeanSample.Method2 通过<实例工厂>方法实例化bean后调用方法");
	}
	
	// get set methods
	public int getA()
	{
		return a;
	}
	public void setA(int a)
	{
		this.a = a;
	}
	public String getB()
	{
		return b;
	}
	public void setB(String b)
	{
		this.b = b;
	}
	public float getC()
	{
		return c;
	}
	public void setC(float c)
	{
		this.c = c;
	}
	public boolean isD()
	{
		return d;
	}
	public void setD(boolean d)
	{
		this.d = d;
	}
	
}
