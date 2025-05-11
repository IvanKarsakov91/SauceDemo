package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import tests.BaseTest;

public class HomePage extends BasePage {
    private static final By FINISH = By.id("back-to-products");

    public HomePage(WebDriver driver) {
        super(driver);
    }
    public void open() {
        driver.get("https://www.saucedemo.com/checkout-complete.html");
    }
        public void clicklHome() {
            driver.findElement(FINISH).click();
        }
}