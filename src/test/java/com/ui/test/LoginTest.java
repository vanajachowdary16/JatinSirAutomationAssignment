package com.ui.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.utility.BrowserUtility;

public class LoginTest {
public static void main(String[] args) {
	WebDriver driver = new ChromeDriver();
	
	driver.get("http://www.automationpractice.pl/index.php");
	driver.manage().window().maximize();
	By signInLocator = By.className("login");
	WebElement signInWebElement = driver.findElement(signInLocator);
	signInWebElement.click();
	By emailTextboxLocator = By.id("email");
	WebElement emailTextboxWebElement = driver.findElement(emailTextboxLocator);
	emailTextboxWebElement.sendKeys("xidic56063@aupvs.com");
	By passwordLocator = By.id("passwd");
	WebElement passwordWebElement = driver.findElement(passwordLocator);
	passwordWebElement.sendKeys("Test@123");
	By submitLoginButtonLocator = By.id("SubmitLogin");
	WebElement submitLoginWebElement = driver.findElement(submitLoginButtonLocator);
	submitLoginWebElement.click();
	
	
}
}
