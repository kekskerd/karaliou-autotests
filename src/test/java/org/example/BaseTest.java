package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pages.HomePage;
import pages.LogInPage;
import utils.PropertyHelper;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    ChromeDriver driver;
    private final String startUrl = PropertyHelper.getConf().startUrl();
    private final int pageLoadTimeout = PropertyHelper.getConf().pageLoadTimeout();
    private final int elementTimeout = PropertyHelper.getConf().elementTimeout();

    @BeforeTest
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(elementTimeout, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(pageLoadTimeout, TimeUnit.SECONDS);
        driver.get(startUrl);
    }

    @AfterTest
    public void quitTest() {
        driver.quit();
    }
}
