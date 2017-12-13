package constantElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import technical.BasePage;

/**
 * Created by alex on 07.04.2017.
 */
public class Layout extends BasePage {

    public Layout (WebDriver driver) {
        super(driver);
    }


    //Header
    public WebElement getLoginLinkText() {
        return driver.findElement(By.linkText("Login"));
    }

    public WebElement getHomeLinkText() {
        return driver.findElement(By.linkText("Home"));
    }

    public WebElement getContactUsLinkText() {
        return driver.findElement(By.linkText("Contact Us"));
    }

    public WebElement getCartLinkText() {
        return driver.findElement(By.cssSelector("#cart-total"));
    }


    //Add categories
    public WebElement getFirstCategoryText() {
        return driver.findElement(By.linkText("Wedding Dresses"));
    }


    public WebElement getSecondCategoryText() {
        return driver.findElement(By.linkText("Mother of the Bride"));
    }

    public WebElement getThirdCategoryText() {
        return driver.findElement(By.linkText("Bridesmaid Dresses"));
    }


    public WebElement getFeaturedProductsHeaderText() {
        return driver.findElement(By.cssSelector("#col-sm-35>h3"));
    }


    //footer headers
    public WebElement getInformationHeaderText() {
        return driver.findElement(By.cssSelector("#col-sm-80>h5"));
    }

    public WebElement getMyAccountHeaderText() {
        return driver.findElement(By.linkText("My Account"));
    }

    public WebElement getOurOffersHeaderText() {
        return driver.findElement(By.cssSelector("#col-sm-82>h5"));
    }

    public WebElement getCompanyInfoHeaderText() {
        return driver.findElement(By.cssSelector("#col-sm-83>h5"));
    }

    public WebElement getContactUsHeaderTextFooter() {
        return driver.findElement(By.linkText("Contact Us"));
    }


    //footer links


    public WebElement getDeliveryTextFooter() {
        return driver.findElement(By.linkText("Delivery Information"));
    }

    public WebElement getPrivacyPolicyTextFooter() {
        return driver.findElement(By.linkText("Privacy Policy"));
    }

    public WebElement getTermsConditionsTextFooter() {
        return driver.findElement(By.linkText("Terms & Conditions"));
    }

    public WebElement getMyAccountTextFooter() {
        return driver.findElement(By.linkText("My Account"));
    }

    public WebElement getOrderHistoryTextFooter() {
        return driver.findElement(By.linkText("Order History"));
    }

    public WebElement getSpecialsLinkText() {
        return driver.findElement(By.linkText("Specials"));
    }


}
