package com.automationpractice.config;

public class Constants {

	public static final String GECKO_DRIVER_PATH = "D:\\Drivers\\geckodriver.exe";
	public static final String CHROME_DRIVER_PATH = "D:\\Drivers\\chromedriver.exe";
	public static final String IE_DRIVER_PATH = "D:\\Drivers\\MicrosoftWebDriver.exe";
	public static final String DEFAULT_BROWSER = System.getProperty("browser_name","chrome");
	public static final boolean GRID_ON = Boolean.parseBoolean(System.getProperty("grid-on","false"));
	public static final long IMPLICITLY_WAIT_TIMEOUT = 30;
	public static final long EXPLICIT_TIMEOUT = 60;
	public static final String REPORT_FILE_NAME = "TestReport.html";
	public static final String SNAPS_PATH="snaps/";
	//public static final String HUB_URL = "http://192.168.0.113:4444/wd/hub";
	public static final String url="http://automationpractice.com/index.php";
}
