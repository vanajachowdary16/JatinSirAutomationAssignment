package com.ui.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import com.constants.Browser;
import static com.constants.Env.*;
import com.utility.BrowserUtility;
import com.utility.JsonUtility;
import com.utility.loggerUtility;

public class HomePage extends BrowserUtility{
	Logger logger = loggerUtility.getLogger(this.getClass());
	BrowserUtility browserUtility;
	public HomePage(Browser browserName) {
		super(browserName);
		goToWebSite(JsonUtility.readJson(QA).getUrl());
		
	}

	private static final By SIGN_IN_LOCATOR = By.className("login");
	public LoginPage goToLoginPage() {
		logger.info("clicking on sign in button");
	browserUtility.clickOn(SIGN_IN_LOCATOR);
	LoginPage loginpage = new LoginPage(getDriver());
	return loginpage;
	}
}
