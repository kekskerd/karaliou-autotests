package org.example;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class App {
    public static void main(String[] args) throws Exception {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://habr.com/");
        WebElement logIn = driver.findElement(By.id("login"));
        logIn.click();
        WebElement emailField = driver.findElement(By.id("email_field"));
        emailField.sendKeys("testuser1312test@yandex.ru");
        WebElement passwordField = driver.findElement(By.id("password_field"));
        passwordField.sendKeys("testuser1312test1312");
        WebElement enterButton = driver.findElement(By.cssSelector("button.button_wide.button_primary"));
        enterButton.click();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        try {
            WebElement profileButton = driver.findElement(By.cssSelector("button.btn_navbar_user-dropdown"));
            profileButton.click();
        } catch (Exception e) {
            driver.quit();
            throw new Exception("Authentication error");
        }
        System.out.println("Successful test");
        driver.quit();
    }
}
