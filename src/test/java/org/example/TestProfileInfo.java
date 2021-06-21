package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProfilePage;
import pages.SettingsPage;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestProfileInfo extends BaseLogInTest {

    @Test
    @Description("Проверка изменения страны в информации о профиле")
    public void test1() {
        new HomePage(driver)
                .profileDropdownButtonClick()
                .profileSettingsClick()
                .countryDropDownListClick()
                .getCountryClick()
                .profileClick()
                .checkNeedCountry();
        System.out.println("Successful \"Change profile country\" test");
    }

}
