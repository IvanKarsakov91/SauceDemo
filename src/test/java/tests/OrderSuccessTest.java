package tests;
import org.testng.annotations.Test;

public class OrderSuccessTest extends BaseTest {
    @Test
    public void checkOut5() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addProduct("Sauce Labs Backpack");
        productsPage.addProduct("Sauce Labs Bike Light");
        productsPage.openCart();
        cartPage.clickCheckoutButton();
        swagLabs.open();
        swagLabs.setName();
        swagLabs.setlastName();
        swagLabs.setCode();
        swagLabs.clickContinue();
        finalConfirmPage.open();
        finalConfirmPage.clickFinish();
    }
}