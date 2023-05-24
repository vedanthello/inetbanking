package com.inetbanking.testCases;

import java.time.Duration;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetbanking.utilities.ReadConfig;

public class BaseClass {
	
	ReadConfig readConfig = new ReadConfig(); 
    
	public String baseURL = readConfig.getApplicationURL();
    public String username = readConfig.getUsername();
    public String password = readConfig.getPassword();
    public static WebDriver driver;
    public static Logger logger;
    
    @Parameters("browser")
    @BeforeClass
    public void setup(String browser) {
    	    	
    	logger = Logger.getLogger("eBanking");
    	PropertyConfigurator.configure("Log4j.properties");
    	 	
    	if (browser.equals("chrome")) {
    		System.setProperty("webdriver.chrome.driver", readConfig.getChromePath());
        	driver = new ChromeDriver();	
    	} else if (browser.equals("firefox")) {
    		System.setProperty("webdriver.chrome.driver", readConfig.getFirefoxPath());
        	driver = new FirefoxDriver();	
    	}
    	
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    	driver.get(baseURL);
    	
    }
    
    @AfterClass
    public void tearDown() {
    	driver.quit();
    }
	
}
