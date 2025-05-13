package tests;

import org.testng.annotations.Test;
import pages.LoginPage;

import java.util.List;

public class SortingTest extends BaseTest {

    @Test
    public void checkSuccessSortingAZ() {
        loginPage.open();
        softAssert.assertEquals(driver.getCurrentUrl(), LoginPage.BASE_URL, "Login page URL mismatch");

        loginPage.login("standard_user", "secret_sauce");
        softAssert.assertTrue(productsPage.getTitle().contains("Products"), "Failed to log in");

        productsPage.clickSortButton("az");

        List<String> sortedNames = productsPage.getProductNames();
        List<String> expectedSortedNames = productsPage.getSortedProductNames("az");

        softAssert.assertEquals(sortedNames, expectedSortedNames, "Sorting A-Z failed");

        softAssert.assertAll();
    }

    @Test
    public void checkSuccessSortingZA() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.clickSortButton("za");

        List<String> sortedNames = productsPage.getProductNames();
        List<String> expectedSortedNames = productsPage.getSortedProductNames("za");

        softAssert.assertEquals(sortedNames, expectedSortedNames, "Sorting Z-A failed");

        softAssert.assertAll();
    }

    @Test
    public void checkSuccessSortingLH() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.clickSortButton("lohi");

        List<Double> sortedPrices = productsPage.getProductPrices();
        List<Double> expectedSortedPrices = productsPage.getSortedProductPrices("lohi");

        softAssert.assertEquals(sortedPrices, expectedSortedPrices, "Sorting Low-High failed");

        softAssert.assertAll();
    }

    @Test
    public void checkSuccessSortingHL() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.clickSortButton("hilo");

        List<Double> sortedPrices = productsPage.getProductPrices();
        List<Double> expectedSortedPrices = productsPage.getSortedProductPrices("hilo");

        softAssert.assertEquals(sortedPrices, expectedSortedPrices, "Sorting High-Low failed");

        softAssert.assertAll();
    }
}
