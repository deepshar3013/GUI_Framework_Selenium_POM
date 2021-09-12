package com.automation.utilties;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory 
{
	
public static WebDriver startApplication(WebDriver driver,String browserName,String appURL)
{
	if(browserName.equals("chrome"))
	{
		System.setProperty("webdriver.chrome.driver", "C:/AutomationPractice/Framework/Drivers/newChrome/chromedriver.exe");
		driver=new ChromeDriver();
	}
	else if(browserName.equals("firefox"))
	{
		System.setProperty("webdriver.gecko.driver","C:/AutomationPractice/Framework/Drivers/geckodriver.exe");
		driver=new FirefoxDriver();
	}
	else
	{
		System.out.println("We dont support this driver");
	}
	
	driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
	driver.manage().window().maximize();
	driver.get(appURL);
	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	
	return driver;
	}

public static void quiteDriver(WebDriver driver)
{
	driver.quit();
	
	}

}
