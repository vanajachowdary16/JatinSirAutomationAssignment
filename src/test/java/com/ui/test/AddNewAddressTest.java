package com.ui.test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ui.pages.AddressPage;
import com.ui.pages.MyAccountPage;
import com.ui.pojo.AddressPojo;
import com.utility.FakeAddressUtility;

public class AddNewAddressTest extends TestBase{
	private MyAccountPage myAccountPage;
	private AddressPage addressPage;
	private AddressPojo addressPojo;
	@BeforeMethod
	public void setUp() {
		myAccountPage=homePage.goToLoginPage().doLoginWith("xidic56063@aupvs.com", "Test@123");
		addressPojo = FakeAddressUtility.getFakeAddress();
	}
	
	@Test
	public void addNewAddress() {
		myAccountPage.goToAddAddressPage().saveAddress(addressPojo);
		
		
	}

}
