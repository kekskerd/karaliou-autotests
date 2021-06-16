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

public class TestBookmark {
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

    @Test(description = "Проверка добавления статьи в закладки")
    public void test3() {
        WebElement article = driver.findElement(By.xpath("//li[1]/article/h2/a"));
        String articleName = article.getText();
        article.click();
        WebElement bookmark = driver.findElement(By.xpath("//*[@title='Добавить в закладки']"));
        bookmark.click();
        WebElement profileButton = driver.findElement(By.cssSelector("button.btn_navbar_user-dropdown"));
        profileButton.click();
        WebElement profileBookmark = driver.findElement(By.xpath("//*[@role='menu']/ul/li[3]"));
        profileBookmark.click();
        WebElement bookmarkArticle = driver.findElement(By.xpath("//li[1]/article/h2/a"));
        String bookmarkArticleName = bookmarkArticle.getText();
        Assert.assertEquals(articleName, bookmarkArticleName);
        System.out.println("Successful \"Add article to bookmark\" test");
    }

    @AfterTest
    public void quitTest() {
       driver.quit();
    }

}