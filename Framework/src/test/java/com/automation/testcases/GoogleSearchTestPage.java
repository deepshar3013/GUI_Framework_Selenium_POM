package com.automation.testcases;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.automation.pages.BaseClass;
import com.automation.pages.GoogleSearchPage;
import com.automation.utilties.*;

public class GoogleSearchTestPage extends BaseClass
{

	@Test
	public void searchTextBox()
       {
		logger=reports.createTest("Login to Facebook");
   	  GoogleSearchPage searchPage =PageFactory.initElements(driver, GoogleSearchPage.class);
   	  logger.info("Starting application");
    searchPage.search(excel.getStringData("Login", 0, 0),excel.getStringData("Login",0,1));
         
       	logger.pass("Login done sucessfully");
    	  System.out.println(driver.getTitle());
    	  
    	  Reporter.log("Test is executing" ,true);
         
       }
	
	


}
