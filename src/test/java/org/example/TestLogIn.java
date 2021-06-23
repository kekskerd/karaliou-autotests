package org.example;

import io.qameta.allure.Description;
import logging.DefaultListener;
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


}