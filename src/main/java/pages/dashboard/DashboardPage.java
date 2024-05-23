package pages.dashboard;

import org.openqa.selenium.WebDriver;

public class DashboardPage {
    WebDriver driver;
    DashboardObject dashboardObject;

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        dashboardObject = new DashboardObject(driver);
    }

    public void isCongratulationsDisplayed() {
        driver.findElement(dashboardObject.getTextCongratulations()).isDisplayed();
    }

    public void isLogOutButtonDisplayed() {
        driver.findElement(dashboardObject.getButtonLogOut()).isDisplayed();
    }

    public String getURL() {
        return driver.getCurrentUrl();
    }

}
