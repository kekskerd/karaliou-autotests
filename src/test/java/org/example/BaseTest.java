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

@Slf4j
@Listeners(DefaultListener.class)
public class BaseTest {
     WebDriver driver;
    private final String startUrl = PropertyHelper.getConf().startUrl();
//    private final int pageLoadTimeout = PropertyHelper.getConf().pageLoadTimeout();
//    private final int elementTimeout = PropertyHelper.getConf().elementTimeout();

    @BeforeTest
    public void setUp() {
        driver = DriverProvider.getDriver();
        log.info("Open url: " + startUrl);
        driver.get(startUrl);

//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(elementTimeout, TimeUnit.SECONDS);
//        driver.manage().timeouts().pageLoadTimeout(pageLoadTimeout, TimeUnit.SECONDS);
//        driver.get(startUrl);
    }
    @AfterClass
    public void afterTest() {
        log.info("Tear down driver");
        DriverProvider.tearDown();
    }
//    @AfterTest
//    public void quitTest() {
//        driver.quit();
//    }
}
