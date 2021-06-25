package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class ProfilePage extends BasePage{

    public final String NEED_COUNTRY = "Сектор Газа";

    @FindBy(xpath = "//*[contains(text(),'" + NEED_COUNTRY + "')]")
    public WebElement NeedCountry;

    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    @Step("Проверка успешной смены страны в настройках пользователя")
    public void checkNeedCountry(){
        Assert.assertTrue(NeedCountry.isDisplayed());
    }

}
