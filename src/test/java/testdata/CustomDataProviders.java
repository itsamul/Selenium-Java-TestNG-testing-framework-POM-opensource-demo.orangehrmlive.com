package testdata;

import org.testng.annotations.DataProvider;

public class CustomDataProviders {

    @DataProvider(name = "validCredentials")
    public Object[][] getValidCredentials() {
        return new Object[][]{
                {"Admin", "admin123"}
        };
    }

    @DataProvider(name = "inValidCredentials")
    public Object[][] getInvalidCredentials() {
        return new Object[][]{
                {"Adminx", "admin123x"}
        };
    }

    @DataProvider(name = "blankCredentials")
    public Object[][] getBlankCredentials() {
        return new Object[][]{
                {"", "", "Required", "Required"}
        };
    }

}
