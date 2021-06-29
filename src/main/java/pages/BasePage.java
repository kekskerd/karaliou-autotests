package pages;

import logging.DefaultListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Listeners;

@Listeners(DefaultListener.class)
public class BasePage {
    WebDriver driver;

    BasePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver , this);
    }
}
