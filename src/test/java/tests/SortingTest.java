package tests;

import org.testng.annotations.Test;
import pages.LoginPage;

import java.util.List;

public class SortingTest extends BaseTest {

    @Test(testName = "Сортировка товара на главной странице az",
            retryAnalyzer = Retry.class,
            groups = {"regression"}, priority = 1)
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

    @Test(testName = "Сортировка товара на главной странице za",
            retryAnalyzer = Retry.class,
            groups = {"regression"}, priority = 2)
    public void checkSuccessSortingZA() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.clickSortButton("za");

        List<String> sortedNames = productsPage.getProductNames();
        List<String> expectedSortedNames = productsPage.getSortedProductNames("za");

        softAssert.assertEquals(sortedNames, expectedSortedNames, "Sorting Z-A failed");

        softAssert.assertAll();
    }

    @Test(testName = "Сортировка товара на главной странице lohi",
            retryAnalyzer = Retry.class,
            groups = {"regression"}, priority = 3)
    public void checkSuccessSortingLH() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.clickSortButton("lohi");

        List<Double> sortedPrices = productsPage.getProductPrices();
        List<Double> expectedSortedPrices = productsPage.getSortedProductPrices("lohi");

        softAssert.assertEquals(sortedPrices, expectedSortedPrices, "Sorting Low-High failed");

        softAssert.assertAll();
    }

    @Test(testName = "Сортировка товара на главной странице hilo",
            retryAnalyzer = Retry.class,
            groups = {"regression"}, priority = 4)
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
