package com.ui.test;

import static com.constants.Browser.*;

import static org.testng.Assert.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ui.pages.HomePage;

public class LoginTest {
	
	
	HomePage homepage;
	@BeforeMethod(description ="load the homepage of the website" )
	public void setUp(){
		 homepage = new HomePage(CHROME);
	}
	
	@Test(description = "verifies with the valid user is able to login into the application"
			, groups = {"e2e", "sanity"})
	public void loginTest() {
		
		String userName = homepage.goToLoginPage().doLoginWith("xidic56063@aupvs.com", "Test@123").getUserName();

		System.out.println(userName);
		assertEquals(userName, "Test automation");
	}
}
