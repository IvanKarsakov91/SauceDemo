package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {
    private static final By HOME_BUTTON = By.id("back-to-products");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(BASE_URL + "checkout-complete.html");
    }

    public void clickHome() {
        WebElement homeButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("back-to-products")));
        homeButton.click();
    }

    public boolean isHomeLoaded() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("inventory_list"))).isDisplayed();
    }
}
