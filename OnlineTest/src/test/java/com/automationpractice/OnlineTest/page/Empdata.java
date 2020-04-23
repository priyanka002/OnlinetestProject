package com.automationpractice.OnlineTest.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.automationpractice.core.BasePage;
import com.onlinetest.utility.ExcelLib;

public class Empdata extends BasePage {

	public Empdata(WebDriver driver) {
		super(driver);
	}

	By btnaddemp = By.xpath("//a[text()='Add Employee']");
	By btnsubmit = By.xpath("//*[@type='submit']");
	By btndlt = By.xpath("//span[text()='Delete Employee']");

	public void validation() {

		try {
			click(btnaddemp);
			Thread.sleep(2000);
			click(btnsubmit);
			String str = driver.findElement(By.xpath("//div[text()='First Name is required']")).getText();
			System.out.println(str);

			String str1 = driver.findElement(By.xpath("//div[text()='Last Name is required']")).getText();
			System.out.println(str1);

			String str2 = driver.findElement(By.xpath("//div[text()='Please select a title']")).getText();
			System.out.println(str2);

			String str3 = driver.findElement(By.xpath("//div[text()='Please select a project']")).getText();
			System.out.println(str3);

		} catch (InterruptedException e) {

			System.out.println("Exception" + e);
		}
	}

	public void delete() {
		try {
			Thread.sleep(2000);
			dltcode();
			String xpath = "//*[@class='card-title' and text()='Greg']";
			Boolean iselementpresent = driver.findElements(By.xpath(xpath)).size() != 0;
			if (iselementpresent == true) {
				System.out.print("Element Is Present On The Page");
			} else {
				System.out.print("Element Is Not Present On The Page");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addEmp() {
		try {

			ExcelLib reader = new ExcelLib("/Users/ADMIN/git/OnlinetestProject/OnlineTest/testdata.xlsx");
			int rowCount = reader.getRowCount("AddEmp");

			for (int rowNum = 2; rowNum <= rowCount; rowNum++) {

				click(btnaddemp);
				Thread.sleep(2000);
				
				String firstname = reader.getCellData("AddEmp", "First Name", rowNum);
				System.out.println(firstname);

				String lastname = reader.getCellData("AddEmp", "Last Name", rowNum);
				System.out.println(lastname);

				String drptitle = reader.getCellData("AddEmp", "Job title", rowNum);
				System.out.println(drptitle);

				String drpproject = reader.getCellData("AddEmp", "Current Project", rowNum);
				System.out.println(drpproject);

				driver.findElement(By.id("firstName")).sendKeys(firstname);

				driver.findElement(By.id("lastName")).sendKeys(lastname);

				Select select = new Select(driver.findElement(By.id("title")));
				select.selectByVisibleText(drptitle);

				Select select1 = new Select(driver.findElement(By.id("project")));
				select1.selectByVisibleText(drpproject);

				click(btnsubmit);
			}

		} catch (Exception e) {

			System.err.println("Exception found" + e);
		}

	}

	public void deleteemp() {

		try {

			Thread.sleep(2000);
			String str1 = driver.findElement(By.xpath("//*[@class='card-title' and text()='Greg']")).getText();
			String s = "Greg";
			String s0 = "Greg";
			System.out.println(str1);

			if (s.equalsIgnoreCase(s0)) {

				dltcode();
				System.out.println("Record No 1 deleted successfully");
			}

			Thread.sleep(2000);

			String str2 = driver.findElement(By.xpath("//*[@class='card-title' and text()='Carl']")).getText();
			System.out.println(str2);
			String s2 = "Carl";
			String s02 = "Carl";

			if (s2.equalsIgnoreCase(s02)) {

				dltcode();
				System.out.println("Record No 2 deleted successfully..!");
			}

			scrolldown();
			Thread.sleep(2000);

			String str3 = driver.findElement(By.xpath("//*[@class='card-title' and text()='Sunny']")).getText();
			System.out.println(str3);
			String s3 = "Sunny";
			String s03 = "Sunny";

			if (s3.equalsIgnoreCase(s03)) {

				dltcode();
				System.out.println("Record No 10 Deleted Successfully...!");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.print("Exception found" + e);
		}
	}

	public void dltcode() {

		try {
			click(btndlt);
			driver.switchTo().alert().accept();
			Thread.sleep(2500);

		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}

	public void scrolldown() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)", "");
	}
	
	public void confirmAdvertisement(){
		
		
		try {

			ExcelLib reader = new ExcelLib("/Users/ADMIN/git/OnlinetestProject/OnlineTest/testdata.xlsx");
			int rowCount = reader.getRowCount("AddEmp");

				for(int rowNum = 2; rowNum <=3; rowNum++){
					
					click(btnaddemp);
					Thread.sleep(2000);
					String firstname = reader.getCellData("AddEmp", "First Name", rowNum);
					System.out.println(firstname);

					String lastname = reader.getCellData("AddEmp", "Last Name", rowNum);
					System.out.println(lastname);

					String drptitle = reader.getCellData("AddEmp", "Job title", rowNum);
					System.out.println(drptitle);

					String drpproject = reader.getCellData("AddEmp", "Current Project", rowNum);
					System.out.println(drpproject);

					driver.findElement(By.id("firstName")).sendKeys(firstname);

					driver.findElement(By.id("lastName")).sendKeys(lastname);

					Select select = new Select(driver.findElement(By.id("title")));
					select.selectByVisibleText(drptitle);

					Select select1 = new Select(driver.findElement(By.id("project")));
					select1.selectByVisibleText(drpproject);
					click(btnsubmit);
				}
				
				boolean str=driver.findElement(By.xpath("//div[@class='advertisement']")).isDisplayed();
				if (str == true)
				   {
				    System.out.print("Advertisement appeared");
				   }
				   else
				   {
				    System.out.print("Advertisement does not appear");
				   }	

		} catch (Exception e) {

			System.err.println("Exception found" + e);
		}
	}
}
