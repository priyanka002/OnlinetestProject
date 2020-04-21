package com.automationpractice.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class BaseTest {

	protected WebDriver driver;
	@BeforeMethod
	public void launchBrowser() {
		
		System.setProperty("webdriver.chrome.driver","D:\\Drivers\\chromedriver.exe");
        driver= new ChromeDriver(); 
        driver.get("http://medscape-live-qa-hw.k8s.medscape.com/");
        driver.manage().window().maximize();
        
	}
	@AfterClass
	public void getreport(){

		ExtentHtmlReporter reporter= new ExtentHtmlReporter("./Report/Onlinetest.html");
		ExtentReports extent= new ExtentReports();
		extent.attachReporter(reporter);
		extent.flush();
	}
	
	@AfterMethod
	public void teardown(){
		
		driver.close();
	}
	
	
}