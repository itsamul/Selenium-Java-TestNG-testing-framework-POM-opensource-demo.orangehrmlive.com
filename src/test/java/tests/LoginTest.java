package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashBoard;
import pages.LoginPage;
import testdata.CustomDataProviders;

public class LoginTest extends BaseTest {
    private LoginPage loginPage;

    @Test(priority = 1, description = "Test to login into the application with valid credentials.", dataProvider = "validCredentials", dataProviderClass = CustomDataProviders.class)
    public void testLoginWithValidCredentials(String usernameValue, String passwordValue) {
        loginPage = new LoginPage(driver);
        DashBoard dashBoard = loginPage.performLogin(usernameValue, passwordValue);
        Assert.assertTrue(dashBoard.isHeaderPresent());
        Assert.assertEquals(dashBoard.getHeaderString(), "Dashboard");

    }

    @Test(priority = 2, description = "Test to login into the application with invalid credentials.", dataProvider = "inValidCredentials", dataProviderClass = CustomDataProviders.class)
    public void testLoginWithInValidCredentials(String usernameValue, String passwordValue) {
        loginPage = new LoginPage(driver);
        loginPage.performLogin(usernameValue, passwordValue);
        Assert.assertTrue(loginPage.isAlertMessagePresent());
        Assert.assertEquals(loginPage.getAlertMessageString(), "Invalid credentials");
    }

    @Test(priority = 3, description = "Test to login into the application with blank credentials", dataProvider = "blankCredentials", dataProviderClass = CustomDataProviders.class)
    public void testLoginWithBlankCredentials(String usernameValue, String passwordValue, String usernameError, String passwordError) {
        loginPage = new LoginPage(driver);
        loginPage.performLogin(usernameValue, passwordValue);
        Assert.assertTrue(loginPage.isErrorMessagePresent());
        String[] expectedErrorMessageList = {usernameError, passwordError};
        String[] actualErrorMessageList = loginPage.getErrorMessagePresent();
        for (int i = 0; i < expectedErrorMessageList.length; i++) {
            if (!expectedErrorMessageList[i].equalsIgnoreCase(actualErrorMessageList[i]))
                Assert.fail();
            Assert.assertTrue(true);

        }
    }

}
