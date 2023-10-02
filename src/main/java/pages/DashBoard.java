package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashBoard {

    private final WebDriver driver;

    public DashBoard(WebDriver driver) {
        this.driver = driver;
    }

    By headerField = By.xpath("//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']");

    public boolean isHeaderPresent() {
        try {
            return driver.findElement(headerField).isDisplayed();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String getHeaderString() {
        try {
            return driver.findElement(headerField).getText();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
