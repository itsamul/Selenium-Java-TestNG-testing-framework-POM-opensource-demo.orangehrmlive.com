package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SideMenu {

    private final WebDriver driver;

    public SideMenu(WebDriver driver) {
        this.driver = driver;
    }
    By userDropdownButton = By.xpath("//span[@class='oxd-userdropdown-tab']");
    By logoutLink = By.linkText("Logout");
    By pimMainMenuItem = By.xpath("//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name' and text()='PIM']");

    public LoginPage performLogout(){
        try {
            driver.findElement(userDropdownButton).click();
            driver.findElement(logoutLink).click();
            return new LoginPage(driver);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public PIMPage gotoPIMModule(){
        driver.findElement(pimMainMenuItem).click();
        return new PIMPage(driver);
    }


}
