package com.ui.test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ui.listeners.TestListener;
import com.ui.pages.MyAccountPage;

@Listeners({TestListener.class })
public class SearchProductTest extends TestBase{
	private MyAccountPage myAccountPage;
	public static final String SEARCH_TERM="printed summer dress";
	
	@BeforeMethod
	public void setUp() {
		myAccountPage=homePage.goToLoginPage().doLoginWith("xidic56063@aupvs.com", "Test@123");
		
	}
	
	@Test(description = "verify if the user is able to search for a product and correct search results are displayed",
			groups= {"e2e", "smoke", "sanity", "regression"})
	public void verifyProductSearchTest() {
		boolean actualResult=myAccountPage.searchForProduct(SEARCH_TERM).isSearchTermPresentinProductsList(SEARCH_TERM);
		Assert.assertEquals(actualResult, true);
	
		
		
	}

}
