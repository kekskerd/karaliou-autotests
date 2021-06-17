package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SettingsPage {
    WebDriver driver;

    public WebElement countryDropDownList = driver.findElement(By.xpath("//form/div[3]/div/div/div[1]/select"));
    public WebElement profile = driver.findElement(By.xpath("//a[contains(text(),'Профиль')]"));
    public SettingsPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getCountry (String needCountry){
        return driver.findElement(By.xpath("//option[contains(text(),'" + needCountry + "')]"));
    }
}

