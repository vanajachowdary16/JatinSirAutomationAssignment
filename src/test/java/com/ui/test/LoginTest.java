package com.ui.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.utility.BrowserUtility;

public class LoginTest {
public static void main(String[] args) {
	WebDriver driver = new ChromeDriver();
	BrowserUtility browserutility = new BrowserUtility(driver);
	browserutility.goToWebSite("http://www.automationpractice.pl/index.php");
	browserutility.maximizeWindow();
	
	By signInLocator = By.className("login");
	browserutility.clickOn(signInLocator);
	
	By emailTextboxLocator = By.id("email");
	browserutility.textToEnter(emailTextboxLocator, "xidic56063@aupvs.com");
	By passwordLocator = By.id("passwd");
	browserutility.textToEnter(passwordLocator, "Test@123");
	By submitLoginButtonLocator = By.id("SubmitLogin");
	browserutility.clickOn(submitLoginButtonLocator);
	
}
}
