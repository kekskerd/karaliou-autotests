package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.HomePage;
import pages.LogInPage;

import java.util.concurrent.TimeUnit;

public class TestLogIn extends BaseUnLogInTest{
    LogInPage logInPage;
    HomePage homePage;
    public String email = "testuser1312test@yandex.ru";
    public String password = "testuser1312test1312";

    @Test(description = "Проверка входа в систему")
    public void test1() {
        homePage = new HomePage(driver);
        homePage.logInButton.click();
        logInPage = new LogInPage(driver);
        logInPage.inputEmail(email);
        logInPage.inputPassword(password);
        logInPage.enterLogInButton.click();
        Assert.assertTrue(homePage.profileDropdownButton.isDisplayed());
        System.out.println("Successful \"LogIn\" test");
    }



}