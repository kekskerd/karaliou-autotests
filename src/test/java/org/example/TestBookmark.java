package org.example;

import io.qameta.allure.Description;
import logging.DefaultListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.ArticlePage;
import pages.HomePage;

@Listeners(DefaultListener.class)
public class TestBookmark extends BaseLogInTest {

    HomePage homePage;
    @Test
    @Description("Проверка добавления статьи в закладки")
    public void test1() {
        homePage = new HomePage(driver);
        String articleName = homePage.article.getText();
        new ArticlePage(driver)
                .bookmarkClick()
                .profileDropdownButtonClick()
                .profileBookmarkClick()
                .checkAddBookmark(articleName)
                .bookmarkDeleteClick();
        System.out.println("Successful \"Add article to bookmark\" test");
    }

}