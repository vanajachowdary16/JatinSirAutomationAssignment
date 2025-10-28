package com.ui.test;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.constants.Browser;
import com.ui.pages.HomePage;
import com.utility.BrowserUtility;
import com.utility.LambdaTestUtility;
import com.utility.loggerUtility;


public class TestBase {
	protected HomePage homePage;
	Logger logger = loggerUtility.getLogger(this.getClass());
	private boolean isLambdaTest;

	@BeforeMethod(description = "Load the Homepage of the website")
	@Parameters({ "browser", "isLambdaTest", "isHeadless" })

	public void setup(@Optional("chrome") String browser, @Optional("false") boolean isLambdaTest,
			@Optional("false") boolean isHeadless, ITestResult result) {

		this.isLambdaTest = isLambdaTest;
		WebDriver lambdaDriver = null;
		if (isLambdaTest) {

			homePage = new HomePage(lambdaDriver);

		} else {
			// Running the test on local machine!!!
			logger.info("Load the Homepage of the website");
			homePage = new HomePage(Browser.valueOf("chrome".toUpperCase()), isHeadless);

		}
	}

	public BrowserUtility getInstance() {
		return homePage;
	}

	@AfterMethod(description = "Tear Down the browser")
	public void tearDown() {

		if (isLambdaTest) {
			LambdaTestUtility.quitSession(); // quit or close the browsersession on LT
		} else {
			homePage.quit(); // local
		}
	}

}