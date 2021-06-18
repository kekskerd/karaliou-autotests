package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

public class LogInPage extends BasePage{

    @FindBy(id = "email_field")
    public WebElement emailField;

    @FindBy(id = "password_field")
    public WebElement passwordField;

    @FindBy(xpath = "//div[4]/button")
    public WebElement enterLogInButton;

    public LogInPage(WebDriver driver) {
        super(driver);
    }

    public LogInPage emailFieldSendKeys(String email){
        emailField.sendKeys(email);
        return this;
    }

    public LogInPage passwordFieldSendKeys(String password) {
        passwordField.sendKeys(password);
        return this;
    }

    public LogInPage enterLogInButtonClick(){
        enterLogInButton.click();
        return this;
    }

}

