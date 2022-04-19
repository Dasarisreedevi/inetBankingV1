package com.inetbanking.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(name = "txtUsername")
	WebElement username;

	@FindBy(name ="txtPassword")
	WebElement password;

	@FindBy(name = "Submit")
	WebElement login;

	@FindBy(name = "btnReset")
	WebElement reset;

	public void enteruserName(String uname) {
		username.sendKeys(uname);
	}

	public void enterpassword(String pwd) {
		password.sendKeys(pwd);
	}

	public void clickloginBtn() {
		login.click();
	}

	public void clickresetBtn() {
		reset.click();

	}

}
