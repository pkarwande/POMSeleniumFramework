package com.ecommerce.Automation_Framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	
	//This is BasePage for demoB branch
	
	WebDriver driver;
	WebDriverWait wait;
	
	public BasePage(WebDriver driver) {
		this.driver = driver;
	wait = new WebDriverWait(driver, 30);
    }

	//Wait
	public void waitUntil(By element)
	{
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(element));
	}

	//Click
	public void click (By element) {
		waitUntil(element);
        driver.findElement(element).click();
    }
 
    //Write Text String
    public void writeText (By element, String text) {
    	waitUntil(element);
        driver.findElement(element).sendKeys(text);
    }
    
 
    //Read Text
    public String readText (By element) {
    	waitUntil(element);
        return driver.findElement(element).getText();
    }
}
