package com.automationpractice.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.automationpractice.config.Constants;


public class DriverManager {
	static WebDriver getDriver(String browserName) {
		WebDriver driver = null;
		System.out.println("Starting...:" + browserName);

			switch (browserName.toUpperCase()) {
			case "FIREFOX":
				System.setProperty("webdriver.gecko.driver", Constants.GECKO_DRIVER_PATH);
				driver = new FirefoxDriver();
				break;

			case "CHROME":
				System.setProperty("webdriver.chrome.driver", Constants.CHROME_DRIVER_PATH);
				driver = new ChromeDriver();
				break;
				
			case "Internet Explorer":
			    System.setProperty("webdriver.ie.driver", Constants.IE_DRIVER_PATH);
			    break;
			    
			default:
				throw new UnsupportedOperationException("Unsupported Browser: " + browserName);

			}
		
		return driver;
	}
}
