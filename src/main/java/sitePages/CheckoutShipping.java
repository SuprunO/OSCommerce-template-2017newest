package sitePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import technical.BasePage;

public class CheckoutShipping extends BasePage{
    public CheckoutShipping(WebDriver driver) {
        super(driver);
    }

    public static final By CHECKOUT_SHIPPING_CONTINUE_BUTTON = By.cssSelector("#tdb6");

}
