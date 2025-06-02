package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartPage extends BasePage {

    private static final By CHECKOUT_BUTTON = By.id("checkout");
    public boolean isProductPresent(String productName) {
        return driver.findElements(By.xpath("//*[text()='" + productName + "']")).size() > 0;
    }

    public CartPage(WebDriver driver) {
        super(driver);
    }
    public String getTitle() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(
                "[data-test='title']"))).getText();
    }
    public void open() {
        driver.get(BASE_URL + "/cart.html");
    }
    public void clickCheckoutButton() {
        driver.findElement(CHECKOUT_BUTTON).click();
    }
    public void removeProduct(String productName) {
        By removeButton = By.xpath("//*[text()='" + productName +
                "']/following-sibling::button[contains(@id, 'remove')]");
        wait.until(ExpectedConditions.elementToBeClickable(removeButton)).click();
    }
    public boolean isCartEmpty() {
        By cartItemLocator = By.cssSelector(".cart_item"); // Проверь, правильный ли селектор
        return driver.findElements(cartItemLocator).isEmpty();
    }
}