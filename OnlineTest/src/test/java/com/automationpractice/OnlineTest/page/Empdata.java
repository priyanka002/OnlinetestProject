package com.automationpractice.OnlineTest.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.automationpractice.core.BasePage;
import com.onlinetest.utility.ExcelLib;

public class Empdata extends BasePage{

	public Empdata(WebDriver driver) {
		super(driver);
	}

	By btnaddemp =By.xpath("//a[text()='Add Employee']");
	By btnsubmit=By.xpath("//*[@type='submit']");
	
	
	public void validation(){
			
		try {
			//click(btnaddemp);
			driver.findElement(By.xpath("//a[text()='Add Employee']")).click();
			Thread.sleep(2000);
			//click(btnsubmit);
			driver.findElement(By.xpath("//*[@type='submit']")).click();
			String str=driver.findElement(By.xpath("//div[text()='First Name is required']")).getText();
			System.out.println(str);
			
			String str1=driver.findElement(By.xpath("//div[text()='Last Name is required']")).getText();
			System.out.println(str1);
			
			String str2=driver.findElement(By.xpath("//div[text()='Please select a title']")).getText();
			System.out.println(str2);
			
			String str3=driver.findElement(By.xpath("//div[text()='Please select a project']")).getText();
			System.out.println(str3);
			
			
		} catch (InterruptedException e) {
			
			System.out.println("Exception" + e);
		}
	}
	
	public void delete(){
		try{
		driver.findElement(By.xpath("//span[text()='Delete Employee']")).click();
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
		String xpath="//span[text()='Delete Employee']";
		Boolean iselementpresent = driver.findElements(By.xpath(xpath)).size()!= 0;
		if (iselementpresent == true)
		   {
		    System.out.print("Element Is Present On The Page");
		   }
		   else
		   {
		    System.out.print("Element Is Not Present On The Page");
		   }
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void addEmp(){
		try{
			driver.findElement(By.xpath("//a[text()='Add Employee']")).click();
			Thread.sleep(2000);
			
		ExcelLib reader= new ExcelLib("/OnlineTest/testdata.xlsx");
		int rowCount= reader.getRowCount("AddEmp");
		
		for(int rowNum=2;rowNum<=rowCount;rowNum++){
			
			String firstname=reader.getCellData("AddEmp","First Name", rowNum);
			System.out.println(firstname);
			
			String lastname=reader.getCellData("AddEmp","Last Name", rowNum);
			System.out.println(lastname);
			
			String drptitle=reader.getCellData("AddEmp","Job title", rowNum);
			System.out.println(drptitle);
			
			String drpproject=reader.getCellData("AddEmp","Current Project", rowNum);
			System.out.println(drpproject);
			
			driver.findElement(By.id("firstName")).sendKeys(firstname);
			
			driver.findElement(By.id("lastName")).sendKeys(lastname);
			
			Select select= new Select(driver.findElement(By.id("title")));
			select.selectByVisibleText(drptitle);
			
			Select select1= new Select(driver.findElement(By.id("project")));
			select1.selectByVisibleText(drpproject);
			
			driver.findElement(By.xpath("//*[@type='submit']")).click();
	}
		String str="//div[@class='card-body']//h5[@class='card-title']";
			if(str.matches(str)){
				delete();
			}
		
		}
		catch(Exception e){
			
			System.err.println("Exception found" + e);
		}
			
		}		
	
	public void add2emp(){
		
		for(int i=0;i<=2;i++){
			
			addEmp();
		}
		boolean str=driver.findElement(By.xpath("//div[@class='advertisement']")).isDisplayed();
		if (str == true)
		   {
		    System.out.print("Element Is Present On The Page");
		   }
		   else
		   {
		    System.out.print("Element Is Not Present On The Page");
		   }
		
	}
	
	public void delete_Emp(){
		
		
	}
	
	}




