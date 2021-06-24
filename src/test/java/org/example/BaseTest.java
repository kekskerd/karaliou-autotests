package org.example;

import driver.DriverProvider;
import io.github.bonigarcia.wdm.WebDriverManager;
import logging.DefaultListener;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;
import pages.HomePage;
import pages.LogInPage;
import utils.PropertyHelper;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    WebDriver driver;
    private final String startUrl = PropertyHelper.getConf().startUrl();

    @BeforeTest
    public void setUp() {
        driver = DriverProvider.getDriver();
        driver.get(startUrl);
    }

    @AfterTest
    public void afterTest() {
        DriverProvider.tearDown();
    }
}
