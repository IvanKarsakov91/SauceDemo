package tests;

import org.testng.annotations.Test;
import pages.LoginPage;

public class ProductsTitleTest extends BaseTest {

    @Test
    public void checkProductsPageTitle() {
        loginPage.open();
        softAssert.assertEquals(driver.getCurrentUrl(), LoginPage.BASE_URL, "Login page URL mismatch");

        loginPage.login("standard_user", "secret_sauce");
        softAssert.assertTrue(productsPage.getTitle().contains("Products"), "Products page title is incorrect");

        softAssert.assertAll();
    }
}
