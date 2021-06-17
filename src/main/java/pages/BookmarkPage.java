package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

public class BookmarkPage extends BasePage{
    @FindBy(xpath = "//li[1]/article/h2/a")
    public WebElement bookmarkArticle;

    @FindBy(xpath = "//li[2]/button[@title='Удалить из закладок']")
    public WebElement bookmarkDelete;

    public BookmarkPage(WebDriver driver) {
        super(driver);
    }
}
