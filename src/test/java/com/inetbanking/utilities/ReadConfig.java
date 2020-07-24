package com.inetbanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig 
{
  Properties pro;   // Here Properties is a separate class
  
  public ReadConfig()
  {

	  // Here ./ represent project directory where Configuration is a folder and in that config.properties file is present 
	  File src=new File("./Configuration/config.properties");
	  
	  try {
		  FileInputStream fis=new FileInputStream(src);  // Read the data
		  pro=new Properties();
		  pro.load(fis);  // load is a method for loading complete config.properties file 
	  }catch(Exception e) {
		  System.out.println("Exception is" + e.getMessage() );
	  }
	 
  }
  
  // Here different methods to read each and every variable and there values from config.properties
  
  public String getApplicationURL()
  {
	   String url=pro.getProperty("baseURL");   // name should be exactly same as name present in config.properties file (e.g-- baseURL)
	   return url;
  }
   public String getUserName()
   {
	   String username=pro.getProperty("username");
	   return username;
   }
   
   public String getPassword()
   {
	   String password=pro.getProperty("password");
	   return password;
   }
  
   public String getChromePath()
   {
	   String chromepath=pro.getProperty("chromepath");
	   return chromepath;
   }
   
   public String getFirefoxPath()
   {
	   String firefoxpath=pro.getProperty("firfoxpath");
	   return firefoxpath;
   }
   
}
