package com.ui.pages;

import static com.constants.Env.QA;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.constants.Browser;
import com.utility.BrowserUtility;
import com.utility.JsonUtility;
import com.utility.loggerUtility;


public final class HomePage extends BrowserUtility {
	Logger logger = loggerUtility.getLogger(this.getClass());

	private static final By SIGN_IN_LINK_LOCATOR = By.xpath("//a[contains(text(),\"Sign\")]");

	public HomePage(Browser browser, boolean isHeadless) {
		super(browser, isHeadless); // To Call the Parent Class constructor from the child constructor
		goToWebSite(JsonUtility.readJson(QA).getUrl());
	}

	public HomePage(WebDriver driver) {
		super(driver); // To Call the Parent Class constructor from the child constructor
		goToWebSite(JsonUtility.readJson(QA).getUrl());
	}

	public LoginPage goToLoginPage() { // Page Functions------> cannot use void!!!
		logger.info("Trying to performing click to go to Sign in Page");
		clickOn(SIGN_IN_LINK_LOCATOR);
		LoginPage loginPage = new LoginPage(getDriver());
		return loginPage;
	}

	public void quit() {
		// TODO Auto-generated method stub
		
	}
}