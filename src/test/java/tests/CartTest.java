package tests;

import io.qameta.allure.*;
import jdk.jfr.Description;
import org.testng.annotations.Test;

public class CartTest extends BaseTest {

    @Test(testName = "Добавление товара в корзину", groups = {"smoke"},
            description = "Добавление товара в корзину в количестве 2 единиц")
    @Epic("Корзина")
    @Feature("Добавление товара")
    @Story("Отображение товара в корзине")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Карсаков Иван")
    @Description("Проверка добавления товара в корзину")
    @Flaky
    @Link(name= "документация", url = "https://www.saucedemo.com/")
    //https://qase.com/cases/{}
    @TmsLink("TMS_T10")
    @Issue("TMS_T11")
    public void checkCart() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addProduct("Sauce Labs Backpack");
        productsPage.addProduct("Sauce Labs Bike Light");
        productsPage.openCart();
    }
}