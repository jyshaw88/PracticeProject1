package com.PracticeProject.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig 
{
	Properties prop;
	// just like page object model .find all properties element and action on it
	public ReadConfig()
	{		
		File src = new File("./Configuration/config.properties");
		try
		{
			FileInputStream fis = new FileInputStream(src); 
			prop = new Properties();
			prop.load(fis);
		}
		catch(Exception e)
		{
			System.out.println("Exception is " + e.getMessage());
		}
		
	}
	
	// get all variable in config properties file by get methid like POM
	
	public String getApplicationURL()
	{
		String url = prop.getProperty("BaseURL");
		return url;
	}
	
	public String getUsername()
	{
		String username = prop.getProperty("Username");
		return username;
	}
	
	public String getPassword()
	{
		String password = prop.getProperty("Password");
		return password;
	}
	
	public String getChromePath()
	{
		String chromepath = prop.getProperty("chromepath");
		return chromepath;
	}
	public String getFireFox()
	{
		String firefox = prop.getProperty("firefoxpath");
		return firefox;
	}
	public String getIEPath()
	{
		String IEPath = prop.getProperty("iepath");
		return IEPath;
	}
}
