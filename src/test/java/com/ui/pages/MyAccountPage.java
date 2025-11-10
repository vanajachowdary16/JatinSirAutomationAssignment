package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By.ByName;

import com.utility.BrowserUtility;

public class MyAccountPage extends BrowserUtility{
	private static final By USERNAME_LOCATOR = By.xpath("//a[@title='View my customer account']/span");
	private static final By SEARCH_BOX_LOCATOR_BY= By.id("search_query_top");
	private static final By ADD_NEW_ADDRESS_LOCATOR= By.xpath("//a[@title='Add my first address']");
	
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
	
	public AddressPage goToAddAddressPage() {
		clickOn(ADD_NEW_ADDRESS_LOCATOR);
		AddressPage addressPage= new AddressPage(getDriver());
		return addressPage;
	}

}
