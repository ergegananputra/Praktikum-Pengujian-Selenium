import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import pages.dashboard.DashboardPage;
import pages.login.LoginPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class DashboardJourney {
    WebDriver driver;
    LoginPage loginPage;
    DashboardPage dashboardPage;


    @BeforeAll
    public void setUp() {
        driver = new EdgeDriver();

        // D:\Download Program\edgedriver_win64
        System.setProperty("webdriver.edge.driver", "D:\\Download Program\\edgedriver_win64\\msedgedriver.exe");

        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);

        driver.manage().window().maximize();
    }

    @Test
    @Order(1)
    public void testLogin() {
        String targetURL = "https://practicetestautomation.com/practice-test-login/";

        String username = "student";
        String password = "Password123";

        driver.get(targetURL);
        loginPage.putUsername(username);
        loginPage.putPassword(password);
        loginPage.clickSubmit();
    }

    @Test
    @Order(2)
    public void testVerifyURL() {
        String textContain = "practicetestautomation.com/logged-in-successfully/";
        String actualURL = dashboardPage.getURL();

        assertTrue(actualURL.contains(textContain));
    }

    @Test
    @Order(3)
    public void testVerifyCongratulations() {
        dashboardPage.isCongratulationsDisplayed();
    }

    @Test
    @Order(4)
    public void testVerifyLogOutButton() {
        dashboardPage.isLogOutButtonDisplayed();
    }

    @AfterAll
    public void tearDown() {
        driver.quit();
    }


}
