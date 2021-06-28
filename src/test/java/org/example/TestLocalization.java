package org.example;

import io.qameta.allure.Description;
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
                .saveSettingsButtonClick()
                .checkLocalization(driver, "en");
        System.out.println("Successful \"UnLogIn RU->EN Localization\" test");
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
                .saveSettingsButtonClick()
                .checkLocalization(driver, "en");
        System.out.println("Successful \"RU->EN Localization\" test");
    }

    @Test
    @Description("Проверка смены локализации c английской на русскую версию у авторизованного пользователя")
    public void test3() {
        homePage.profileDropdownButtonClick()
                .localizationSettingsButtonClick()
                .russianRadioBtnClick()
                .saveSettingsButtonClick()
                .checkLocalization(driver, "ru");
        System.out.println("Successful \"EN->RU Localization\" test");
    }

}
