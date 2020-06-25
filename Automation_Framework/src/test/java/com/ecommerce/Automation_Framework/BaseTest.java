package com.ecommerce.Automation_Framework;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {

public WebDriver driver;
	
	@BeforeTest
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
	
	/*@AfterTest
	public void tearDown()
	{
		driver.quit();
	}*/
}
