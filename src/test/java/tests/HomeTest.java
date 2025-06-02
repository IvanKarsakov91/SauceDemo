package tests;

import org.testng.annotations.Test;
import pages.LoginPage;

public class HomeTest extends BaseTest {

    @Test(testName = "Возврат на страницу логина после выхода из аккаунта",
            retryAnalyzer = Retry.class,
            groups = {"regression"}, priority = 1)
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