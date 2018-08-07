package com.jasonz.utils;

import java.io.IOException;
import java.util.Scanner;

public class ProcessHelper
{
	private String pName;

	public ProcessHelper(String pName)
	{
		this.pName = pName;
	}

	public static void main(String[] args)
	{
		String myName = "Thunder.exe";//// mysqld.exe
		ProcessHelper ph = new ProcessHelper(myName);
		String pId = ph.getPID(myName);
		//System.out.println(pId);
		ph.kPID(pId);
	}
	
	
	public void kPro(String pName)
	{
		String  pid = null;
		Scanner in = null;
		String cmd = "tasklist /nh /FI \"IMAGENAME eq " + pName + "\"";
		try
		{
			Runtime runtime = Runtime.getRuntime();
			Process process = runtime.exec(cmd);
			in = new Scanner(process.getInputStream());
			int count = 0;
			while (in.hasNextLine())
			{
				count++;
				String s1 = in.nextLine();
				if (s1.contains(pName))
				{
					int c = s1.indexOf(" ", s1.indexOf(".exe"));
					String s2 = s1.substring(c, s1.length()).trim();
					pid = s2.substring(0, s2.indexOf(" "));
					break;
				}
				if (count > 2000)
				{
					break;
				}
			}
			Runtime.getRuntime().exec("taskkill /F /PID " + pid);
		} catch (IOException e)
		{
			e.printStackTrace();
		} finally
		{
			if (in != null)
			{
				in.close();
			}
		}
	}

	private String getPID(String pName)
	{
		String pid = null;
		Scanner in = null;
		String cmd = "tasklist /nh /FI \"IMAGENAME eq " + pName + "\"";
		try
		{
			Runtime runtime = Runtime.getRuntime();
			Process process = runtime.exec(cmd);

			in = new Scanner(process.getInputStream());
			int count = 0;
			while (in.hasNextLine())
			{
				count++;
				String s1 = in.nextLine();
				if (s1.contains(pName))
				{
					int c = s1.indexOf(" ", s1.indexOf(".exe"));
					String s2 = s1.substring(c, s1.length()).trim();
					pid = s2.substring(0, s2.indexOf(" "));
					return pid;
				}
				if (count > 2000)
				{
					break;
				}
			}
		} catch (IOException e)
		{
			e.printStackTrace();
		} finally
		{
			if (in != null)
			{
				in.close();
			}
		}
		return pid;
	}

	private void kPID(String pID)
	{
		try
		{
			Runtime.getRuntime().exec("taskkill /F /PID " + pID);
		} catch (IOException e1)
		{
			e1.printStackTrace();
		}
	}

	public static String findPid(String name)
	{
		Scanner in = null;
		try
		{
			Process process = Runtime.getRuntime().exec("taskList");
			in = new Scanner(process.getInputStream());
			int count = 0;
			while (in.hasNextLine())
			{
				count++;
				String s1 = in.nextLine();

				if (s1.contains(name))
				{
					int c = s1.indexOf(" ", s1.indexOf(".exe"));
					String s2 = s1.substring(c, s1.length()).trim();
					String pid = s2.substring(0, s2.indexOf(" "));
					return pid;
				}
				if (count > 2000)
				{
					break;
				}
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		} finally
		{
			if (in != null)
			{
				in.close();
			}
		}

		return "";
	}

	public static void showTaskList()
	{
		Scanner in = null; 
		try
		{
			Process process = Runtime.getRuntime().exec("taskList");
			in = new Scanner(process.getInputStream());
			int count = 0;
			while (in.hasNextLine())
			{
				count++;
				System.out.println(count + ":" + in.nextLine());
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		}finally
		{
			if (in != null)
			{
				in.close();
			}
		}
	}

	public static void startTask(String task)
	{
		try
		{
			Process p = Runtime.getRuntime().exec(task);
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
}
