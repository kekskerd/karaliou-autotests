package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

public class SettingsPage extends BasePage{
    public final String NEED_COUNTRY = "Сектор Газа";

    @FindBy(xpath = "//form/div[3]/div/div/div[1]/select")
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

}

