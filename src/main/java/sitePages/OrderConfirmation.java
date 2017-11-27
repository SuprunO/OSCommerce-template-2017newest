package sitePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import technical.BasePage;

public class OrderConfirmation extends BasePage {
    public OrderConfirmation(WebDriver driver) {
        super(driver);
    }

    public static final By ORDER_CONFIRMATION_CONFIRM_ORDER_BUTTON =By.cssSelector("#tdb5");

}
