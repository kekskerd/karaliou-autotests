package org.example;

import logging.DefaultListener;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import pages.HomePage;
import pages.LogInPage;
import utils.PropertyHelper;

public class BaseLogInTest extends BaseTest {

    private final String validEmail = PropertyHelper.getConf().validEmail();
    private final String validPassword = PropertyHelper.getConf().validPassword();

    @BeforeTest
    public void setUp() {
        super.setUp();
        new HomePage(driver)
                .logInButtonClick()
                .emailFieldSendKeys(validEmail)
                .passwordFieldSendKeys(validPassword)
                .enterLogInButtonClick();
    }

}