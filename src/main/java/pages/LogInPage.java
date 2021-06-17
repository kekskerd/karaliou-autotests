package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LogInPage {
    WebDriver driver;

    public LogInPage(WebDriver driver) {
        this.driver = driver;
    }

    public void inputEmail(String email){
        driver.findElement(By.id("email_field")).sendKeys(email);
    }
    public void inputPassword(String password){
        driver.findElement(By.id("password_field")).sendKeys(password);
    }
    public void pushEnterLogInButton(){
        driver.findElement(By.xpath("//div[4]/button")).click();
    }

}

