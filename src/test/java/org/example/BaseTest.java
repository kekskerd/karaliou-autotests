package org.example;

import driver.DriverProvider;
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

    @AfterSuite
    public void tearDown() {
        driver.quit();
    }
}
