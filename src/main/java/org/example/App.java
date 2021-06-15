package org.example;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;

public class App {
    public static void main(String[] args) throws Exception {
        logInHabr("testuser1312test@yandex.ru", "testuser1312test1312");
        changeProfileCountry("Сектор Газа");
        changeLocalization();

    }

    //Тестирование входа в аккаунт
    public static void logInHabr(String email, String password) throws Exception {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://habr.com/");
        WebElement logIn = driver.findElement(By.id("login"));
        logIn.click();
        WebElement emailField = driver.findElement(By.id("email_field"));
        emailField.sendKeys(email);
        WebElement passwordField = driver.findElement(By.id("password_field"));
        passwordField.sendKeys(password);
        WebElement enterButton = driver.findElement(By.cssSelector("button.button_wide.button_primary"));
        enterButton.click();
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

    //Тестирование смены локализации
    public static void changeLocalization() throws Exception {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://habr.com/ru/");
        try {
            WebElement localizationButton = driver.findElement(By.cssSelector("button.btn.btn_medium.btn_navbar_lang.js-show_lang_settings"));
            localizationButton.click();
        } catch (Exception e) {
            driver.quit();
            throw new Exception("no such \"localizationButton\" element");
        }
        WebElement englishRadioBtn = (new WebDriverWait(driver, 5))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//label[text()='English']")));
        englishRadioBtn.click();

        WebElement saveSettingsButton = driver.findElement(By.cssSelector("button.btn.btn_blue.btn_huge.btn_full-width.js-popup_save_btn"));
        saveSettingsButton.click();
        try {
            new WebDriverWait(driver, 3)
                    .until(ExpectedConditions.urlToBe("https://habr.com/en/"));
            System.out.println("Successful \"Change Localization\" test");
            driver.quit();

        } catch (Exception e) {
            driver.quit();
            throw new Exception("Test \"Change Localization\" failed");
        }
    }

    //Тестирование изменения страны в информации о профиле
    public static void changeProfileCountry(String needCountry) throws Exception {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://habr.com/");
        WebElement logIn = driver.findElement(By.id("login"));
        logIn.click();
        WebElement emailField = driver.findElement(By.id("email_field"));
        emailField.sendKeys("testuser1312test@yandex.ru");
        WebElement passwordField = driver.findElement(By.id("password_field"));
        passwordField.sendKeys("testuser1312test1312");
        WebElement enterButton = driver.findElement(By.cssSelector("button.button_wide.button_primary"));
        enterButton.click();
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
        WebElement country = driver.findElement(By.xpath("//option[contains(text(),'" + needCountry + "')]")); //Сектор Газа
        country.click();
        WebElement saveChanges = driver.findElement(By.xpath("//*[contains(text(),'Сохранить изменения')]"));
        saveChanges.click();
        WebElement successSaveChanges = (new WebDriverWait(driver, 3))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'Успешно обновили')]")));

        WebElement profile = driver.findElement(By.xpath("//a[contains(text(),'Профиль')]"));
        profile.click();
        try {
            WebElement needProfile = (new WebDriverWait(driver, 3))
                    .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'" + needCountry + "')]")));
            System.out.println("Successful \"Change profile country\" test");
            driver.quit();
        } catch (Exception e) {
            driver.quit();
            throw new Exception("Test \"Change profile country\" failed");
        }
    }
}
