package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestLocalization {
    private ChromeDriver driver;
    private String email = "testuser1312test@yandex.ru";
    private String password = "testuser1312test1312";

    @BeforeTest
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://habr.com/");
    }

    @Test(description = "Проверка смены локализации на английскую версию без входа в аккаунт")
    public void test1() {
        WebElement localizationButton = driver.findElement(By.cssSelector("button.js-show_lang_settings"));
        localizationButton.click();
        WebElement englishRadioBtn = (new WebDriverWait(driver, 5))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//label[text()='English']")));
        englishRadioBtn.click();
        WebElement saveSettingsButton = driver.findElement(By.cssSelector("button.js-popup_save_btn"));
        saveSettingsButton.click();
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.urlToBe("https://habr.com/en/"));
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://habr.com/en/");
        System.out.println("Successful \"Change Localization\" test");
    }

    @Test(description = "Проверка смены локализации на анлийскую версию у авторизованного пользователя")
    public void test2() {
        WebElement logIn = driver.findElement(By.id("login"));
        logIn.click();
        WebElement emailField = driver.findElement(By.id("email_field"));
        WebElement passwordField = driver.findElement(By.id("password_field"));
        WebElement enterButton = driver.findElement(By.xpath("//div[4]/button"));
        new Actions(driver)
                .sendKeys(emailField, email)
                .sendKeys(passwordField, password)
                .click(enterButton).build().perform();
        WebElement profileButton = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.btn_navbar_user-dropdown")));
        profileButton.click();
        WebElement settings = driver.findElement(By.xpath("//*[@role='menu']/ul/li[5]"));
        settings.click();
        WebElement englishRadioBtn = (new WebDriverWait(driver, 5))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//label[text()='English']")));
        englishRadioBtn.click();
        WebElement saveSettingsButton = driver.findElement(By.cssSelector("button.js-popup_save_btn"));
        saveSettingsButton.click();
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.urlContains("https://habr.com/en/"));
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("https://habr.com/en/"));
        System.out.println("Successful \"Change Localization\" test");
    }

    @Test(description = "Проверка смены локализации обратно на русскую версию у авторизованного пользователя")
    public void test3() {
        WebElement profileButton = driver.findElement(By.cssSelector("button.btn_navbar_user-dropdown"));
        profileButton.click();
        WebElement settings = driver.findElement(By.xpath("//*[@role='menu']/ul/li[5]"));
        settings.click();
        WebElement russianRadioBtn = (new WebDriverWait(driver, 5))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//label[text()='Русский']")));
        russianRadioBtn.click();
        WebElement saveSettingsButton = driver.findElement(By.cssSelector("button.js-popup_save_btn"));
        saveSettingsButton.click();
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.urlContains("https://habr.com/ru/"));
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("https://habr.com/ru/"));
        System.out.println("Successful \"Change Localization\" test");
    }

    @AfterTest
    public void quitTest() {
        driver.quit();
    }
}
