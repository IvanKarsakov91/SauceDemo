package tests;
import org.testng.annotations.Test;

public class SortingTest extends BaseTest {

    @Test
    public void checkSuccessSortingAZ() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.clickSortButton("az");
    }
    @Test
    public void checkSuccessSortingZA() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.clickSortButton("za");
    }
    @Test
    public void checkSuccessSortingLH() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.clickSortButton("lohi");
    }
    @Test
    public void checkSuccessSortingHL() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.clickSortButton("hilo");
    }
}
