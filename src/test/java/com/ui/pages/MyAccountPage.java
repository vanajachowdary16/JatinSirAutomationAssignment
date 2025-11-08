package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public class MyAccountPage extends BrowserUtility{
	private static final By USERNAME_LOCATOR = By.xpath("//a[@title='View my customer account']/span");
	private static final By SEARCH_BOX_LOCATOR_BY= By.id("search_query_top");
	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
	
	public String getUserName() {
		return getVisibleText(USERNAME_LOCATOR);	}
	
	public SearchResultsPage searchForProduct(String productName) {
		enterText(SEARCH_BOX_LOCATOR_BY, productName);
		enterSpecialKey(SEARCH_BOX_LOCATOR_BY, Keys.ENTER);
		SearchResultsPage searchResultsPage = new SearchResultsPage(getDriver());
		return searchResultsPage;
	}

}
