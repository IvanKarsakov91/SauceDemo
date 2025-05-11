package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FinalConfirmPage extends BasePage {

    private static final By FINISH = By.id("finish");

    public FinalConfirmPage(WebDriver driver) {
        super(driver);
    }
    public void open() {
        driver.get("https://www.saucedemo.com/checkout-step-two.html");
    }
    public void clickFinish () {
        driver.findElement(FINISH).click();
    }
}
