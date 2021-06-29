package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class BookmarkPage extends BasePage{
    @FindBy(xpath = "//article/h2/a")
    public WebElement bookmarkArticle;

    @FindBy(xpath = "//button[@title='Удалить из закладок']")
    public WebElement bookmarkDelete;

    public BookmarkPage(WebDriver driver) {
        super(driver);
    }

    public BookmarkPage bookmarkArticleClick(){
        bookmarkArticle.click();
        return this;
    }
    @Step("Удаление статьи из закладки")
    public BookmarkPage bookmarkDeleteClick(){
        bookmarkDelete.click();
        return this;
    }

    @Step("Проверка добавления статьи в закладки")
    public BookmarkPage checkAddBookmark(String articleName) {
        String bookmarkArticleName = bookmarkArticle.getText();
        Assert.assertEquals(articleName, bookmarkArticleName);
        return this;
    }

}
