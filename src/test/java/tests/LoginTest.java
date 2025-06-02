package tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LoginTest extends BaseTest {

    @DataProvider(name = "validLoginData")
    public Object[][] validLoginData() {
        return new Object[][]{
                {"standard_user", "secret_sauce", "Products"}
        };
    }

    @DataProvider(name = "invalidLoginData")
    public Object[][] invalidLoginData() {
        return new Object[][]{
                {"standard_user", "", "Epic sadface: Password is required"},
                {"standard_user", "1243143143",
                        "Epic sadface: Username and password do not match any user in this service"}
        };
    }

    @Test(dataProvider = "validLoginData", testName = "Валидная авторизация",
            retryAnalyzer = Retry.class, groups = {"smoke"}, priority = 1)
    @Epic("Авторизация")
    @Feature("Страница логина")
    @Story("Позитивный логин")
    public void checkSuccessLogin(String username, String password, String expectedTitle) {
        loginPage.open();
        loginPage.login(username, password);
        assertEquals(productsPage.getTitle(), expectedTitle, "Логин не выполнен");
    }

    @Test(dataProvider = "invalidLoginData", testName = "Авторизация с невалидными данными",
            groups = {"regression"}, priority = 2)
    @Epic("Авторизация")
    @Feature("Страница логина")
    @Story("Негативные сценарии логина")
    public void checkFailedLogin(String username, String password, String expectedErrorMessage) {
        loginPage.open();
        loginPage.login(username, password);
        assertEquals(loginPage.getErrorMessage(), expectedErrorMessage, "Ошибка логина не совпадает");
    }
}

