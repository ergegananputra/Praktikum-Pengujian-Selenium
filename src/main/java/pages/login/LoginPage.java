package pages.login;

import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;
    LoginObject loginObject;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        loginObject = new LoginObject(driver);
    }

    public void putUsername(String username) {
        driver.findElement(loginObject.getTextInputUsername()).sendKeys(username);
    }

    public void putPassword(String password) {
        driver.findElement(loginObject.getTextInputPassword()).sendKeys(password);
    }

    public void clickSubmit() {
        driver.findElement(loginObject.getButtonSubmit()).click();
    }

    public String getURL() {
        return driver.getCurrentUrl();
    }

}
