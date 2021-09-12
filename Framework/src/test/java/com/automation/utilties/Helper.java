package com.automation.utilties;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Helper 
{

	//capturing  screenshots , windows handlers
	public static String captureScreenshots(WebDriver driver)
	{
		String screenshotPath=System.getProperty("user.dir")+"/Screenshots/LoginFacebook_"+ customDateFormat() +".png";
		File Screen=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileHandler.copy(Screen,new File(screenshotPath));
			
		} 
		catch (Exception e) 
		{
			
		System.out.println("Unable to capture Screenshot" +e.getMessage());
		}
		return screenshotPath;
		
		
	}
	
	public static String customDateFormat()
	{ 
		DateFormat customeDate=new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
		
		Date d=new Date();
		
		return customeDate.format(d);
	}
}
