package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ArticlePage extends BasePage{

    @FindBy(xpath = "//*[@title='Добавить в закладки']")
    public WebElement bookmark;

    public ArticlePage(WebDriver driver) {
        super(driver);
    }
    @Step("Добавление статьи в закладки")
    public HomePage bookmarkClick(){
        bookmark.click();
        return new HomePage(driver);
    }
}
