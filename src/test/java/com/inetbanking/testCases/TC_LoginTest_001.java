package com.inetbanking.testCases;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass {
  
	@Test
	public void loginTest() {
		
//		ExtentReports extent = new ExtentReports();
//		ExtentSparkReporter spark = new ExtentSparkReporter("index.html");
//		extent.attachReporter(spark);

		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.setUserId(username);
		logger.info("username is entered");
		loginPage.setPassword(password);
		logger.info("password is entered");
		loginPage.clickSubmit();
		
		if (driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
	}
}
