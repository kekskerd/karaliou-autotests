package org.example;

import io.qameta.allure.Description;
import lombok.extern.log4j.Log4j;
import org.testng.annotations.Test;
import pages.ArticlePage;
import pages.HomePage;

@Log4j
public class TestBookmark extends BaseTest {

    @Test
    @Description("Проверка добавления статьи в закладки")
    public void test1() {
        String articleName = new HomePage(driver).article.getText();
        new ArticlePage(driver)
                .bookmarkClick()
                .profileDropdownButtonClick()
                .profileBookmarkClick()
                .checkAddBookmark(articleName)
                .bookmarkDeleteClick();
    }
}