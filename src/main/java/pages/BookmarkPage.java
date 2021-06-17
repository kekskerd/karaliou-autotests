package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BookmarkPage {
    WebDriver driver;
    public WebElement bookmarkArticle = driver.findElement(By.xpath("//li[1]/article/h2/a"));

    public BookmarkPage(WebDriver driver) {
        this.driver = driver;
    }
}
