package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver ldriver;    // driver object
	public LoginPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	 
	@FindBy(name="uid")
	@CacheLookup
	WebElement txtUserName;
	
	@FindBy(name="password")
	@CacheLookup
	WebElement txtPassword;
	
	@FindBy(name="btnLogin")
	@CacheLookup
	WebElement btnLogin;
	

	
//	driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[1]/ul[1]/li[15]/a[1]"));   // Absolute Xpath
	
//	driver.findElement(By.xpath("//a[contains(text(),'Log out')]"));  // Relative Xpath

	@FindBy(xpath="/html[1]/body[1]/div[3]/div[1]/ul[1]/li[15]/a[1]")
	@CacheLookup
	WebElement linkLogout;
	
	
	//  Action Method for username, password and submit
	public void setUserName(String uname)
	{
		txtUserName.sendKeys(uname);
	}
	
	public void setPassword(String pwd)
	{
		txtPassword.sendKeys(pwd);
	}
	
	public void ClickSubmit()
	{
		btnLogin.click();
	}
	
	public void clickLogout()
	{
		linkLogout.click();
	}
	
}
