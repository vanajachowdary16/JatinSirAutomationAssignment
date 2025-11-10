package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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

	public AddressPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

}
