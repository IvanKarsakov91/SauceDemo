package pages;

import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Comparator;

public class ProductsPage extends BasePage {

    private static final By TITLE = By.cssSelector("[data-test='title']");
    private static final By CART_BUTTON = By.cssSelector(".shopping_cart_link");
    private static final String ADD_TO_CART_PATTERN = "//*[text()='%s']/ancestor::div[@class='inventory_item']//button";
    private static final By SORT_BUTTON = By.cssSelector("[data-test='product-sort-container']");
    private static final By REMOVE = By.id("remove-sauce-labs-backpack");
    private static final By PRODUCT_NAMES = By.className("inventory_item_name");
    private static final By PRODUCT_PRICES = By.className("inventory_item_price");
    private static final By BURGER_MENU = By.id("react-burger-menu-btn");
    private static final By LOGOUT = By.id("logout_sidebar_link");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public String getTitle() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(TITLE)).getText();
    }

    public void clickSortButton(String sortValue) {
        Select sortDropdown = new Select(driver.findElement(SORT_BUTTON));
        sortDropdown.selectByValue(sortValue);
    }

    public void addProduct(String product) {
        By productLocator = By.xpath(String.format(ADD_TO_CART_PATTERN, product));
        wait.until(ExpectedConditions.elementToBeClickable(productLocator)).click();
    }

    public void openCart() {
        wait.until(ExpectedConditions.elementToBeClickable(CART_BUTTON)).click();
    }

    public void clickRemove() {
        wait.until(ExpectedConditions.elementToBeClickable(REMOVE)).click();
    }
    public void clickBurger() {
        driver.findElement(BURGER_MENU).click();
    }
    public void clickLogout() {
        driver.findElement(LOGOUT).click();
    }
    public List<String> getProductNames() {
        return driver.findElements(PRODUCT_NAMES)
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public List<String> getSortedProductNames(String sortType) {
        List<String> productNames = getProductNames();
        if (sortType.equals("az")) {
            productNames.sort(Comparator.naturalOrder());
        } else if (sortType.equals("za")) {
            productNames.sort(Comparator.reverseOrder());
        }
        return productNames;
    }

    public List<Double> getProductPrices() {
        return driver.findElements(PRODUCT_PRICES)
                .stream()
                .map(e -> Double.parseDouble(e.getText().replace("$", "")))
                .collect(Collectors.toList());
    }

    public List<Double> getSortedProductPrices(String sortType) {
        List<Double> productPrices = getProductPrices();
        if (sortType.equals("lohi")) {
            productPrices.sort(Comparator.naturalOrder());
        } else if (sortType.equals("hilo")) {
            productPrices.sort(Comparator.reverseOrder());
        }
        return productPrices;
    }
}
