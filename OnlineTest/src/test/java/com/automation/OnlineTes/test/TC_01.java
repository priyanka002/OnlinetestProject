package com.automation.OnlineTes.test;

import org.testng.annotations.Test;

import com.automationpractice.OnlineTest.page.Empdata;
import com.automationpractice.core.BaseTest;

public class TC_01 extends BaseTest{

	@Test(priority=1,enabled=true)
	public void TC01(){
		
		Empdata e=new Empdata(driver);
		logger = extent.createTest("Check validation message");
		logger.info("Verify validation message");
		logger.pass("Verified successfully");
		e.validation();
		
	}
	
	@Test(priority=2,enabled=true)
	public void TC02(){
		Empdata e=new Empdata(driver);
		logger = extent.createTest("Delete employee record");
		logger.info("Verify record got deleted");
		logger.pass("Verified successfully");
		e.delete();
	}
	
	@Test(priority=3,enabled=true)
	public void TC03(){
		
		Empdata e= new Empdata(driver);
		logger = extent.createTest("To verify add employee and delete specific employee");
		e.addEmp();
		e.deleteemp();		
	}
	
	@Test(priority=4,enabled=true)
	public void TC04(){
		
		Empdata e= new Empdata(driver);
		logger = extent.createTest("To verify advertisement");
		e.confirmAdvertisement();
	}
}
