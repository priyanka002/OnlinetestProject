package com.automationpractice.core;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BasePage {

	public WebDriver driver;
	private WebDriverWait wait;

	public BasePage(WebDriver driver) {
		this.driver = driver;
	}

	public String getPageUrl() {
		return driver.getCurrentUrl();
	}

	public String getTitle() {
		return driver.getTitle();
	}

	public String getPageSource() {
		return driver.getPageSource();
	}

	protected void click(By locator) {
		
		//wait.until(ExpectedConditions.elementToBeClickable(locator));
		getElement(locator).click();
	}
    protected void clear(By locator) {
		
		wait.until(ExpectedConditions.elementToBeClickable(locator));
		getElement(locator).clear();
	}
	protected void type(By locator,String textToType) {
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
		getElement(locator).sendKeys(textToType);
	}
	
	protected void TypeAndEnter(By locator,String textToType, Keys enter) {
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
		getElement(locator).sendKeys(textToType);
		getElement(locator).sendKeys(enter);
	}
	
	protected void selectByVisibleText(By locator, String visibleText) {
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		Select s = new Select(getElement(locator));
		s.selectByVisibleText(visibleText);
	}
//
//	protected void selectByValue(By locator, String value) {
//		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
//		Select s = new Select(getElement(locator));
//		s.selectByValue(value);
//	}
//
//	protected void selectByIndex(By locator, int index) {
//		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
//		Select s = new Select(getElement(locator));
//		s.selectByIndex(index);
//	}

	protected WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	protected WebDriver driver(){
		return driver;
	}
	protected <K extends BasePage> K getPageObject(Class<K> class1) {
		return PageFactory.initElements(driver(), class1);
	}
    public void switchwindow() throws InterruptedException{//added by priyanka
   	// Get Parent window handle
   	   String winHandleBefore = driver.getWindowHandle();
   	   for (String winHandle : driver.getWindowHandles()) {
   	     // Switch to child window
   	     driver.switchTo().window(winHandle);
   	   }

   	  // Do some operation on child window and get child window handle.
   	  String winHandleAfter = driver.getWindowHandle();

   	  //switch to child window of 1st child window.
   	  for(String winChildHandle : driver.getWindowHandles()) {
   	    // Switch to child window of the 1st child window.
   	    if(!winChildHandle.equals(winHandleBefore) 
   	    && !winChildHandle.equals(winHandleAfter)) {
   	      driver.switchTo().window(winChildHandle);
   	     }
   	   }
/*
   	  // Do some operation on child window of 1st child window.
   	  // to close the child window of 1st child window.
   	  driver.close();*/
   	  Thread.sleep(4000);
   	  // to close the child window.
   	  driver.close();

   	  // to switch to parent window.
   	  driver.switchTo().window(winHandleBefore);
   	  Thread.sleep(10000);
      }
    public void Pagescrolldown() throws InterruptedException, AWTException{//added by priyanka
		Robot robot1 = new Robot();//code for scrolling page down
		for(int i=0;i<=1;i++){robot1.keyPress(KeyEvent.VK_PAGE_DOWN); Thread.sleep(1000); }
	}
    public void Pagescrollup() throws InterruptedException, AWTException{//added by priyanka
		Robot robot1 = new Robot();//code for scrolling page up
		for(int i=0;i<=1;i++){  robot1.keyPress(KeyEvent.VK_PAGE_UP); Thread.sleep(1000); }
	}
}
