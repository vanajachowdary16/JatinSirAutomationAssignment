package com.ui.test;

import static org.testng.Assert.*;

import org.apache.logging.log4j.Logger;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ui.listeners.TestListener;
import com.ui.pojo.User;
import com.utility.loggerUtility;

@Listeners({ TestListener.class })
public class LoginTest extends TestBase {

    // removed local HomePage homepage;    <-- IMPORTANT

    Logger logger = loggerUtility.getLogger(this.getClass());

    @Test(description = "verifies with the valid user is able to login into the application", groups = { "e2e",
            "sanity" }, dataProviderClass = com.dataproviders.LoginDataProvider.class, dataProvider = "LoginTestDataProvider")
    public void loginTest(User user) {
        String userName = homePage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword())
                .getUserName();
        System.out.println(userName);
        assertEquals(userName, "Test automation");
    }

    @Test(description = "verifies with the valid user is able to login into the application", groups = { "e2e",
            "sanity" }, dataProviderClass = com.dataproviders.LoginDataProvider.class, dataProvider = "LoginTestCSVDataProvider")
    public void loginCSVTest(User user) {
        String userName = homePage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword())
                .getUserName();
        System.out.println(userName);
        assertEquals(userName, "Test automation");
    }

    @Test(description = "verifies with the valid user is able to login into the application", groups = { "e2e",
            "sanity" }, dataProviderClass = com.dataproviders.LoginDataProvider.class, dataProvider = "LoginTestExcelDataProvider")
    public void loginExcelTest(User user) {
        String userName = homePage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword())
                .getUserName();
        System.out.println(userName);
        assertEquals(userName, "Test automation");
    }
}
