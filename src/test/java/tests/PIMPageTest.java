package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SideMenu;
import pages.DashBoard;
import pages.LoginPage;
import pages.PIMPage;
import testdata.CustomDataProviders;

public class PIMPageTest extends BaseTest {

    SideMenu sideMenu;
    PIMPage pimPage;

    @Test(priority = 1, description = "Test to PIM page is displayed when module is selected from main menu.", dataProvider = "validCredentials", dataProviderClass = CustomDataProviders.class)
    public void testToValidatePIMModuleIsDisplayed(String usernameValue, String passwordValue) {
        LoginPage loginPage = new LoginPage(driver);
        DashBoard dashBoard = loginPage.performLogin(usernameValue, passwordValue);
        sideMenu = new SideMenu(driver);
        pimPage = sideMenu.gotoPIMModule();
        Assert.assertTrue(pimPage.isPageHeaderDisplayed());
        Assert.assertEquals(pimPage.getPageHeaderString(), "PIM");
    }
}
