package com.ui.pages;

import org.openqa.selenium.By;
import com.constants.Browser;
import static com.constants.Env.*;
import com.utility.BrowserUtility;
import static com.utility.PropertiesUtil.*;

public class HomePage extends BrowserUtility{
	
	public HomePage(Browser browserName) {
		super(browserName);
		goToWebSite(readProperty(QA, "URL"));
	}

	private static final By SIGN_IN_LOCATOR = By.className("login");
	
	public LoginPage goToLoginPage() {
	BrowserUtility.clickOn(SIGN_IN_LOCATOR);
	LoginPage loginpage = new LoginPage(getDriver());
	return loginpage;
	}
}
