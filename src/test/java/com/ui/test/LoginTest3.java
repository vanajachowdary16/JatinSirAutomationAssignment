package com.ui.test;

import com.constants.Browser;
import com.ui.pages.HomePage;
import com.utility.BrowserUtility;

public class LoginTest3 {
public static void main(String[] args) {
	HomePage homepage = new HomePage(Browser.CHROME);
	String userName=homepage.goToLoginPage().doLoginWith("xidic56063@aupvs.com", "Test@123").getUserName();
	
	System.out.println(userName);
}
}
