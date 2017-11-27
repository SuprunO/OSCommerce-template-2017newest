package sitePages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import ru.yandex.qatools.allure.annotations.Step;
import technical.BasePage;
import technical.User;

/**
 * Created by alex on 21.02.2017.
 */
public class CheckoutPage extends BasePage {
    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    //Locators
    public static final By LOGIN_PAGE_CONTINUE_BUTTON = By.cssSelector(".box>div:last-child>a");
    public static final By SHIPPING_PAGE_CONTINUE_BUTTON = By.cssSelector("#tdb5");
    public static final By FIRST_NAME = By.cssSelector("[name=firstname]");
    public static final By LAST_NAME = By.cssSelector("[name=lastname]");
    public static final By DOB  = By.cssSelector("[name=dob]");
    public static final By EMAIL= By.cssSelector("[name=email_address]");
    public static final By ADDRESS= By.cssSelector("[name=street_address]");
    public static final By POSTCODE = By.cssSelector("[name=postcode]");
    public static final By CITY = By.cssSelector("[name=city]");
    public static final By STATE= By.cssSelector("[name=state]");
    public static final By COUNTRY = By.cssSelector("[name=country]");
    public static final By PHONE = By.cssSelector("[name=telephone]");
    public static final By PASSWORD = By.cssSelector("[name=password]");
    public static final By CONFIRM_PASSWORD = By.cssSelector("[name=confirmation]");
    public static final By MALE_RADIOBUTTON = By.cssSelector("[value=m]");

    public static final By TRANSACTION_SUCCESS_TEXT = By.cssSelector(".order-info:last-child>div>h2");


    public void inputCredentials(User user) {
        fillInInputField(FIRST_NAME,user.FirstName,"First name");
        fillInInputField(LAST_NAME,user.Lastname,"Last name");
        fillInInputField(DOB,user.DOB,"Date of Birth");
        fillInInputField(EMAIL,user.EMail,"EMAIL");
        fillInInputField(ADDRESS,user.Address,"ADDRESS");
        fillInInputField(POSTCODE,user.PostCode,"POSTCODE");
        fillInInputField(CITY,user.City,"CITY");
        selectValueInDropDown(COUNTRY,user.Country,"COUNTRY");
        fillInInputField(STATE,user.State,"STATE");
        fillInInputField(PHONE,user.Telephone,"Telephone");
        fillInInputField(PASSWORD,user.Password,"Password");
        fillInInputField(CONFIRM_PASSWORD,user.Password,"Confirm Password");
    }


}
