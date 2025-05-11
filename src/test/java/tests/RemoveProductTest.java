package tests;

import org.testng.annotations.Test;

public class RemoveProductTest extends BaseTest{

    @Test
    public void checkOut2() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addProduct("Sauce Labs Backpack");
        productsPage.addProduct("Sauce Labs Bike Light");
        productsPage.openCart();
        productsPage.clickRemove();
    }
}
