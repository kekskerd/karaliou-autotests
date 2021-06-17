package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ArticlePage {
    WebDriver driver;
    public WebElement bookmark = driver.findElement(By.xpath("//*[@title='Добавить в закладки']"));

    public ArticlePage(WebDriver driver) {
        this.driver = driver;
    }
}
