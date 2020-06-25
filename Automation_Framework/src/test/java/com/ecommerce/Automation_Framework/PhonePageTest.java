package com.ecommerce.Automation_Framework;

import java.io.IOException;
import org.testng.annotations.Test;

public class PhonePageTest extends BaseTest{
	
	@Test
	public void orderPhone() throws IOException, InterruptedException{
		try {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.doLogin();
		PhonePage phonePage = new PhonePage(driver);
		phonePage.addIphoneToCart();
		phonePage.placeOrderForPhone();
		}
	catch (Exception e) {
		e.printStackTrace();
	}
}
}
