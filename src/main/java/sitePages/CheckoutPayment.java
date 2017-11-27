package sitePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import technical.BasePage;

public class CheckoutPayment extends BasePage {
    public CheckoutPayment(WebDriver driver) {
        super(driver);
    }

    public static final By PRIVACY_POLICY_RADIOBUTTON = By.cssSelector("#cbshipp");
    public static final By TERMS_CONDITIONS_RADIOBUTTON = By.cssSelector("#cbterms");
    public static final By DELIVERY_RADIOBUTTON = By.cssSelector("#cbpay");

    public static  final By CHECKOUT_PAYMENT_CONTINUE_BUTTON =By.cssSelector("#tdb6");



    public void selectRadiobuttons(){
        clickOnElement(PRIVACY_POLICY_RADIOBUTTON,"PRIVACY_POLICY_RADIOBUTTON");
        clickOnElement(TERMS_CONDITIONS_RADIOBUTTON,"TERMS_CONDITIONS_RADIOBUTTON");
        clickOnElement(DELIVERY_RADIOBUTTON,"DELIVERY_RADIOBUTTON");
    }
}
