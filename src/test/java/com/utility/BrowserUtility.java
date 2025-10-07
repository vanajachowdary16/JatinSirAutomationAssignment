package com.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.constants.Browser;

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
	public BrowserUtility(String browserName) {
		if(browserName.equalsIgnoreCase("chrome")) {
			driver= new ChromeDriver();
		}else if(browserName.equalsIgnoreCase("edge")) {
			driver= new EdgeDriver();
		}else {
			System.err.println("Invalid browser anme .... please select chrome or edge only");
		}
	}
	public BrowserUtility(Browser browserName) {
		if(browserName==Browser.CHROME) {
			driver= new ChromeDriver();
		}else if(browserName == Browser.EDGE) {
			driver= new EdgeDriver();
		}else {
			System.err.println("Invalid browser anme .... please select chrome or edge only");
		}
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
