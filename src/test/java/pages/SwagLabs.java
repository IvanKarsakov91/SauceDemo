package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SwagLabs extends BasePage {

        private static final By FIRST_NAME = By.id("first-name");
        private static final By LAST_NAME = By.id("last-name");
        private static final By ZIP_POSTAL_CODE = By.id("postal-code");
        private static final By CONTINUE = By.id("continue");

    public SwagLabs(WebDriver driver) {
        super(driver);
    }
    public void open() {
        driver.get("https://www.saucedemo.com/checkout-step-one.html");
    }
        public void setName () {
            driver.findElement(FIRST_NAME).sendKeys("Ivan");
        }
        public void setlastName () {
            driver.findElement(LAST_NAME).sendKeys("Karsakov");
        }
        public void setCode () {
            driver.findElement(ZIP_POSTAL_CODE).sendKeys("1234");
        }
        public void clickContinue () {
            driver.findElement(CONTINUE).click();
        }
}