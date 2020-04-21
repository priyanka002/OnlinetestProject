package com.automation.OnlineTes.test;

import org.testng.annotations.Test;

import com.automationpractice.OnlineTest.page.Empdata;
import com.automationpractice.core.BaseTest;

public class TC_02 extends BaseTest{

	@Test(priority=1,enabled=true)
	public void TC02(){
		Empdata e=new Empdata(driver);
		e.delete();
	}
}
