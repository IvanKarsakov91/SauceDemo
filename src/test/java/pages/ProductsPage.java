package pages;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage {

    private static final By TITLE = By.cssSelector("[data-test = title]");
    private static final By CART_BUTTON = By.cssSelector(".shopping_cart_link");
    private static final String ADD_TO_CART_PATTERN = "//*[text() = '%s']/ancestor::div[@class = 'inventory_item']//button";
    private static final By SORT_BUTTON = By.cssSelector("[data-test='product-sort-container']");
    private static final By REMOVE = By.id("remove-sauce-labs-backpack");

    public void clickSortButton(String sortValue) {
        Select sortDropdown = new Select(driver.findElement(SORT_BUTTON));
        sortDropdown.selectByValue(sortValue);
    }

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public String getTitle() {
        return driver.findElement(TITLE).getText();
    }

    public void addProduct(String product) {
        driver.findElement(By.xpath(String.format(ADD_TO_CART_PATTERN, product))).click();
    }

    public void openCart() {
        driver.findElement(CART_BUTTON).click();
    }
    public void clickRemove() {
        driver.findElement(REMOVE).click();
    }

}