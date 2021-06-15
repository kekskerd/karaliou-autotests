package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class App {
    public static void main(String[] args) throws Exception {
        logInHabr("testuser1312test@yandex.ru", "testuser1312test1312");
        changeProfileCountry("Уганда");
    }

    public static void logInHabr(String email, String password) throws Exception {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://habr.com/");
        WebElement logIn = driver.findElement(By.id("login"));
        JavascriptExecutor clickLogButton = driver;
        clickLogButton.executeScript("arguments[0].click()", logIn);
        WebElement emailField = driver.findElement(By.id("email_field"));
        JavascriptExecutor fillEmailField = driver;
        fillEmailField.executeScript("arguments[0].value = '" + email + "'", emailField);
        WebElement passwordField = driver.findElement(By.id("password_field"));
        JavascriptExecutor fillPasswordField = driver;
        fillPasswordField.executeScript("arguments[0].value = '" + password + "'", passwordField);
        WebElement enterButton = driver.findElement(By.cssSelector("button.button_wide.button_primary"));
        JavascriptExecutor clickEnterButton = driver;
        clickEnterButton.executeScript("arguments[0].click()", enterButton);
        try {
            WebElement profileButton = (new WebDriverWait(driver, 10))
                    .until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.btn_navbar_user-dropdown")));
            profileButton.click();
        } catch (Exception e) {
            driver.quit();
            throw new Exception("Authentication error");
        }
        System.out.println("Successful \"LogIn\" test");
        driver.quit();
    }

    public static void changeProfileCountry(String needCountry) throws Exception {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://habr.com/");
        WebElement logIn = driver.findElement(By.id("login"));
        logIn.click();
        WebElement emailField = driver.findElement(By.id("email_field"));
        WebElement passwordField = driver.findElement(By.id("password_field"));
        WebElement enterButton = driver.findElement(By.cssSelector("button.button_wide.button_primary"));
        new Actions(driver)
                .sendKeys(emailField, "testuser1312test@yandex.ru")
                .sendKeys(passwordField, "testuser1312test1312")
                .click(enterButton).build().perform();
        try {
            WebElement profileButton = (new WebDriverWait(driver, 10))
                    .until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.btn_navbar_user-dropdown")));
            profileButton.click();
        } catch (Exception e) {
            driver.quit();
            throw new Exception("Authentication error");
        }
        WebElement settings = driver.findElement(By.cssSelector("div.main-navbar__section.main-navbar__section_right > div > div > ul > li:nth-child(6) > a"));
        settings.click();
        WebElement countryDropDownList = driver.findElement(By.cssSelector("div:nth-child(3) > div > div > div.h-form-select.h-form-controls__item.h-form-select_small > select"));
        countryDropDownList.click();
        WebElement country = driver.findElement(By.xpath("//option[contains(text(),'" + needCountry + "')]"));
        country.click();
        WebElement saveChanges = driver.findElement(By.xpath("//*[contains(text(),'Сохранить изменения')]"));
        saveChanges.click();
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'Успешно обновили')]")));

        WebElement profile = driver.findElement(By.xpath("//a[contains(text(),'Профиль')]"));
        new Actions(driver)
                .keyDown(Keys.CONTROL)
                .click(profile)
                .keyUp(Keys.CONTROL)
                .build().perform();
        List<String> windows = new ArrayList<>(driver.getWindowHandles());
        String secondTab = windows.get(1);
        driver.switchTo().window(secondTab);
        try {
            new WebDriverWait(driver, 3)
                    .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'" + needCountry + "')]")));
            System.out.println("Successful \"Change profile country\" test");
            driver.quit();
        } catch (Exception e) {
            driver.quit();
            throw new Exception("Test \"Change profile country\" failed");
        }
    }
}

