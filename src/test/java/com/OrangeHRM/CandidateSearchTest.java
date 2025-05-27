package com.OrangeHRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.OrangeHRM.CandidateSearch;
import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import org.testng.annotations.*;

	public class CandidateSearchTest {
	    WebDriver driver;
	    public ExtentReports extent;
	    public ExtentTest test;
	   
	    
	    CandidateSearch candidatePage;

	    @BeforeClass
	    public void setUp() {
	        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
	        driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        driver.get("https://opensource-demo.orangehrmlive.com/");

	        // Login first
	        driver.findElement(By.name("username")).sendKeys("Admin");
	        driver.findElement(By.name("password")).sendKeys("admin123");
	        driver.findElement(By.cssSelector("button[type='submit']")).click();
	    }

	    @Test
	    public void verifyCandidateSearch() throws InterruptedException {
	        candidatePage = new CandidateSearch(driver);

	        // Navigate to Recruitment
	        candidatePage.navigateToRecruitmentPage();
	        Thread.sleep(3000); // Wait for page to load

	        // Search for candidate
	        candidatePage.enterCandidateName("Linda Anderson");
	        candidatePage.clickSearchButton();
	        Thread.sleep(3000); // Wait for results

	        // Verify
	        boolean found = candidatePage.isCandidatePresent("Linda Anderson");
	        Assert.assertTrue(found, "Candidate 'Linda Anderson' not found in search results.");
	    }

	    @AfterClass
	    public void tearDown() {
	        driver.quit();
	    }
	}



