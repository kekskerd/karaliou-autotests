package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

public class SettingsPage extends BasePage{
    public final String NEED_COUNTRY = "Сектор Газа";

    @FindBy(xpath = "//div[3]/div/div/div[1]/select")
    public WebElement countryDropDownList;

    @FindBy(xpath = "//*[contains(text(),'Успешно обновили')]")
    public WebElement successfulUpdated;

    @FindBy(xpath = "//a[contains(text(),'Профиль')]")
    public WebElement profile;

    @FindBy(xpath = "//option[contains(text(),'" + NEED_COUNTRY + "')]")
    public WebElement getCountry;

    public SettingsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Открытие выпадающего списка стран")
    public SettingsPage countryDropDownListClick(){
        countryDropDownList.click();
        return this;
    }

    @Step("Переход на страницу профиля пользователя")
    public ProfilePage profileClick(){
        profile.click();
        return new ProfilePage(driver);
    }
    @Step("Выбор нужной страны в выпадающем списке")
    public SettingsPage getCountryClick(){
        getCountry.click();
        return this;
    }


}

