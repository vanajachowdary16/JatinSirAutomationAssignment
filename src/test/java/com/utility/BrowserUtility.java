package com.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BrowserUtility {
	private WebDriver driver;

	public BrowserUtility(WebDriver driver) {
		super();
		this.driver = driver;//Initialize the instance variable driver!!!
	}
	public void goToWebSite(String url) {
		driver.get(url);
		
	}
	public void maximizeWindow() {
		driver.manage().window().maximize();
	}
	public void clickOn(By locator) {
		WebElement element = driver.findElement(locator);
		element.click();
		
	}
	public void textToEnter(By locator, String text) {
		WebElement element = driver.findElement(locator);
		element.sendKeys(text);
		
	}
}
