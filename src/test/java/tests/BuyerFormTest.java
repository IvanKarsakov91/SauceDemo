package tests;

import org.testng.annotations.Test;
import pages.*;

public class BuyerFormTest extends BaseTest {

    @Test(dataProvider = "Позитивные тесты для заполнения данных при оформлении заказа",
            testName = "Валидное заполнение данных оформления заказа", retryAnalyzer = Retry.class,
            priority = 1, groups = {"smoke"})
    public void checkOut3() {
        loginPage.open();
        softAssert.assertEquals(driver.getCurrentUrl(), LoginPage.BASE_URL, "Login page URL mismatch");
        loginPage.login("standard_user", "secret_sauce");
        softAssert.assertTrue(productsPage.getTitle().contains("Products"), "Failed to log in");
        productsPage.addProduct("Sauce Labs Backpack");
        productsPage.addProduct("Sauce Labs Bike Light");
        productsPage.openCart();
        softAssert.assertTrue(cartPage.getTitle().contains("Your Cart"), "Failed to open cart");
        cartPage.clickCheckoutButton();
        swagLabs.open();
        softAssert.assertEquals(driver.getCurrentUrl(), BasePage.BASE_URL + "checkout-step-one.html", "Checkout step one URL mismatch");
        swagLabs.setFirstName("Ivan");
        swagLabs.setLastName("Karsakov");
        swagLabs.setZipPostalCode("1234");
        swagLabs.clickContinue();
        softAssert.assertTrue(driver.getCurrentUrl().contains("checkout-step-two"), "Failed to proceed to checkout step two");
        softAssert.assertAll();
    }
}