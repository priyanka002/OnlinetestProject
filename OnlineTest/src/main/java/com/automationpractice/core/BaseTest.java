package com.automationpractice.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.onlinetest.utility.ScreenshotClass;

public class BaseTest {

	 public ExtentHtmlReporter htmlReporter;
	 public ExtentReports extent;
	 public ExtentTest logger;
	
	protected WebDriver driver;
	@BeforeMethod
	public void launchBrowser() {
		
		System.setProperty("webdriver.chrome.driver","D:\\Drivers\\chromedriver.exe");
        driver= new ChromeDriver(); 
        driver.get("http://medscape-live-qa-hw.k8s.medscape.com/");
        driver.manage().window().maximize();
        
	}
	
	@BeforeMethod
	
	 public void startReport() {
	
	 htmlReporter = new ExtentHtmlReporter("./Report/MyReports.html");
		
	    extent = new ExtentReports();
	    
	    extent.attachReporter(htmlReporter);
	     
	 }

	 @AfterMethod
		public void getResult(ITestResult result) throws Exception{
		 
		 
		 if(result.getStatus()==ITestResult.FAILURE)
			{
			 String temp=ScreenshotClass.getScreenshot(driver);
				logger.fail(result.getThrowable().getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
			}
			extent.flush();
			driver.quit();
		}
	
	 @AfterMethod
	 public void closebrowers(){
		 driver.quit();
	 }
	 
	 
	
}	