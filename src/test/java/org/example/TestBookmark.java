package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
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

public class TestBookmark extends BaseLogInTest {

    HomePage homePage;
    BookmarkPage bookmarkPage;

    @Test
    @Description("Проверка добавления статьи в закладки")
    public void test1() {
        homePage = new HomePage(driver);
        String articleName = homePage.article.getText();
        new ArticlePage(driver)
                .bookmarkClick()
                .profileDropdownButtonClick()
                .profileBookmarkClick();
        bookmarkPage = new BookmarkPage(driver);
        String bookmarkArticleName = bookmarkPage.bookmarkArticle.getText();
        Assert.assertEquals(articleName, bookmarkArticleName);
        bookmarkPage.bookmarkDeleteClick();
        System.out.println("Successful \"Add article to bookmark\" test");
    }

}