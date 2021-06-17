package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.w3c.dom.html.HTMLInputElement;

import java.util.concurrent.TimeUnit;

public class HomePage {
    WebDriver driver;
    public WebElement logInButton = driver.findElement(By.id("login"));
    public WebElement article = driver.findElement(By.xpath("//li[1]/article/h2/a"));
    public WebElement profileDropdownButton = driver.findElement(By.cssSelector("button.btn_navbar_user-dropdown"));
    public WebElement profileBookmark = driver.findElement(By.xpath("//*[@role='menu']/ul/li[3]"));
    public WebElement localizationButton = driver.findElement(By.cssSelector("button.js-show_lang_settings"));
    public WebElement englishRadioBtn = driver.findElement(By.xpath("//label[text()='English']"));
    public WebElement russianRadioBtn = driver.findElement(By.xpath("//label[text()='Русский']"));
    public WebElement saveSettingsButton = driver.findElement(By.cssSelector("button.js-popup_save_btn"));
    public WebElement settingsButton = driver.findElement(By.xpath("//*[@role='menu']/ul/li[5]"));
    public WebElement profileSettings = driver.findElement(By.xpath("//*[@role='menu']/ul/li[6]"));

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void checkLogIn() {
        Assert.assertTrue(profileDropdownButton.isDisplayed());
    }

}

