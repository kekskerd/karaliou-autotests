package org.example;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LogInPage;

public class TestLocalization extends BaseTest {
    HomePage homePage;
    private String email = "testuser1312test@yandex.ru";
    private String password = "testuser1312test1312";

    @Test(description = "Проверка смены локализации на английскую версию без входа в аккаунт")
    public void test1() {
        new HomePage(driver)
                .localizationButtonClick()
                .englishRadioBtnClick()
                .saveSettingsButtonClick();
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
        new LogInPage(driver)
                .emailFieldSendKeys(email)
                .passwordFieldSendKeys(password)
                .enterLogInButtonClick()
                .profileDropdownButtonClick()
                .settingsButtonClick()
                .englishRadioBtnClick()
                .saveSettingsButtonClick();
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.urlContains("https://habr.com/en/"));
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("https://habr.com/en/"));
        System.out.println("Successful \"Change Localization\" test");
    }

    @Test(description = "Проверка смены локализации обратно на русскую версию у авторизованного пользователя")
    public void test3() {
        homePage.profileDropdownButtonClick()
                .settingsButtonClick()
                .russianRadioBtnClick()
                .saveSettingsButtonClick();
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.urlContains("https://habr.com/ru/"));
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("https://habr.com/ru/"));
        System.out.println("Successful \"Change Localization\" test");
    }

}
