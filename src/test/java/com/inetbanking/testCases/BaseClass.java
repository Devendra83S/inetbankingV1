package com.inetbanking.testCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetbanking.utilities.ReadConfig;


// Reusable/ Repeatable/ Common parts are kept here in base class
public class BaseClass {
 
	ReadConfig readconfig=new ReadConfig();
//	public String baseURL=readconfig.getApplicationURL();
	public String username=readconfig.getUserName();
	public String password=readconfig.getPassword();
	
	/*
 	//public String baseURL="https://www.demo.guru99.com/V4/";
	public String username="mngr26593";
	public String password="ishal!12";
	*/
	
	public static WebDriver driver;
	public static Logger logger;

	
	@Parameters("browser")
	
	//  This  Method Execute 1st 
	@BeforeClass   
	public void setup(String br)
	{
       /*  
		DesiredCapabilities cap = DesiredCapabilities.chrome();    
	      cap.setCapability (CapabilityType.ACCEPT_SSL_CERTS, true);
		  System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		  driver=new ChromeDriver(cap);
		  driver.manage().window().maximize();
		  driver.get("http://www.demo.guru99.com/V4/");
	*/	
		
		
	/*   
		//System.setProperty("webdriver.chrome.driver", "E:\\Selenium Project\\Eclips\\inetbankingV1\\Drivers\\chromedriver.exe");
	// System.getProperty give you  the Project home directory( e.g E:\\Selenium Project\\Eclips\\inetbankingV1);	
	//  OR		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		
		System.setProperty("webdriver.chrome.driver", readconfig.getChromePath());
		driver=new ChromeDriver();driver.manage().window().maximize();
		driver.get("http://www.demo.guru99.com/V4/");
		
	*/	
	// Run on different browser 	
		if(br.equals("chrome"))
		{ 
			System.setProperty("webdriver.chrome.driver", readconfig.getChromePath());
			driver=new ChromeDriver();
		}
		else if(br.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", readconfig.getFirefoxPath());
			driver=new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("http://www.demo.guru99.com/V4/");
		
	    
///////////////////////// Add logs to test case///////////////////
		
		logger =Logger.getLogger("ebanking");
		PropertyConfigurator.configure("Log4j.properties");
		
		
	}
   
	
	 //  This  Method Execute 3rd
	@AfterClass              
	public void tearDown()
	{
	   driver.quit();
	}
	
// Capture failed test case screen shot	
	public void captureScreen(WebDriver driver,String tname) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot) driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File target= new File(System.getProperty("user.dir") + "/Screenshots/" +tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
		
	}
	
	// Generate random email id
	public String randomestring()
	{
		String generatedstring=RandomStringUtils.randomAlphabetic(8);
		return(generatedstring);
	}
	
	// Generate random Number
	public static String randomeNum() {
		String generatedString2 = RandomStringUtils.randomNumeric(4);
		return (generatedString2);
	}
	
}
