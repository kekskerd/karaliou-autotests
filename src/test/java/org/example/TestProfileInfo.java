package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SettingsPage;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestProfileInfo extends BaseLogInTest {
    WebDriver driver;
    HomePage homePage;
    SettingsPage settingsPage;
    private String needCountry = "Сектор Газа";


    @Test(description = "Проверка изменения страны в информации о профиле")
    public void test3() {
        homePage = new HomePage(driver);
        homePage.profileDropdownButton.click();
        homePage.profileSettings.click();
        settingsPage = new SettingsPage(driver);
        settingsPage.countryDropDownList.click();
        settingsPage.getCountry(needCountry).click();
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'Успешно обновили')]")));
        settingsPage.profile.click();
        WebElement checkNeedCountry = driver.findElement(By.xpath("//*[contains(text(),'" + needCountry + "')]"));
        Assert.assertTrue(checkNeedCountry.isDisplayed());
        System.out.println("Successful \"Change profile country\" test");
    }

}
