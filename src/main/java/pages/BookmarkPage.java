package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

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

    public BookmarkPage bookmarkDeleteClick(){
        bookmarkDelete.click();
        return this;
    }

}
