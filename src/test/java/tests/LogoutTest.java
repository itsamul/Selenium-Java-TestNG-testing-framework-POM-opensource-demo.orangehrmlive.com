package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashBoard;
import pages.LoginPage;
import pages.SideMenu;
import testdata.CustomDataProviders;

public class LogoutTest extends BaseTest {

    @Test(priority = 1, description = "Test to logout from the application.", dataProvider = "validCredentials", dataProviderClass = CustomDataProviders.class)
    public void TestLogoutFromApplication(String usernameValue, String passwordValue){
        LoginPage loginPage = new LoginPage(driver);
        DashBoard dashboard = loginPage.performLogin(usernameValue, passwordValue);
        SideMenu sideMenu = new SideMenu(driver);
        loginPage = sideMenu.performLogout();
        Assert.assertTrue(loginPage.isOnLoginPage());
    }
}
