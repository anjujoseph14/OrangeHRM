package com.OrangeHRM.tests;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.OrangeHRM.Utilities.BrowserFactory;
import com.OrangeHRM.Utilities.ConfigReader;
import com.OrangeHRM.pages.LoginPage;
import java.time.Duration;
public class OrangeHRMLoginTest {
	WebDriver driver;
	LoginPage loginPage;

    @BeforeClass
    public void setup() {
    	 // Launch browser using BrowserFactory and navigate to URL
        driver = BrowserFactory.getDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get(ConfigReader.get("url"));
        loginPage = new LoginPage(driver);
    }

   
	@Test
    public void loginTest() {
    
        // Login using credentials from config.properties
            loginPage.login(
                ConfigReader.get("username"),
                ConfigReader.get("password"));
                System.out.println("Login test executed successfully.");
             
            
    }

    @AfterClass
    public void teardown() {
    	BrowserFactory.quitDriver();
        
    }

}
