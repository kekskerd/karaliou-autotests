package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pages.HomePage;
import pages.LogInPage;

import java.util.concurrent.TimeUnit;

public class BaseLogInTest {
    ChromeDriver driver;
    LogInPage logInPage;
    HomePage homePage;
    private String email = "testuser1312test@yandex.ru";
    private String password = "testuser1312test1312";

    @BeforeTest
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
        driver.get("https://habr.com/");
        homePage = new HomePage(driver);
        homePage.logInButton.click();
        logInPage = new LogInPage(driver);
        logInPage.inputEmail(email);
        logInPage.inputPassword(password);
        logInPage.enterLogInButton.click();
    }

    @AfterTest
    public void quitTest() {
        driver.quit();
    }
}