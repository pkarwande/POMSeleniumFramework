package com.ecommerce.Automation_Framework;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
	
	By contact =By.xpath("//a[@class='nav-link' and text()='Contact']");
	By contactEmail = By.id("recipient-email");
	By contactName = By.id("recipient-name");
	By contactMessage = By.id("message-text");
	By sendMessage = By.xpath("//button[@class='btn btn-primary' and text()='Send message']");
	
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	public void sendMessageToContact(String cemail, String cname, String smessage) throws InterruptedException
	{
		
		Thread.sleep(5000);
		click(contact);
		writeText(contactEmail, cemail);
		writeText(contactName, cname);
		writeText(contactMessage, smessage);
		click(sendMessage);
		Thread.sleep(5000);
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}
	
}
