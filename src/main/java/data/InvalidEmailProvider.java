package data;

import org.testng.annotations.DataProvider;

public class InvalidEmailProvider {
    @DataProvider(name = "InvalidEmailProvider")
    public static Object[] invalidEmails() {
        return new Object[]{"", "123", "9999999999999999999999", "testuser", "testuser@@yandex.ruu", "testuser1312testyandex.ru"};
    }
}
