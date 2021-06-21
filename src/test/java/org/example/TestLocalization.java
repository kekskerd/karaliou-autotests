package org.example;

import io.qameta.allure.Description;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LogInPage;
import utils.PropertyHelper;

public class TestLocalization extends BaseTest {
    HomePage homePage;
    private final String validEmail = PropertyHelper.getConf().validEmail();
    private final String validPassword = PropertyHelper.getConf().validPassword();

    @Test
    @Description("Проверка смены локализации с русской на английскую версию без входа в аккаунт")
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

    @Test
    @Description("Проверка смены локализации с русской на анлийскую версию у авторизованного пользователя")
    public void test2() {
        homePage = new HomePage(driver);
        homePage.logInButton.click();
        new LogInPage(driver)
                .emailFieldSendKeys(validEmail)
                .passwordFieldSendKeys(validPassword)
                .enterLogInButtonClick()
                .profileDropdownButtonClick()
                .localizationSettingsButtonClick()
                .englishRadioBtnClick()
                .saveSettingsButtonClick();
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.urlContains("https://habr.com/en/"));
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("https://habr.com/en/"));
        System.out.println("Successful \"Change Localization\" test");
    }

    @Test
    @Description("Проверка смены локализации c английской на русскую версию у авторизованного пользователя")
    public void test3() {
        homePage.profileDropdownButtonClick()
                .localizationSettingsButtonClick()
                .russianRadioBtnClick()
                .saveSettingsButtonClick();
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.urlContains("https://habr.com/ru/"));
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("https://habr.com/ru/"));
        System.out.println("Successful \"Change Localization\" test");
    }

}
