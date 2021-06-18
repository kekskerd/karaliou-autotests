package org.example;

import org.testng.Assert;
import org.testng.annotations.*;
import pages.HomePage;
import pages.LogInPage;

public class TestLogIn extends BaseTest {
    public String email = "testuser1312test@yandex.ru";
    public String password = "testuser1312test1312";

    @Test(description = "Проверка входа в систему")
    public void test1() {
        new HomePage(driver)
                .logInButtonClick()
                .emailFieldSendKeys(email)
                .passwordFieldSendKeys(password)
                .enterLogInButtonClick()
                .checkLogIn();
        System.out.println("Successful \"LogIn\" test");
    }


}