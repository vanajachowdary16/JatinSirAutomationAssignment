package com.ui.test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.constants.Size.*;
import com.ui.pages.SearchResultsPage;

public class ProductCheckoutTest extends TestBase{
	
	public static final String SEARCH_TERM = "printed summer dress";
	private SearchResultsPage searchResultsPage;
	
	@BeforeMethod(description = "users loggs into the application and searches for a product")
	public void setUp() {
		searchResultsPage=	homePage.goToLoginPage().doLoginWith("xidic56063@aupvs.com", "Test@123").searchForProduct(SEARCH_TERM);
	}
	
	
	@Test(description = "verify if the logged in user is able to buy a dress",
			groups= {"e2e","smoke","sanity","regresstion"})
	public void checkoutTest() {
		String result=searchResultsPage.clickOntheProductAtIndex(1).changeSize(L).proceedToCheckout()
		.goToConfirmAddressPage().goToShippmentPage().goToPaymentPage().makePaymentByWire();
		
		Assert.assertTrue(result.contains("complete"));
	}

}
