package com.OrangeHRM.Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;


import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserFactory {
    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            String browser = ConfigReader.get("browser");
            System.out.println("Launching browser: " + browser);

            switch (browser.toLowerCase()) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "edge":
                	  WebDriverManager.edgedriver().setup();
                	    EdgeOptions options = new EdgeOptions();
                	    options.addArguments("--remote-allow-origins=*");
                	    options.addArguments("--no-sandbox");
                	    options.addArguments("--disable-dev-shm-usage");
                	    driver = new EdgeDriver(options);
                	    break;
                    //WebDriverManager.edgedriver().setup();
                   // driver = new EdgeDriver();
                   // break;
                default:
                    throw new RuntimeException("Unsupported browser: " + browser);
            }
            driver.manage().window().maximize();

        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
