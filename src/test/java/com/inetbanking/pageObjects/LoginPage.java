package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(name="uid")
	WebElement userId;
	
	@FindBy(name="password")
	WebElement password;

	@FindBy(name="btnLogin")
	WebElement loginButton;
	
	@FindBy(xpath="//a[@href='Logout.php']")
	WebElement logoutButton;
	
	public void setUserId(String uId) {
		userId.sendKeys(uId);
	}
	
	public void setPassword(String pwd) {
		password.sendKeys(pwd);
	}
	
	public void clickSubmit() {
		loginButton.click();
	}
	
	public void clickLogout() {
		logoutButton.click();
	}
	
	
}
