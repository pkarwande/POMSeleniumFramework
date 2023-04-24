package com.ecommerce.Automation_Framework;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
//import com.sun.mail.imap.Utility;

public class BaseTest {
	
	//This is test class

public WebDriver driver;
	
	@BeforeMethod
	public  void setUp() throws InterruptedException, IOException {
		Properties prop = new Properties();
		InputStream input = new FileInputStream("D:\\E-Commerce\\Automation_Framework\\config.properties");
		prop.load(input);
		prop.getProperty("browser");
		if(prop.getProperty("browser").equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Prachiti karwande\\Downloads\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else 
		{
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\Prachiti karwande\\Downloads\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		String baseURL = "https://www.demoblaze.com/index.html";
		driver.get(baseURL);
		Thread.sleep(10000);
	}
	
	@AfterMethod
	public void tearDown(ITestResult result)
	{
		if(ITestResult.FAILURE==result.getStatus())
		{
			Utility.captureScreenshot(driver, result.getName());
		}		
		driver.quit();
	}
}


