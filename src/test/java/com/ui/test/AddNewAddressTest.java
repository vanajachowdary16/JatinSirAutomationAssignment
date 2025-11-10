package com.ui.test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ui.pages.AddressPage;
import com.ui.pages.MyAccountPage;

public class AddNewAddressTest extends TestBase{
	private MyAccountPage myAccountPage;
	private AddressPage addressPage;
	
	@BeforeMethod
	public void setUp() {
		myAccountPage=homePage.goToLoginPage().doLoginWith("xidic56063@aupvs.com", "Test@123");
		
	}
	
	@Test
	public void addNewAddress() {
		addressPage=myAccountPage.goToAddAddressPage();
		
		
	}

}
