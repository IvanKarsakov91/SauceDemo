package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class SwagLabs extends BasePage {

    private static final By FIRST_NAME = By.id("first-name");
    private static final By LAST_NAME = By.id("last-name");
    private static final By ZIP_POSTAL_CODE = By.id("postal-code");
    private static final By CONTINUE = By.id("continue");

    public SwagLabs(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(BASE_URL + "checkout-step-one.html");
    }

    public void setFirstName(String firstName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(FIRST_NAME)).sendKeys(firstName);
    }

    public void setLastName(String lastName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(LAST_NAME)).sendKeys(lastName);
    }

    public void setZipPostalCode(String zipCode) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(ZIP_POSTAL_CODE)).sendKeys(zipCode);
    }

    public void clickContinue() {
        wait.until(ExpectedConditions.elementToBeClickable(CONTINUE)).click();
    }
}