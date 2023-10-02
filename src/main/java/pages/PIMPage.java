package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PIMPage {

    private final WebDriver driver;

    public PIMPage(WebDriver driver) {
        this.driver = driver;
    }

    By pageHeader = By.xpath("//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']");


    public boolean isPageHeaderDisplayed() {
        try {
            return driver.findElement(pageHeader).isDisplayed();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String getPageHeaderString() {
        try {
            return driver.findElement(pageHeader).getText();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
}
