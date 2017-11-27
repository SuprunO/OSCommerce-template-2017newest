package sitePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import technical.BasePage;

/**
 * Created by alex on 01.05.2017.
 */
public class ShoppingCartPage extends BasePage {
    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    public static final By CART_CHECKOUT_BUTTON = By.cssSelector("#tdb6");
    public static final By CART_CHECKOUT_BUTTON2 = By.cssSelector("#tdb5");
}
