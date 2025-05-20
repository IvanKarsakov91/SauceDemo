package tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LoginTest extends BaseTest {

    @Test(testName = "Валидная авторизация", retryAnalyzer = Retry.class,
            groups = {"smoke"}, priority = 1)
    @Epic("Авторизация")
    @Feature("Страница логина")
    @Story("Позитивный логин")
    public void checkSuccessLogin() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        assertEquals(productsPage.getTitle(),
                "Products",
                "Логин не выполнен");
    }

    @Test(testName = "Авторизация с пустым полем пароля", groups = {"regression"}, priority = 2)
    public void checkLoginWithEmptyPassword() {
        loginPage.open();
        loginPage.login("standard_user", "");
        assertEquals(loginPage.getErrorMessage(),
                "Epic sadface: Password is required",
                "SO BAAAAD");
    }

    @Test(testName = "Авторизация с невалидным Password", groups = {"regression"}, priority = 3)
    public void checkLoginWithWrongPassword() {
        loginPage.open();
        loginPage.login("standard_user", "1243143143");
        assertEquals(loginPage.getErrorMessage(),
                "Epic sadface: Username and password do not match any user in this service",
                "SO BAAAAD");
    }
}

