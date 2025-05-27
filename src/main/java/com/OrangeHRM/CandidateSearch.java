package com.OrangeHRM;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;

	public class CandidateSearch {
	    WebDriver driver;

	    // Constructor
	    public CandidateSearch(WebDriver driver) {
	        this.driver = driver;
	    }

	    // Locators
	    private By recruitmentMenu = By.xpath("//span[text()='Recruitment']");
	    private By candidateNameInput = By.xpath("//label[contains(text(),'Candidate Name')]/following::input[1]");
	    private By searchButton = By.xpath("//button[@type='submit' and .='Search']");
	    private By resultRow = By.xpath("//div[@role='rowgroup']//div[contains(text(),'Linda Anderson')]");

	    // Actions
	    public void navigateToRecruitmentPage() {
	        driver.findElement(recruitmentMenu).click();
	    }

	    public void enterCandidateName(String name) {
	        driver.findElement(candidateNameInput).clear();
	        driver.findElement(candidateNameInput).sendKeys(name);
	    }

	    public void clickSearchButton() {
	        driver.findElement(searchButton).click();
	    }

	    public boolean isCandidatePresent(String name) {
	        try {
	            WebElement result = driver.findElement(resultRow);
	            return result.isDisplayed();
	        } catch (Exception e) {
	            return false;
	        }
	    }
	}

	


