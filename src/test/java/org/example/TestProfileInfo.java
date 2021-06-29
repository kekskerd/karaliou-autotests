package org.example;

import io.qameta.allure.Description;
import lombok.extern.log4j.Log4j;
import org.testng.annotations.Test;
import pages.HomePage;

@Log4j
public class TestProfileInfo extends BaseTest {

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
    }
}
