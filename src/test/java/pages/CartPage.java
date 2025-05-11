package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    private static final By CHECKOUT_BUTTON = By.id("checkout");


    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(BASE_URL + "/cart.html");
    }
    public void clickCheckoutButton() {
        driver.findElement(CHECKOUT_BUTTON).click();
    }
}