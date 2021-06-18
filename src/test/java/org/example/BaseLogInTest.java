package org.example;

import org.testng.annotations.BeforeTest;
import pages.HomePage;
import pages.LogInPage;

public class BaseLogInTest extends BaseTest {

    private String email = "testuser1312test@yandex.ru";
    private String password = "testuser1312test1312";

    @BeforeTest
    public void setUp() {
        super.setUp();
        new HomePage(driver)
                .logInButtonClick();
        new LogInPage(driver)
                .emailFieldSendKeys(email)
                .passwordFieldSendKeys(password)
                .enterLogInButtonClick();
    }

}