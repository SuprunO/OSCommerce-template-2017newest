package sitePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import technical.BasePage;

public class CheckoutShipping extends BasePage{
    public CheckoutShipping(WebDriver driver) {
        super(driver);
    }

    public static final By CHECKOUT_SHIPPING_CONTINUE_BUTTON_SITE_1 = By.cssSelector("#tdb6");
    public static final By CHECKOUT_SHIPPING_CONTINUE_BUTTON2_SITE_2 = By.cssSelector("#tdb5");
}
