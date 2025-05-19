package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FinalConfirmPage extends BasePage {

    private static final By FINISH_BUTTON = By.id("finish");
    private static final By SUCCESS_MESSAGE = By.cssSelector(".complete-header");

    public FinalConfirmPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(BASE_URL + "checkout-step-two.html");
        wait.until(ExpectedConditions.urlToBe(BASE_URL + "checkout-step-two.html"));
    }

    public void clickFinish() {
        wait.until(ExpectedConditions.elementToBeClickable(FINISH_BUTTON)).click();
    }

    public boolean isOrderSuccessMessageDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(SUCCESS_MESSAGE)).isDisplayed();
    }

    public By getFinishButton() {
        return FINISH_BUTTON;
    }
}
