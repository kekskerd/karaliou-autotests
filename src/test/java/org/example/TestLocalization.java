package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LogInPage;

import java.util.concurrent.TimeUnit;

public class TestLocalization extends BaseUnLogInTest {
    HomePage homePage;
    LogInPage logInPage;
    private String email = "testuser1312test@yandex.ru";
    private String password = "testuser1312test1312";

    @Test(description = "Проверка смены локализации на английскую версию без входа в аккаунт")
    public void test1() {
        homePage = new HomePage(driver);
        homePage.localizationButton.click();
        homePage.englishRadioBtn.click();
        homePage.saveSettingsButton.click();
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.urlToBe("https://habr.com/en/"));
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://habr.com/en/");
        System.out.println("Successful \"Change Localization\" test");
    }

    @Test(description = "Проверка смены локализации на анлийскую версию у авторизованного пользователя")
    public void test2() {
        homePage = new HomePage(driver);
        homePage.logInButton.click();
        logInPage = new LogInPage(driver);
        logInPage.inputEmail(email);
        logInPage.inputPassword(password);
        logInPage.enterLogInButton.click();
        homePage.profileDropdownButton.click();
        homePage.settingsButton.click();
        homePage.englishRadioBtn.click();
        homePage.saveSettingsButton.click();
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.urlContains("https://habr.com/en/"));
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("https://habr.com/en/"));
        System.out.println("Successful \"Change Localization\" test");
    }

    @Test(description = "Проверка смены локализации обратно на русскую версию у авторизованного пользователя")
    public void test3() {
        homePage.profileDropdownButton.click();
        homePage.settingsButton.click();
        homePage.russianRadioBtn.click();
        homePage.saveSettingsButton.click();
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.urlContains("https://habr.com/ru/"));
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("https://habr.com/ru/"));
        System.out.println("Successful \"Change Localization\" test");
    }

}
