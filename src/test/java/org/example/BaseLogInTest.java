package org.example;

import lombok.extern.log4j.Log4j;
import org.testng.annotations.BeforeTest;
import pages.HomePage;
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