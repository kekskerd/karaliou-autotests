package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Factory;

public class ProfilePage extends BasePage{

    public final String NEED_COUNTRY = "Сектор Газа";

    @FindBy(xpath = "//*[contains(text(),'" + NEED_COUNTRY + "')]")
    public WebElement NeedCountry;

    public void checkNeedCountry(){
        Assert.assertTrue(NeedCountry.isDisplayed());
    }

    public ProfilePage(WebDriver driver) {
        super(driver);
    }
}
