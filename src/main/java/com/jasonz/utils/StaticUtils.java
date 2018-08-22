/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jasonz.utils;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FilenameUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 *
 * @author Jason Zhuang
 */
public class StaticUtils
{
	private static Logger log;
	
	private static ApplicationContext context;

	private static String buildPath = "";

	private static String projectPath = "";
	
	private static String standardPath = "";
	
	private static String absolutePath = "";
	
	private static String classPath = ""; 
	
	private static String resourcePath ="";

	static
	{
		File directory = new File("");
		try
		{
			classPath = System.getProperty("java.class.path");
			String arrCurrentRunPath[] = classPath.split(";");
			buildPath = arrCurrentRunPath[0];
			projectPath  = System.getProperty("user.dir");
			standardPath = directory.getCanonicalPath();
			absolutePath = directory.getAbsolutePath();
			resourcePath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
			log = LogManager.getLogger();		
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	public static void main(String[] args)
	{
		Date date = new Date();
		try
		{
			date = new SimpleDateFormat("yyyy-MM-dd").parse("2008-05-14");
		} catch (ParseException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		System.out.println (new SimpleDateFormat("yyyy-MM-dd").format(date));
		System.out.println(buildPath);
		System.out.println(projectPath);
		System.out.println(standardPath);
		System.out.println(absolutePath);
		System.out.println(classPath);
		System.out.println(resourcePath);
		
		
	}
	
	public static ApplicationContext getContext()
	{
		return context;
	}
	
	public static void initApplicationContext()
	{
		context = new FileSystemXmlApplicationContext(getSpringConfigFile());
		log.info("Initialize system completed!");
	}

	public static String getLocalDataStoreDirectory()
	{
		String file = projectPath + "\\data\\";
		return file;
	}

	public static String getSpringConfigFile()
	{
		String file = resourcePath + "\\conf\\spring.xml";
		return file;
	}
	
	public static List<String> getCSVDataFileNames()
	{
		List<String> fileNames = new ArrayList<>();
		File localDirectory = new File(getLocalDataStoreDirectory());
	    String[] localDirectoryFiles = localDirectory.list();
	    if (localDirectoryFiles.length > 0) 
	    {
	        // determine the latest available filename
	        for (int i = 0; i < localDirectoryFiles.length; i++) 
	        {
	            String theName = localDirectoryFiles[i];
	            if ((theName != null) && (!theName.equals(""))) 
	            {
	            	String extensionName= FilenameUtils.getExtension(theName);
	            	if (extensionName.equals("csv"))
	            	{
	            		fileNames.add(localDirectory+"\\"+theName);
	            	}else
	            	{
	            		continue;
	            	}
	                //String fileNameWithOutExt1 = FilenameUtils.getBaseName(theName);
	                //String fileNameWithOutExt2 = FilenameUtils.removeExtension(theName);
	                //System.out.println(extensionName);
	                //System.out.println(fileNameWithOutExt1);
	            	//System.out.println(fileNameWithOutExt2);
	            }
	        }
	    }
	    
	    return fileNames;
	}

}
