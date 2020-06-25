package com.ecommerce.Automation_Framework;

import java.io.IOException;

import org.testng.annotations.Test;

public class HomePageTest extends BaseTest{

	@Test
	public void verifysendContactMessage() throws IOException, InterruptedException
	{
		LoginPage login = new LoginPage(driver);
		login.doLogin();
		HomePage homePage = new HomePage(driver);
		homePage.sendMessageToContact("test@gmail.com", "Test", "Message");
		login.doLogout();
	}

}
