package tests;

import org.testng.annotations.Test;
import pages.LoginPage;

public class HomeTest extends BaseTest {

    @Test
    public void checkLogoutFunctionality() {
        loginPage.open();
        softAssert.assertEquals(driver.getCurrentUrl(), LoginPage.BASE_URL, "Login page URL mismatch");
        loginPage.login("standard_user", "secret_sauce");
        softAssert.assertTrue(productsPage.getTitle().contains("Products"), "Failed to log in");
        productsPage.clickBurger();
        productsPage.clickLogout();
        softAssert.assertEquals(driver.getCurrentUrl(), LoginPage.BASE_URL, "Logout did not return to login page");
        softAssert.assertAll();
    }
}