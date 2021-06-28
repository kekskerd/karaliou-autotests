package org.example;

import driver.DriverProvider;
import logging.DefaultListener;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import utils.PropertyHelper;

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
