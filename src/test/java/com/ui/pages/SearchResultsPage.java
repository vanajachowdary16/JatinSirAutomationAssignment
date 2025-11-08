package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public class SearchResultsPage extends BrowserUtility{
	
	private static final By PRODUCT_LISTING_TITLE_LOCATOR= By.xpath("//span[@class='lighter']");
	private static final By ALL_PRODUCTS_LISTS_NAME = By.xpath("//h5[@itemprop='name']/a");

	public SearchResultsPage(WebDriver driver) {
		super(driver);
		
	}
	
	public String getsearchResultTitle() {
		return getVisibleText(PRODUCT_LISTING_TITLE_LOCATOR);
	}
	public void getAllProductsNames() {
		getAllVisibleText(ALL_PRODUCTS_LISTS_NAME);
		
	}

}
