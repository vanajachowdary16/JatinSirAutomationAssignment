package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.constants.Browser;
import com.utility.BrowserUtility;

public class HomePage extends BrowserUtility{
	
	public HomePage(Browser browserName) {
		super(browserName);
		goToWebSite("http://www.automationpractice.pl/index.php");
	}

	private static final By SIGN_IN_LOCATOR = By.className("login");
	
	public LoginPage goToLoginPage() {
	BrowserUtility.clickOn(SIGN_IN_LOCATOR);
	LoginPage loginpage = new LoginPage(getDriver());
	return loginpage;
	}
}
