package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestHabr {
    private ChromeDriver driver;
    private String email = "testuser1312test@yandex.ru";
    private String password = "testuser1312test1312";
    private String needCountry = "Сектор Газа";

    @BeforeTest
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://habr.com/");
    }

    @Test(description = "Проверка смены локализации")
    public void test1() {
        WebElement localizationButton = driver.findElement(By.cssSelector("button.btn.btn_medium.btn_navbar_lang.js-show_lang_settings"));
        localizationButton.click();
        WebElement englishRadioBtn = (new WebDriverWait(driver, 5))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//label[text()='English']")));
        englishRadioBtn.click();
        WebElement saveSettingsButton = driver.findElement(By.cssSelector("button.btn.btn_blue.btn_huge.btn_full-width.js-popup_save_btn"));
        saveSettingsButton.click();
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.urlToBe("https://habr.com/en/"));
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://habr.com/en/");
        System.out.println("Successful \"Change Localization\" test");
    }

    @Test(description = "Проверка входа в систему")
    public void test2() {
        WebElement logIn = driver.findElement(By.id("login"));
        logIn.click();
        WebElement emailField = driver.findElement(By.id("email_field"));
        WebElement passwordField = driver.findElement(By.id("password_field"));
        WebElement enterButton = driver.findElement(By.cssSelector("button.button_wide.button_primary"));
        new Actions(driver)
                .sendKeys(emailField, email)
                .sendKeys(passwordField, password)
                .click(enterButton).build().perform();
        WebElement profileDropdown = driver.findElement(By.cssSelector("button.btn_navbar_user-dropdown"));
        Assert.assertTrue(profileDropdown.isDisplayed());
        System.out.println("Successful \"LogIn\" test");
    }


    @Test(description = "Проверка изменения страны в информации о профиле")
    public void test3() {
        WebElement profileButton = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.btn_navbar_user-dropdown")));
        profileButton.click();
        WebElement settings = driver.findElement(By.cssSelector("div.main-navbar__section.main-navbar__section_right > div > div > ul > li:nth-child(6) > a"));
        settings.click();
        WebElement countryDropDownList = driver.findElement(By.cssSelector("div:nth-child(3) > div > div > div.h-form-select.h-form-controls__item.h-form-select_small > select"));
        countryDropDownList.click();
        WebElement country = driver.findElement(By.xpath("//option[contains(text(),'" + needCountry + "')]"));
        country.click();
        WebElement saveChanges = driver.findElement(By.xpath("//*[contains(text(),'Сохранить изменения')]"));
        saveChanges.click();
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'Успешно обновили')]")));
        WebElement profile = driver.findElement(By.xpath("//a[contains(text(),'Профиль')]"));
        new Actions(driver)
                .keyDown(Keys.CONTROL)
                .click(profile)
                .keyUp(Keys.CONTROL)
                .build().perform();
        List<String> windows = new ArrayList<>(driver.getWindowHandles());
        String secondTab = windows.get(1);
        driver.switchTo().window(secondTab);
        WebElement checkNeedCountry = driver.findElement(By.xpath("//*[contains(text(),'" + needCountry + "')]"));
        Assert.assertTrue(checkNeedCountry.isDisplayed());
        System.out.println("Successful \"Change profile country\" test");
    }

    @AfterTest
    public void quitTest() {
        driver.quit();
    }
}
