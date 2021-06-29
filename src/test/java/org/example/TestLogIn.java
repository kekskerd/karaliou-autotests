package org.example;

import data.InvalidEmailProvider;
import io.qameta.allure.Description;
import lombok.extern.log4j.Log4j;
import org.testng.annotations.Test;
import pages.HomePage;
import utils.PropertyHelper;

@Log4j
public class TestLogIn extends BaseTest {
    private final String validEmail = PropertyHelper.getConf().validEmail();
    private final String validPassword = PropertyHelper.getConf().validPassword();

    @Test
    @Description("Проверка входа в систему")
    public void test1() {
        new HomePage(driver)
                .logInButtonClick()
                .emailFieldSendKeys(validEmail)
                .passwordFieldSendKeys(validPassword)
                .enterLogInButtonClick()
                .checkLogIn();
    }

    @Test
    @Description("Проверка выхода из системы")
    public void test2() {
        new HomePage(driver)
                .profileDropdownButtonClick()
                .exit()
                .checkExit();
    }

    @Test(dataProvider = "InvalidEmailProvider", dataProviderClass = InvalidEmailProvider.class)
    @Description("Проверка входа с невалидным email")
    public void test3(String invalidEmail) {
        new HomePage(driver)
                .logInButtonClick()
                .emailFieldSendKeys(invalidEmail)
                .passwordFieldSendKeys(validPassword)
                .enterInvalidLogInButtonClick()
                .checkInvalidEmail()
                .goBackToHomePage(driver);
    }
}