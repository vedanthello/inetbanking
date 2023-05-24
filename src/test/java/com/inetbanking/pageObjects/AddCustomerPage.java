package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {
	
    WebDriver driver;
	
	public AddCustomerPage(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="//a[@href='addcustomerpage.php']")
	WebElement linkAddCustomer;
	
	@FindBy(name="//input[@name='name']")
	WebElement customerName;

	@FindBy(name="//input[@name='rad1' and @value='m']")
	WebElement radioMale;
	
	@FindBy(name="//input[@name='rad1' and @value='f']")
	WebElement radioFemale;

	@FindBy(name="//input[@name='dob']")
	WebElement dateOfBirth;

	@FindBy(name="//input[@name='addr']")
	WebElement address;

	@FindBy(name="//input[@name='city']")
	WebElement city;

	@FindBy(name="//input[@name='state']")
	WebElement state;

	@FindBy(name="//input[@name='pinno']")
	WebElement pincode;
	
	@FindBy(name="//input[@name='telephoneno']")
	WebElement mobileNumber;
	
	@FindBy(name="//input[@name='emailid']")
	WebElement email;
	
	@FindBy(name="//input[@name='password']")
	WebElement password;
	
	@FindBy(name="//input[@name='sub']")
	WebElement submitButton;
	
	public void clickNewCustomer() {
		linkAddCustomer.click();
	}
	
	public void setCustomerName(String name) {
		customerName.sendKeys(name);
	}
	
	public void setGender(String gender) {
		
		if (gender == "male") {
			radioMale.click();
		} else if (gender == "female") {
			radioFemale.click();
		}
	}
	
	public void setDOB(String dd, String mm, String yyyy) {
		dateOfBirth.sendKeys(dd);
		dateOfBirth.sendKeys(mm);
		dateOfBirth.sendKeys(yyyy);		
	}
	
	public void setAddress(String addr) {
		address.sendKeys(addr);
	}
	
	public void setCity(String ci) {
		city.sendKeys(ci);
	}
	
	public void setState(String st) {
		state.sendKeys(st);
	}
	
	public void setPincode(String pc) {
		pincode.sendKeys(pc);
	}
	
	public void setMobileNumber(String mn) {
		mobileNumber.sendKeys(mn);
	}
	
	public void setEmail(String em) {
		email.sendKeys(em);
	}
	
	public void setPassword(String pwd) {
		password.sendKeys(pwd);
	}
	
	public void clickSubmit() {
		submitButton.click();
	}

	
	
}
