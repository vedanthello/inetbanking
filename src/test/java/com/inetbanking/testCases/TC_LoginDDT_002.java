package com.inetbanking.testCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;
import com.inetbanking.utilities.XLUtils;

public class TC_LoginDDT_002 extends BaseClass {

	@Test (dataProvider="LoginData")
	public void loginDDT(String username, String password) throws InterruptedException {
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.setUserId(username);
		logger.info("username provided");
		loginPage.setPassword(password);
		loginPage.clickSubmit();
		Thread.sleep(2000);
		
		if (isAlertPresent()) {
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
		} else {
			Assert.assertTrue(true);
			loginPage.clickLogout();
			Thread.sleep(2000);
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
		}
	}
	
	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}
	
	@DataProvider(name="LoginData")
	String[][] getData() throws IOException{
		
		String path = System.getProperty("user.dir") + "/src/test/java/com/inetbanking/testData/loginData.xlsx";
		int rowCount = XLUtils.getRowCount(path, "Sheet1");
		int colCount = XLUtils.getCellCount(path, "Sheet1", 1);
		String loginData[][] = new String[rowCount][colCount];
		
		for (int row = 1; row <= rowCount; row++) {
			for (int col = 0; col <= (colCount - 1); col++) {
				loginData[row - 1][col] = XLUtils.getCellData(path, "Sheet1", row, col);
			}
		}
		
		return loginData;
		
	}
}
