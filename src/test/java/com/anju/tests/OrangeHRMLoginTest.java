package com.anju.tests;
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
public class OrangeHRMLoginTest {
	WebDriver driver;

    @BeforeClass
    public void setup() {
    	System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") + "/drivers/msedgedriver.exe");
        //System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
    	 EdgeOptions options = new EdgeOptions();
    	 driver = new EdgeDriver(options);
        //driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @SuppressWarnings("deprecation")
	@Test
    public void loginTest() {
        driver.get("https://opensource-demo.orangehrmlive.com/");
        driver.findElement(By.name("username")).sendKeys("Admin");
        driver.findElement(By.name("password")).sendKeys("admin123");
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();

        String dashboardHeader = driver.findElement(By.tagName("h1")).getText();
        Assert.assertEquals(dashboardHeader, "Dashboard");
    }

    @AfterClass
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
