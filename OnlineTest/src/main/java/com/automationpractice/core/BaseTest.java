package com.automationpractice.core;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.codehaus.plexus.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

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
	
	@BeforeTest
	 public void startReport() {
	 htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/Onlinetest.html");
	        	
	 extent = new ExtentReports();  
	 extent.attachReporter(htmlReporter);
	 extent.setSystemInfo("Host Name", "Priyanka");
	        	extent.setSystemInfo("Environment", "Test");
	 extent.setSystemInfo("User Name", "Priyanka");
	 htmlReporter.config().setDocumentTitle("Test Report"); 
	                // Name of the report
	 htmlReporter.config().setReportName("Online test Report"); 
	                // Dark Theme
	 htmlReporter.config().setTheme(Theme.STANDARD); 
	 }
	 
	 
	
	 @AfterMethod
		public void getResult(ITestResult result) throws Exception{
			if(result.getStatus() == ITestResult.FAILURE){
				
				logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
				logger.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));		
						
				logger.fail("Test Case Failed Snapshot is below " + logger.addScreenCaptureFromPath("/Users/ADMIN/git/OnlinetestProject/OnlineTest/Screenshots"));
			}
			else if(result.getStatus() == ITestResult.SKIP){
				logger.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + "Test Case Skipped", ExtentColor.ORANGE)); 
			} 
			else if(result.getStatus() == ITestResult.SUCCESS)
			{
				logger.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" Test Case PASSED", ExtentColor.GREEN));
			}
			driver.quit();
		}
 
	 
	@AfterTest
	public void teardown(){
		
		extent.flush();
		//driver.close();
	}
	
	
	/*@AfterClass
	public void getreport(){

		ExtentHtmlReporter reporter= new ExtentHtmlReporter("./Report/Onlinetest.html");
		ExtentReports extent= new ExtentReports();
		extent.attachReporter(reporter);
		extent.flush();
	}*/
}