package com.inetbanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.AddCustomerPage;
import com.inetbanking.pageObjects.LoginPage;



public class TC_AddCustomerTest_003 extends BaseClass
{

	@Test
	public void addNewCustomer() throws InterruptedException, IOException
	{
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(username);   // Came from config.properties file
		logger.info("Enter User name for Test Case3");
		lp.setPassword(password);      // Came from config.properties file
		logger.info("Enter Passsword for Test Case3");
		lp.ClickSubmit();
		
		Thread.sleep(3000);
		
		AddCustomerPage addcust=new AddCustomerPage(driver);
		
		addcust.clickAddNewCustomer();
		
		logger.info("Providing Customer Details....");
		
		
		addcust.custName("Devendra");
		addcust.custgender("Male");
		addcust.custdob("11","16","1983");
		Thread.sleep(5000);
		addcust.custaddress("INDIA");
		addcust.custcity("Pune");
		addcust.custstate("Maharashtra");
		addcust.custpinno("411028");
		addcust.custtelephoneno("8668361147");
		
		String email=randomestring()+"@gmail.com";   //Generate random email id
		addcust.custemailid(email);
		
		addcust.custpassword("abcdef");
		addcust.custsubmit();
		
		Thread.sleep(3000); 
		
		logger.info("Validation Started....");
		
		boolean res=driver.getPageSource().contains("Customer Registered Successfully!!!");
		
		if(res==true)
		{
			Assert.assertTrue(true);
			logger.info("Test Case3  passed....");
			
		}
		else
		{
			Assert.assertTrue(false);
			captureScreen(driver,"addNewCustomer");
			logger.info("Test Case3 failed....");
		}
			
	}

	
	// Generate random email id
	
	/*   //  Move this method in Base class because it requires in other test case 
	public String randomestring()
	{
		String generatedstring=RandomStringUtils.randomAlphabetic(8);
		return(generatedstring);
	}
	
	public static String randomeNum() {
		String generatedString2 = RandomStringUtils.randomNumeric(4);
		return (generatedString2);
	}
	*/
	
}
