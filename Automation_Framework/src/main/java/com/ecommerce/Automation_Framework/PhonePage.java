package com.ecommerce.Automation_Framework;

import java.awt.Desktop.Action;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class PhonePage extends BasePage{

	By phones = By.xpath("//a[@id='itemc' and text()='Phones']");
	By iphone = By.xpath("//a[@class='hrefch' and text()='Iphone 6 32gb']");
	By addToCart = By.xpath("//a[@class='btn btn-success btn-lg' and text()='Add to cart']");
	By cart = By.xpath("//a[@class='nav-link' and text()='Cart']");
	By placeOrder = By.xpath("//button[@class='btn btn-success' and text()='Place Order']");
	By name = By.id("name");
	By country = By.id("country");
	By city = By.id("city");
	By creditCard = By.id("card");
	By month = By.id("month");
	By year = By.id("year");
	By purchase = By.xpath("//button[@class='btn btn-primary' and text()='Purchase']");
	By ok = By.xpath("//button[@class='confirm btn btn-lg btn-primary' and text()='OK']");
	
	
	public PhonePage(WebDriver driver) {
		super(driver);
	}
	
	public void addIphoneToCart() throws InterruptedException
	{
		Thread.sleep(5000);
		click(phones);
		click(iphone);
		click(addToCart);
		//Alert alert = driver.switchTo().alert();
		//alert.accept();
		click(cart);
	}
	
	public void placeOrderForPhone() throws InterruptedException
	{
		
		click(placeOrder);
		writeText(name, "James Smith");
		writeText(country, "India");
		writeText(city, "Banglore");
		writeText(creditCard, "65748464599");
		writeText(month, "July");
		writeText(year, "2020");
		click(purchase);
		click(ok);
		Thread.sleep(5000);
		Actions act = new Actions(driver);
		WebElement closeButton = driver.findElement(By.id("orderModal"));
		act.moveToElement(closeButton).build().perform();
		closeButton.click();
		
 }

}
