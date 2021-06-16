package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestProfileInfo {
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
        WebElement logIn = driver.findElement(By.id("login"));
        logIn.click();
        WebElement emailField = driver.findElement(By.id("email_field"));
        WebElement passwordField = driver.findElement(By.id("password_field"));
        WebElement enterButton = driver.findElement(By.xpath("//div[4]/button"));
        new Actions(driver)
                .sendKeys(emailField, email)
                .sendKeys(passwordField, password)
                .click(enterButton).build().perform();
    }

    @Test(description = "Проверка изменения страны в информации о профиле")
    public void test3() {
        WebElement profileButton = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.btn_navbar_user-dropdown")));
        profileButton.click();
        WebElement settings = driver.findElement(By.xpath("//*[@role='menu']/ul/li[6]"));
        settings.click();
        WebElement countryDropDownList = driver.findElement(By.xpath("//form/div[3]/div/div/div[1]/select"));
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
