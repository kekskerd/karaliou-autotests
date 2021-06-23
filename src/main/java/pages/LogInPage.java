package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class LogInPage extends BasePage{

    @FindBy(id = "email_field")
    public WebElement emailField;

    @FindBy(id = "password_field")
    public WebElement passwordField;

    @FindBy(xpath = "//div[4]/button")
    public WebElement enterLogInButton;

    @FindBy(className = ".s-error")
    public WebElement enterCorrectEmailText;

    public LogInPage(WebDriver driver) {
        super(driver);
    }

    @Step("Заполнение поля 'email'")
    public LogInPage emailFieldSendKeys(String email){
        emailField.sendKeys(email);
        return this;
    }
    @Step("Заполнение поля 'password'")
    public LogInPage passwordFieldSendKeys(String password) {
        passwordField.sendKeys(password);
        return this;
    }
    @Step("Нажатие кнопки 'Войти'")
    public HomePage enterLogInButtonClick(){
        enterLogInButton.click();
        return new HomePage(driver);
    }

    @Step("Проверка на невалидный email")
    public void checkInvalidEmail() {
        Assert.assertTrue(enterCorrectEmailText.isDisplayed());
    }



}

