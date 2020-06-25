package com.ecommerce.Automation_Framework;

import java.io.IOException;

import org.testng.annotations.Test;


public class LoginTest extends BaseTest {
	
	@Test
	public void verifyLogin() throws IOException {
	
	LoginPage login = new LoginPage(driver);
	
	login.doLogin();
	
	}
}
