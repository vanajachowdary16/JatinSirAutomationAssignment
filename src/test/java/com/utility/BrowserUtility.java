package com.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class BrowserUtility {
	private static WebDriver driver;

	public static WebDriver getDriver() {
		return driver;
	}
	public static void setDriver(WebDriver driver) {
		BrowserUtility.driver = driver;
	}
	public BrowserUtility(WebDriver driver) {
		super();
		this.driver = driver;//Initialize the instance variable driver!!!
	}
	public static void goToWebSite(String url) {
		driver.get(url);
		
	}
	public static void maximizeWindow() {
		driver.manage().window().maximize();
	}
	public static void clickOn(By locator) {
		WebElement element = driver.findElement(locator);
		element.click();
		
	}
	public void enterText(By locator, String text) {
		WebElement element = driver.findElement(locator);
		element.sendKeys(text);
		
	}
	public String getVisibleText(By locator) {
		WebElement element = driver.findElement(locator);
		return element.getText();
		
	}
}
