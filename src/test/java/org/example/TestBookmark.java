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
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.ArticlePage;
import pages.BookmarkPage;
import pages.HomePage;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestBookmark extends BaseLogInTest{
    WebDriver driver;
    HomePage homePage;
    ArticlePage articlePage;
    BookmarkPage bookmarkPage;
    private String email = "testuser1312test@yandex.ru";
    private String password = "testuser1312test1312";

    @Test(description = "Проверка добавления статьи в закладки")
    public void test3() {
        homePage = new HomePage(driver);
        String articleName = homePage.article.getText();
        articlePage = new ArticlePage(driver);
        articlePage.bookmark.click();
        homePage.profileDropdownButton.click();
        homePage.profileBookmark.click();
        bookmarkPage = new BookmarkPage(driver);
        String bookmarkArticleName = bookmarkPage.bookmarkArticle.getText();
        Assert.assertEquals(articleName, bookmarkArticleName);
        System.out.println("Successful \"Add article to bookmark\" test");
    }

}