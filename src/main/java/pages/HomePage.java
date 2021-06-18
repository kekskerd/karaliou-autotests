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

public class HomePage extends BasePage {

    @FindBy(id = "login")
    public WebElement logInButton;

    @FindBy(xpath = "//li[1]/article/h2/a")
    public WebElement article;

    @FindBy(css = "button.btn_navbar_user-dropdown")
    public WebElement profileDropdownButton;

    @FindBy(xpath = "//*[@role='menu']/ul/li[3]")
    public WebElement profileBookmark;

    @FindBy(css = "button.js-show_lang_settings")
    public WebElement localizationButton;

    @FindBy(xpath = "//label[text()='English']")
    public WebElement englishRadioBtn;

    @FindBy(xpath = "//label[text()='Русский']")
    public WebElement russianRadioBtn;

    @FindBy(css = "button.js-popup_save_btn")
    public WebElement saveSettingsButton;

    @FindBy(xpath = "//*[@role='menu']/ul/li[5]")
    public WebElement settingsButton;

    @FindBy(xpath = "//*[@role='menu']/ul/li[6]")
    public WebElement profileSettings;

    public HomePage logInButtonClick() {
        logInButton.click();
        return this;
    }

    public HomePage articleClick() {
        article.click();
        return this;
    }
    public HomePage profileDropdownButtonClick() {
        profileDropdownButton.click();
        return this;
    }

    public HomePage profileBookmarkClick() {
        profileBookmark.click();
        return this;
    }

    public HomePage englishRadioBtnClick() {
        englishRadioBtn.click();
        return this;
    }

    public HomePage localizationButtonClick() {
        localizationButton.click();
        return this;
    }

    public HomePage settingsButtonClick() {
        settingsButton.click();
        return this;
    }

    public HomePage russianRadioBtnClick() {
        russianRadioBtn.click();
        return this;
    }

    public HomePage saveSettingsButtonClick() {
        saveSettingsButton.click();
        return this;
    }

    public HomePage profileSettingsClick() {
        profileSettings.click();
        return this;
    }

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void checkLogIn() {
        Assert.assertTrue(profileDropdownButton.isDisplayed());
    }

}

