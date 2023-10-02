package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginPage {

    private final WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    By usernameField = By.name("username");
    By passwordField = By.name("password");
    By loginButton = By.xpath("//button[@type='submit']");
    By alertMessage = By.xpath("//p[@class='oxd-text oxd-text--p oxd-alert-content-text']");
    By inputErrorMessages = By.xpath("//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']");


    public boolean isOnLoginPage(){
        try {
            return driver.findElement(loginButton).isDisplayed();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public boolean isAlertMessagePresent() {
        try {
            return driver.findElement(alertMessage).isDisplayed();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String getAlertMessageString() {
        try {
            return driver.findElement(alertMessage).getText();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void enterUsername(String usernameValue) {
        try {
            driver.findElement(usernameField).clear();
            driver.findElement(usernameField).sendKeys(usernameValue);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void enterPassword(String passwordValue) {
        try {
            driver.findElement(passwordField).clear();
            driver.findElement(passwordField).sendKeys(passwordValue);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void clickLoginButton() {
        try {
            driver.findElement(loginButton).click();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public DashBoard performLogin(String usernameValue, String passwordValue) {
        try {
            enterUsername(usernameValue);
            enterPassword(passwordValue);
            clickLoginButton();
            return new DashBoard(driver);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean isErrorMessagePresent() {
        try {
            List<WebElement> errorMessages = driver.findElements(inputErrorMessages);
            boolean status = false;
            for (WebElement errorMessage : errorMessages) {
                if (!errorMessage.getText().equalsIgnoreCase("Required")) {
                    status = false;
                    break;
                }
                status = true;
            }
            return status;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String[] getErrorMessagePresent() {
        try {
            List<WebElement> errorMessages = driver.findElements(inputErrorMessages);
            String[] errorMessagedisplayed = new String[2];
            for (int i = 0; i < errorMessages.size(); i++) {
                errorMessagedisplayed[i] = errorMessages.get(i).getText();
            }
            return errorMessagedisplayed;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
