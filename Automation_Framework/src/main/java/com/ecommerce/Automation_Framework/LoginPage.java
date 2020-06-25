package com.ecommerce.Automation_Framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class LoginPage extends BasePage{
	
	By loginButton = By.id("login2");
	By username = By.id("loginusername");
	By password = By.id("loginpassword");
	By submitButton = By.xpath("//button[@class='btn btn-primary' and text()='Log in']");
	
	By logout = By.id("logout2");
	
	public LoginPage(WebDriver driver)
	{
		super(driver);
	}
	
	//Login
	public void doLogin() throws IOException
	{
		click(loginButton);
		
		//Getting credentials from excel
		
		XSSFWorkbook wb = new XSSFWorkbook("D:\\E-Commerce\\Automation_Framework\\excel\\data.xlsx");
		XSSFSheet sheet = wb.getSheet("credentials");
		int rowCount = sheet.getPhysicalNumberOfRows();
		System.out.println(rowCount);
		
		XSSFRow row = sheet.getRow(1);
		XSSFCell cell1 = row.getCell(0);
		XSSFCell cell2 = row.getCell(1);
		
		String uname = cell1.toString();
		String pwd = cell2.toString();
		
		writeText(username, uname);
		writeText(password, pwd);
		click(submitButton);
	}
	
	public void doLogout()
	{
		click(logout);
	}

}
