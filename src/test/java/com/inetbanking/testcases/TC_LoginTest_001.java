package com.inetbanking.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.PageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass {

	@Test
	public void loginTest() throws IOException {
		
		logger.info("url opened");

		LoginPage login = new LoginPage(driver);
		login.enteruserName(username1);
		logger.info("enter username");
		login.enterpassword(password1);
		logger.info("enter vassword");
		login.clickloginBtn();
		logger.info("click on login button");

		//if (driver.getTitle().equals("OPEN SOURCE HR MANAGEMENT "))

		//{
			//Assert.assertTrue(true);
			//logger.info("display title");
		//} else {
		captureScreen(driver,"loginTest");
			//Assert.assertTrue(false);
			//logger.info("not display the title");
		//}

	}
}
