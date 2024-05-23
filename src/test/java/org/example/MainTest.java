package org.example;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MainTest {
    WebDriver driver;

    @BeforeAll
    public void setUp() {
        driver = new EdgeDriver();
        // D:\Download Program\edgedriver_win64
        System.setProperty("webdriver.edge.driver", "D:\\Download Program\\edgedriver_win64\\msedgedriver.exe");

        driver.manage().window().maximize();
    }

    @Test
    @Order(1)
    public void testVerifyURL() {
        String url = "https://practicetestautomation.com/practice-test-login/";
        driver.get(url);

        // Check The URL
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "practicetestautomation.com/practice-test-login/";

        assertTrue(actualUrl.contains(expectedUrl));
    }

    @Test
    @Order(2)
    public void testVerifyNewPageContainsCongratulations() {
        // Login
        String username = "student";
        String password = "Password123";

        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("submit")).click();

        WebElement congratulations = driver.findElement(
                By.xpath("//*[contains(text(), 'Congratulations')]")
        );
        congratulations.isDisplayed();
    }

    @Test
    @Order(3)
    public void testVerifyButtonLogOutDisplayed() {
        WebElement logOut = driver.findElement(By.xpath("//*[contains(text(), 'Log out')]"));
        logOut.isDisplayed();
    }

    @AfterAll
    public void tearDown() {
        driver.quit();
    }

}