package org.example;


import io.qameta.allure.Description;
import logging.DefaultListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.HomePage;

@Listeners(DefaultListener.class)
public class TestProfileInfo extends BaseLogInTest {

    @Test
    @Description("Проверка изменения страны в информации о профиле")
    public void test1() {
        new HomePage(driver)
                .profileDropdownButtonClick()
                .profileSettingsClick()
                .countryDropDownListClick()
                .getCountryClick()
                .profileClick()
                .checkNeedCountry();
        System.out.println("Successful \"Change profile country\" test");
    }

}
