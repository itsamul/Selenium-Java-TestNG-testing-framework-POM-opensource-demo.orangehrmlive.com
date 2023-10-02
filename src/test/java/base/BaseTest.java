package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseTest {

    protected WebDriver driver;
    private final Properties config = new Properties();

    protected WebDriverWait wait;

    public BaseTest(){
        try {
            FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\configurations\\config.properties");
            config.load(fis);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Parameters("browser")
    @BeforeMethod
    public void setUp(@Optional("Chrome") String browser) {
        if (browser.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        }
        driver.get(config.getProperty("testUrl"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(config.getProperty("ImplicitWait"))));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Integer.parseInt(config.getProperty("PageLoadTimeOut"))));
        wait =  new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(config.getProperty("ExplicitWait"))));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
