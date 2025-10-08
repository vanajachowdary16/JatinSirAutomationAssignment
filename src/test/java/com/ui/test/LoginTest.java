package com.ui.test;

import static com.constants.Browser.*;

import static org.testng.Assert.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ui.pages.HomePage;
import com.ui.pojo.User;

public class LoginTest {
	
	
	HomePage homepage;
	@BeforeMethod(description ="load the homepage of the website" )
	public void setUp(){
		 homepage = new HomePage(CHROME);
	}
	
//	@Test(description = "verifies with the valid user is able to login into the application"
//			, groups = {"e2e", "sanity"}, dataProviderClass  = com.dataproviders.LoginDataProvider.class, dataProvider = "LoginTestDataProvider" )
//	public void loginTest(User user) {
//		
//		String userName = homepage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getUserName();
//
//		System.out.println(userName);
//		assertEquals(userName, "Test automation");
//	}
//	
//	@Test(description = "verifies with the valid user is able to login into the application"
//			, groups = {"e2e", "sanity"}, dataProviderClass  = com.dataproviders.LoginDataProvider.class, dataProvider = "LoginTestCSVDataProvider" )
//	public void loginCSVTest(User user) {
//		
//		String userName = homepage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getUserName();
//
//		System.out.println(userName);
//		assertEquals(userName, "Test automation");
//	}
	@Test(description = "verifies with the valid user is able to login into the application"
			, groups = {"e2e", "sanity"}, dataProviderClass  = com.dataproviders.LoginDataProvider.class, dataProvider = "LoginTestExcelDataProvider" )
	public void loginExcelTest(User user) {
		
		String userName = homepage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getUserName();

		System.out.println(userName);
		assertEquals(userName, "Test automation");
	}
}
