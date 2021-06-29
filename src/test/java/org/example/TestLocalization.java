package org.example;

import io.qameta.allure.Description;
import lombok.extern.log4j.Log4j;
import org.testng.annotations.Test;
import pages.HomePage;
import utils.PropertyHelper;

@Log4j
public class TestLocalization extends BaseTest {
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
    }

    @Test
    @Description("Проверка смены локализации с русской на анлийскую версию у авторизованного пользователя")
    public void test2() {
        new HomePage(driver)
                .logInButtonClick()
                .emailFieldSendKeys(validEmail)
                .passwordFieldSendKeys(validPassword)
                .enterLogInButtonClick()
                .profileDropdownButtonClick()
                .localizationSettingsButtonClick()
                .englishRadioBtnClick()
                .saveSettingsButtonClick()
                .checkLocalization(driver, "en");
    }

    @Test
    @Description("Проверка смены локализации c английской на русскую версию у авторизованного пользователя")
    public void test3() {
        new HomePage(driver)
                .profileDropdownButtonClick()
                .localizationSettingsButtonClick()
                .russianRadioBtnClick()
                .saveSettingsButtonClick()
                .checkLocalization(driver, "ru");
    }
}
