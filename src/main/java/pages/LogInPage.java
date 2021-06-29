package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LogInPage extends BasePage {

    @FindBy(id = "email_field")
    public WebElement emailField;

    @FindBy(id = "password_field")
    public WebElement passwordField;

    @FindBy(xpath = "//div[4]/button")
    public WebElement enterLogInButton;

    @FindBy(className = "s-field")
    public WebElement enterCorrectEmailText;

    public LogInPage(WebDriver driver) {
        super(driver);
    }

    @Step("Заполнение поля 'email'")
    public LogInPage emailFieldSendKeys(String email) {
        emailField.sendKeys(email);
        return this;
    }

    @Step("Заполнение поля 'password'")
    public LogInPage passwordFieldSendKeys(String password) {
        passwordField.sendKeys(password);
        return this;
    }

    @Step("Нажатие кнопки 'Войти'")
    public HomePage enterLogInButtonClick() {
        enterLogInButton.click();
        return new HomePage(driver);
    }

    @Step("Нажатие кнопки 'Войти' при невалидных значениях email или password")
    public LogInPage enterInvalidLogInButtonClick() {
        enterLogInButton.click();
        return this;
    }

    @Step("Проверка на невалидный email")
    public LogInPage checkInvalidEmail() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOf(enterCorrectEmailText));
        Assert.assertTrue(enterCorrectEmailText.isDisplayed());
        return this;
    }

    @Step("Переход на предыдущую страницу")
    public void goBackToHomePage(WebDriver driver) {
        JavascriptExecutor goBack = (JavascriptExecutor) driver;
        goBack.executeScript("window.history.go(-1)");
    }

}

