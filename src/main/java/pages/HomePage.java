package pages;

import io.qameta.allure.Step;
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

    @FindBy(xpath = "//article/h2/a")
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
    public WebElement localizationSettingsButton;

    @FindBy(xpath = "//*[@role='menu']/ul/li[6]")
    public WebElement profileSettings;

    @FindBy(xpath = "//*[@role='menu']/ul/li[7]")
    public WebElement exitProfile;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage articleClick() {
        article.click();
        return this;
    }
    @Step("Открытие выпадающего меню пользователя")
    public HomePage profileDropdownButtonClick() {
        profileDropdownButton.click();
        return this;
    }
    @Step("Переход в 'Закладки' Пользователя")
    public HomePage profileBookmarkClick() {
        profileBookmark.click();
        return this;
    }
    @Step("Выбор английского языка в меню выбора локализации")
    public HomePage englishRadioBtnClick() {
        englishRadioBtn.click();
        return this;
    }
    @Step("Открытие окна смены локализации")
    public HomePage localizationButtonClick() {
        localizationButton.click();
        return this;
    }
    @Step("Переход в 'Настройки локализации' Пользователя")
    public HomePage localizationSettingsButtonClick() {
        localizationSettingsButton.click();
        return this;
    }
    @Step("Выбор русского языка в меню выбора локализации")
    public HomePage russianRadioBtnClick() {
        russianRadioBtn.click();
        return this;
    }
    @Step("Сохранение настроек локализации")
    public HomePage saveSettingsButtonClick() {
        saveSettingsButton.click();
        return this;
    }
    @Step("Переход в 'Настройки' Пользователя")
    public SettingsPage profileSettingsClick() {
        profileSettings.click();
        return new SettingsPage(driver);
    }
    @Step("Открытие страницы аутентификации")
    public LogInPage logInButtonClick() {
        logInButton.click();
        return new LogInPage(driver);
    }
    @Step("Открытие страницы аутентификации")
    public HomePage exit() {
        exitProfile.click();
        return this;
    }


    @Step("Проверка успешной аутентификации Пользователя")
    public void checkLogIn() {
        Assert.assertTrue(profileDropdownButton.isDisplayed());
    }
    @Step("Проверка успешного выхода из профиля")
    public HomePage checkExit() {
        Assert.assertTrue(logInButton.isDisplayed());
        return new HomePage(driver);
    }

}

