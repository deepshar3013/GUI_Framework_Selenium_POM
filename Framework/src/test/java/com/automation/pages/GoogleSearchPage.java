package com.automation.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

public class GoogleSearchPage 
{
	WebDriver driver;
	
	
	public GoogleSearchPage(WebDriver ldriver)
	{
		this.driver=ldriver;
	}

	@FindBy(id="email") WebElement emailId;
	@FindBy(id="pass") WebElement password;
	@FindBy(name="login") WebElement submit;
	
	public  void search(String fEmail, String fPass)
	{
		emailId.sendKeys(fEmail);
		password.sendKeys(fPass);
		
		
       submit.click();
       
       
	}
	
}
