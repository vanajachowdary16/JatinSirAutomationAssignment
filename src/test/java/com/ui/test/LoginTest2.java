package com.ui.test;

import com.constants.Browser;
import com.ui.pages.HomePage;
import com.ui.pages.LoginPage;

public class LoginTest2 {
public static void main(String[] args) {
	HomePage homepage = new HomePage(Browser.CHROME);
	LoginPage loginPage =homepage.goToLoginPage();
	loginPage.doLoginWith("xidic56063@aupvs.com", "Test@123");
	
	
}
}
