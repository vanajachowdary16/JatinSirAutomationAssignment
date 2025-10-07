package com.ui.test;

import static com.constants.Browser.*;
import com.ui.pages.HomePage;

public class LoginTest3 {
public static void main(String[] args) {
	HomePage homepage = new HomePage(CHROME);
	String userName=homepage.goToLoginPage().doLoginWith("xidic56063@aupvs.com", "Test@123").getUserName();
	
	System.out.println(userName);
}
}
