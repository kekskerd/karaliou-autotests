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

public class TestLogIn {
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


    @Test(description = "Проверка входа в систему")
    public void test1() {
        WebElement logIn = driver.findElement(By.id("login"));
        logIn.click();
        WebElement emailField = driver.findElement(By.id("email_field"));
        WebElement passwordField = driver.findElement(By.id("password_field"));
        WebElement enterButton = driver.findElement(By.xpath("//div[4]/button"));
        new Actions(driver)
                .sendKeys(emailField, email)
                .sendKeys(passwordField, password)
                .click(enterButton).build().perform();
        WebElement profileDropdown = driver.findElement(By.cssSelector("button.btn_navbar_user-dropdown"));
        Assert.assertTrue(profileDropdown.isDisplayed());
        System.out.println("Successful \"LogIn\" test");
    }


    @AfterTest
    public void quitTest() {
        driver.quit();
    }
}