package com.ui.pages;

import static org.testng.Assert.ARRAY_MISMATCH_TEMPLATE;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ui.pojo.AddressPojo;
import com.utility.BrowserUtility;

public class AddressPage extends BrowserUtility{
	
	public static final By COMPANY_TEXTBOX_LOCATOR=By.id("company");
	public static final By ADDRESS1_TEXTBOX_LOCATOR=By.id("address1");
	public static final By ADDRESS2_TEXTBOX_LOCATOR=By.id("address2");
	public static final By CITY_TEXTBOX_LOCATOR=By.id("city");
	public static final By POSTCODE_TEXTBOX_LOCATOR=By.id("postcode");
	public static final By HOME_PHONE_TEXTBOX_LOCATOR=By.id("phone");
	public static final By MOBILE_NUMBER_TEXBOX_LOCATOR=By.id("phone_mobile");
	public static final By OTHER_INFORMATION_TEXTAREA_LOCATOR=By.id("other");
	public static final By ADDRESS_ALIAS_TEXTBOX_LOCATOR=By.id("alias");
	public static final By SAVE_ADDRESS_LOCATOR = By.id("submitAddress");
	public static final By STATE_DROPDOWN_LOCATOR=By.id("id_state");
	public static final By ADDRESS_HEADING = By.tagName("h3");

	public AddressPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public String saveAddress(AddressPojo addressPojo) {
		enterText(COMPANY_TEXTBOX_LOCATOR, addressPojo.getCompanyName());
		enterText(ADDRESS1_TEXTBOX_LOCATOR, addressPojo.getAddressLine1());
		enterText(ADDRESS2_TEXTBOX_LOCATOR, addressPojo.getAddressLine2());
		enterText(CITY_TEXTBOX_LOCATOR, addressPojo.getCityString());
		enterText(POSTCODE_TEXTBOX_LOCATOR, addressPojo.getPostCode());
		enterText(HOME_PHONE_TEXTBOX_LOCATOR, addressPojo.getHomePhoneNumber());
		enterText(MOBILE_NUMBER_TEXBOX_LOCATOR, addressPojo.getMobileNumber());
		enterText(OTHER_INFORMATION_TEXTAREA_LOCATOR, addressPojo.getOtherInformation());
		clearText(ADDRESS_ALIAS_TEXTBOX_LOCATOR);
		enterText(ADDRESS_ALIAS_TEXTBOX_LOCATOR, addressPojo.getAddressAlias());
		selectFromDropDown(STATE_DROPDOWN_LOCATOR, addressPojo.getState());
		clickOn(SAVE_ADDRESS_LOCATOR);
		String newaddress=getVisibleText(ADDRESS_HEADING);
		return newaddress;
	}

}
