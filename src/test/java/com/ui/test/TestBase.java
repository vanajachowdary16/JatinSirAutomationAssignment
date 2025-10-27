package com.ui.test;

import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import com.constants.Browser;

import com.ui.pages.HomePage;
import com.utility.BrowserUtility;
import com.utility.loggerUtility;

public class TestBase {

    protected HomePage homePage;

    Logger logger = loggerUtility.getLogger(this.getClass());

    @BeforeMethod(description = "load the homepage of the website")
	public void setUp() {
		logger.info("load the homepage of the website");
		homePage = new HomePage(Browser.CHROME);
	}
    public BrowserUtility getInstance(){
        return homePage;
    }
}
