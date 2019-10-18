package springApp.beans;

public class BaseInstanceBean
{
	private int filed1 = 0;

	private String filed2 = "";

	public BaseInstanceBean(int filed1, String filed2)
	{
		super();
		this.filed1 = filed1;
		this.filed2 = filed2;
		System.out.println(
				"加载配置文件就执行了这个构造方法 BaseInstanceBean  filed1 = " + filed1);
		System.out.println(
				"加载配置文件就执行了这个构造方法 BaseInstanceBean filed2 = " + filed2);
	}

	public void execute()
	{
		System.out.println("基本bean实例化后调用方法 BaseInstanceBean.execute");
		System.out.println(
				"this.filed1=" + this.filed1 + ":this.filed2=" + this.filed2);
	}
}
