package com.OrangeHRM.Base;

	import com.OrangeHRM.Utilities.ConfigReader;
	import com.OrangeHRM.LoginPage;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.testng.annotations.*;

	public class BaseTest {
	    public WebDriver driver;
	    public com.OrangeHRM.LoginPage loginPage;

	    @BeforeClass
	    public void setUp() {
	        // Read config values
	        String url = ConfigReader.get("baseUrl");
	        String username = ConfigReader.get("username");
	        String password = ConfigReader.get("password");

	        // Launch browser
	        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
	        driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        driver.get(url);

	        // Login
	        loginPage = new LoginPage(driver);
	        loginPage.login(username, password);
	    }

	    @AfterClass
	    public void tearDown() {
	        driver.quit();
	    }
	}



