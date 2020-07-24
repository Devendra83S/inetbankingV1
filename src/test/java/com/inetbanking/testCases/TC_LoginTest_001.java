package com.inetbanking.testCases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.inetbanking.pageObjects.LoginPage;

//Actual Test Cases are kept here 
public class TC_LoginTest_001 extends BaseClass 
{

//  This  Method Execute 2nd
	@Test
	public void loginTest() throws IOException
	{
		
//  Here we get url(e.g www.google.com )baseURL which comes from BaseClass.java
		//driver.get(baseURL); 
	
 // for Calling method from LoginPage.java we have to create object 	
		logger.info("URL is Open");		
		
		LoginPage lp=new LoginPage(driver);
	
	//  With the help of above object call Following method from LoginPage.java and pass parameter comes from BaseClass.java
		
		
		lp.setUserName(username);
		logger.info("Enter Username for Test Case1");		
		
		lp.setPassword(password);
		logger.info("Enter Password for Test Case1");
		
		lp.ClickSubmit();

		if(driver.getTitle().equals("Guru99 Bank Manager HomePage" ))
		{
			Assert.assertTrue(true);
			logger.info("Login Test Case1 Pass");
		}
		else
		{
			captureScreen(driver,"loginTest");     // loginTest is a test case name
			Assert.assertTrue(false);
			logger.info("Login Test Case1 Fail");
		}
	}



}
