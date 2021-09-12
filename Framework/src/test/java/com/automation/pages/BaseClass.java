package com.automation.pages;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.util.SystemOutLogger;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.automation.utilties.BrowserFactory;
import com.automation.utilties.ConfigDataProvider;
import com.automation.utilties.ExcelDataProvider;
import com.automation.utilties.Helper;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentLoggerReporter;
import com.beust.jcommander.Parameter;


public class BaseClass 
{
	public WebDriver driver;
	public ExcelDataProvider excel;
	public ConfigDataProvider config;
	public ExtentReports reports;
	public ExtentTest logger;
	
	@SuppressWarnings("deprecation")
	@BeforeSuite
	public void SuiteSetup() throws FileNotFoundException
	{
		excel=new ExcelDataProvider();
		config=new ConfigDataProvider();
		ExtentHtmlReporter extent =new ExtentHtmlReporter(new File(System.getProperty("user.dir") +"/Reports/FaceBook+"+Helper.customDateFormat() +".html"));
		reports=new ExtentReports();
		reports.attachReporter(extent);
		Reporter.log("Set-Up ,Selenium is now starting",true);
		//help=new Helper();
	}
	@BeforeClass
	public void openBrowser()
	{
		driver=BrowserFactory.startApplication(driver,config.getBrowser(),config.getStagingURL());
		Reporter.log("Browser is open and run the application",true);
	}
	
	@AfterClass
	public void tearDown()
	{
		 BrowserFactory.quiteDriver(driver);
		 Reporter.log("Browser is closing now",true);
	}
	
	@AfterMethod
	public void tearDownMethod(ITestResult result)
	{
	
		try
		{
		if(result.getStatus()==ITestResult.FAILURE)
		{
				logger.fail("Test Failed",MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshots(driver)).build());
	
		}
		else if(result.getStatus()==ITestResult.SUCCESS)
		{
			logger.pass("Test passed",MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshots(driver)).build());
			
		}
		else if(result.getStatus()==ITestResult.SKIP)
		{
			logger.skip("Test skipped",MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshots(driver)).build());
			
		}
		}
		catch(Exception e)
		{
			System.out.println("Logger not printed properly");
		}
		reports.flush();
		Reporter.log("TestReportgenerated >>Report Generated",true);
		
	}
	

}
