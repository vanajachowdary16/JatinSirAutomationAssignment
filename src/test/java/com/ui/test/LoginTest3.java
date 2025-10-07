package com.ui.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.ui.pages.HomePage;
import com.ui.pages.LoginPage;

public class LoginTest3 {
public static void main(String[] args) {
	WebDriver driver = new ChromeDriver();
	HomePage homepage = new HomePage(driver);
	String userName=homepage.goToLoginPage().doLoginWith("xidic56063@aupvs.com", "Test@123").getUserName();
	
	System.out.println(userName);
}
}
