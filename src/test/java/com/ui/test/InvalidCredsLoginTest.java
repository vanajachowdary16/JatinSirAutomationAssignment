package com.ui.test;

import static org.testng.Assert.*;

import org.apache.logging.log4j.Logger;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ui.listeners.TestListener;
import com.ui.pojo.User;
import com.utility.loggerUtility;

@Listeners({ TestListener.class })
public class InvalidCredsLoginTest extends TestBase {

    // removed local HomePage homepage;    <-- IMPORTANT

    Logger logger = loggerUtility.getLogger(this.getClass());
    private static final String INVALID_EMAIL_ADDRESS="testautomation123@email.com";
    private static final String INVALID_PASSWORD="testautomation123";

    @Test( description = "verify if the proper error message is shown for the user when they enter invalid credentials", groups = { "e2e",
            "sanity", "sanity" })
    public void loginTest() {
        assertEquals(homePage.goToLoginPage().doLoginWithInvalidCredentials(INVALID_EMAIL_ADDRESS,INVALID_PASSWORD).getErrorMessage(), "Authentication failed.");
        
    }

}
