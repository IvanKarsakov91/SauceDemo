package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import pages.*;

import java.awt.image.PixelGrabber;
import java.time.Duration;
import java.util.HashMap;

import static tests.AllureUtils.takeScreenshot;

@Listeners(TestListener.class)
public class BaseTest {

    protected WebDriver driver;
    protected SoftAssert softAssert;
    protected LoginPage loginPage;
    protected ProductsPage productsPage;
    protected CartPage cartPage;
    protected SwagLabs swagLabs;
    protected FinalConfirmPage finalConfirmPage;
    protected HomePage homePage;

    @Parameters({"browser"})
    @BeforeMethod(alwaysRun= true, description = "Открытие браузера")
    public void setup(@Optional("chrome") String browser, ITestContext context) {
        if (browser == null || browser.trim().isEmpty()) {
            browser = "chrome"; // Используем значение по умолчанию
        }

        switch (browser.toLowerCase()) {
            case "chrome":
                ChromeOptions options = new ChromeOptions();
                HashMap<String, Object> chromePrefs = new HashMap<>();
                chromePrefs.put("credentials_enable_service", false);
                chromePrefs.put("profile.password_manager_enabled", false);
                options.setExperimentalOption("prefs", chromePrefs);
                options.addArguments("--incognito", "--disable-notifications", "--disable-popup-blocking", "--disable-infobars");
                driver = new ChromeDriver(options);
                break;

            case "firefox":
                driver = new FirefoxDriver();
                break;

            default:
                throw new IllegalArgumentException("Unsupported browser: " + browser);
        }

        context.setAttribute("driver", driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30)); // Добавляем ожидание загрузки страницы
        driver.manage().window().maximize();

        softAssert = new SoftAssert();
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        cartPage = new CartPage(driver);
        swagLabs = new SwagLabs(driver);
        homePage = new HomePage(driver);
    }

    @AfterMethod(alwaysRun = true, description = "Закрытие браузера")
    public void tearDown(ITestResult result) {
        if(ITestResult.FAILURE== result.getStatus()){
            takeScreenshot(driver);
        }
        if (driver != null) {
            try {
                driver.quit();
            } catch (Exception e) {
                System.err.println("Ошибка при закрытии WebDriver: " + e.getMessage());
            }
        }
    }
}
