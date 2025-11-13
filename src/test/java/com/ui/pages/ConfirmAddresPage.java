package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public class ConfirmAddresPage extends BrowserUtility {
	
	private static final By PROCEED_TO_CHECKOUT_LOCATOR= By.name("processAddress");
	
	public ConfirmAddresPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public ShippmentPage goToShippmentPage() {
		clickOn(PROCEED_TO_CHECKOUT_LOCATOR);
		return new ShippmentPage(getDriver());
	}

}
