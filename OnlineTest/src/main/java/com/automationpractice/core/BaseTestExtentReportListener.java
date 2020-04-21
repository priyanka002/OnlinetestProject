package com.automationpractice.core;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.automationpractice.config.Constants;



public class BaseTestExtentReportListener {

	private WebDriver driver;

	protected String browserName = Constants.DEFAULT_BROWSER;

	@BeforeMethod
	public void launchBrowser() {
	//	ExtentTestNGITestListener.test.get().info("Launching browser url");
		driver = DriverManager.getDriver(browserName);
		driver.manage().timeouts().implicitlyWait(Constants.IMPLICITLY_WAIT_TIMEOUT, TimeUnit.SECONDS);
	}

	@AfterMethod(alwaysRun = true)
	public void close(ITestResult testResult) {

		if (driver != null) {
			driver.quit();
		}
	}

	protected WebDriver driver() {
		return driver;
	}

	protected void openUrl(String url) {
		driver().get(url);
	}

	protected <T extends BasePage> T getPageObject(Class<T> class1) {

		return PageFactory.initElements(driver(), class1);
	}

}
