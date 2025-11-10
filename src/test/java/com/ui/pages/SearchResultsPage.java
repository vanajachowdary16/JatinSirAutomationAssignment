package com.ui.pages;

import java.util.Arrays;
import java.util.List;
import java.util.jar.Attributes.Name;

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
	public boolean isSearchTermPresentinProductsList(String searchTerm) {
		
		List<String> keyWords = Arrays.asList(searchTerm.toLowerCase().split(" "));
		List<String> productNamesList =getAllVisibleText(ALL_PRODUCTS_LISTS_NAME);
		
		boolean result =productNamesList.stream().anyMatch(name ->(keyWords.stream().anyMatch(name.toLowerCase()::contains)));
		
		return result;
	}

}
