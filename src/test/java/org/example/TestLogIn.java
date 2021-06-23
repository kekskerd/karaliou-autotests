package org.example;

import io.qameta.allure.Description;
import logging.DefaultListener;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.HomePage;
import pages.LogInPage;
import utils.PropertyHelper;

@Listeners(DefaultListener.class)
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
        System.out.println("Successful \"LogIn\" test");
    }

    @Test
    @Description("Проверка выхода из системы")
    public void test2() {
        new HomePage(driver)
                .profileDropdownButtonClick()
                .exit()
                .checkExit();
        System.out.println("Successful \"Exit\" test");
    }

    @DataProvider(name = "test3")
    public static Object[] invalidEmails() {
        return new Object[]{"", "123", "9999999999999999999999", "testuser", "testuser@@yandex.ruu", "testuser1312testyandex.ru"};
    }

    @Test(dataProvider = "test3")
    @Description("Проверка входа с невалидным email")
    public void test3(String invalidEmail) {
        new HomePage(driver)
                .logInButtonClick()
                .emailFieldSendKeys(invalidEmail)
                .passwordFieldSendKeys(validPassword)
                .enterLogInButtonClick();
        JavascriptExecutor goBack = (JavascriptExecutor) driver;
        goBack.executeScript("window.history.go(-1)");
        System.out.println("Successful \"LogIn\" NEGATIVE test with email value = \'" + invalidEmail + "\'");
    }
}