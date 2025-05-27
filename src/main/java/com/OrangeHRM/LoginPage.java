package com.OrangeHRM;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
//import java.util.concurrent.TimeUnit;
import java.time.Duration;

public class LoginPage {
	
	WebDriver driver;
	By Username=By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input");
	By Password=By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input");
	By Login=By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button");
	By Forgotpassword=By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[4]/p");
	
	public  LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	// Actions
    public void enterUsername(String username) {
        driver.findElement(Username).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(Password).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(Login).click();
    }
    public void clickforgotpswd()
    		{
    	driver.findElement(Forgotpassword);
    		}

    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }
    
}
