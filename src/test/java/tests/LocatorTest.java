package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class LocatorTest extends BaseTest {

    @Test(testName = "Проверка доступности веб-элементов",
            retryAnalyzer = Retry.class,
            groups = {"smoke"}, priority = 1)
    public void checkLocator() {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name"));
        driver.findElement(By.name("user-name"));
        driver.findElement(By.className("error-message-container"));
        driver.findElement(By.tagName("div"));

    }
}