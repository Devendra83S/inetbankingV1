package com.inetbanking.testCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;
import com.inetbanking.utilities.XLUtils;

public class TC_LoginDDT_002 extends BaseClass
{
	// data came from xls sheet
	
	@Test(dataProvider="LoginData")
	public void loginDDT(String user,String pwd) throws InterruptedException
	{
		LoginPage lp= new LoginPage(driver);
		
		lp.setUserName(user);  // pass this parameter from loginDTT class 
		logger.info("Enter Username for Test Case2");	
		lp.setPassword(pwd);   // pass this parameter from loginDTT class 
		logger.info("Enter Password for Test Case2");	
		lp.ClickSubmit();
		Thread.sleep(3000);
				
		if(isAlertPresent()==true) 
		{
			driver.switchTo().alert().accept();    // close alert button after invalid login
			driver.switchTo().defaultContent();   // focus on main page
			
			Assert.assertTrue(false);             // this is failed case
			logger.warn("Login Test Case2 Failed");
			Thread.sleep(3000);
			
		}
		 else
		 {
			 Assert.assertTrue(true);
			 logger.info("Login Test Case2 Passed");
			 lp.clickLogout();
			 Thread.sleep(3000);
				
			 driver.switchTo().alert().accept(); // Close logout alert
			 driver.switchTo().defaultContent();
		 }
		
	}
	
	
	// User defined method created to check alert is present or not on for invalid login  
	public boolean isAlertPresent()    
	{ 
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e)
		{
			 return false;
		}
		
	}
	
	
   @DataProvider(name="LoginData")
	String [][] getData() throws IOException
	{
	 String path=System.getProperty("user.dir")+"/src/test/java/com/inetbanking/testData/LoginData.xlsx";
		//String path="E:\Selenium Project\Eclips\inetbankingV1\src\test\java\com\inetbanking\testData\LoginData.xlsx";
	
	 int rownum=XLUtils.getRowCount(path, "sheet1");
	 int colcount=XLUtils.getCellCount(path, "sheet1", 1);
	 
	 String logindat[][]=new String[rownum][colcount];
	  
	 for(int i=1;i<=rownum;i++)
	 {
		  for(int j=0;j<colcount;j++)
		  {
			  logindat[i-1][j]=XLUtils.getCellData(path, "sheet1", i, j);   // 1  0
		  }
	 }
	 
	 return logindat;
	}
}
