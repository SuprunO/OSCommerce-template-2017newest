package sitePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import technical.BasePage;
import technical.User;

/**
 * Created by alex on 21.02.2017.
 */
public class PayPage extends BasePage {

    public PayPage(WebDriver driver) {
        super(driver);
    }



    //CSS LOCATORS

    public static final By FIRST_NAME = By.cssSelector("[name=first_name]");
    public static final By LAST_NAME = By.cssSelector("[name=last_name]");
    public static final By ADDRESS = By.cssSelector("[name=address]");
    public static final By CITY = By.cssSelector("[name=city]");
    public static final By ZIP = By.cssSelector("[name=postal_code]");
    public static final By COUNTRY = By.cssSelector("[name=country_code]");
    public static final By PHONE = By.cssSelector("[name=phone_number]");
    public static final By EMAIL = By.cssSelector("[name=email]");
    public static final By ISSUING_BANK = By.cssSelector("[name=cc_issuer]");
    public static final By CARD_NUMBER = By.cssSelector("[name=cc_number]");

    public static final By EXPIRATION_MONTH = By.cssSelector("[name=cc_exp_month]");
    public static final By EXPIRATION_YEAR = By.cssSelector("[name=cc_exp_year]");
    public static final By CVV = By.cssSelector("[name=cc_cvv]");
    public static final By SUBMIT_TRANSACTION_BUTTON = By.cssSelector("#formsubmit");


    public void enterClientCredentialsPaypage(User user) {
        fillInInputField(FIRST_NAME, user.FirstName, "FIRST_NAME");
        fillInInputField(LAST_NAME, user.Lastname, "LAST_NAME");
        fillInInputField(ADDRESS, user.Address, "ADDRESS");
        fillInInputField(CITY, user.City, "CITY");
        fillInInputField(ZIP, user.PostCode, "ZIP");
        Select dropdown = new Select(driver.findElement(COUNTRY));
        dropdown.selectByVisibleText(user.Country);
        fillInInputField(PHONE, user.Telephone, "PHONE");
        fillInInputField(EMAIL, user.EMail, "EMAIL");
        fillInInputField(ISSUING_BANK, user.IssuingBank, "ISSUING BANK");
        fillInInputField(CARD_NUMBER, user.CardNumber, "CARD_NUMBER");
        selectFromDropdownV2(COUNTRY,user.Country);
        Select dropdown1 = new Select(driver.findElement(COUNTRY));
        dropdown1.selectByVisibleText(user.Country);
        selectFromDropdownV2(EXPIRATION_MONTH, user.ExpirationMonth);
        selectFromDropdownV2(EXPIRATION_YEAR, user.ExpirationYear);
        fillInInputField(CVV, user.CVV2, "CVV");
    }
}



