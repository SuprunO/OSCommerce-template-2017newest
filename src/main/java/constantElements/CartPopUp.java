package constantElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import sitePages.CheckoutPage;
import technical.BasePage;

/**
 * Created by alex on 07.04.2017.
 */


public class CartPopUp extends BasePage {

    public CartPopUp(WebDriver driver) {
        super(driver);
    }


    public static final By CART_CHECKOUT_BUTTON2 = By.cssSelector(".header-shopping-cart>div>.cart-button>a");

    public CheckoutPage getCartCheckoutButton() {

        return new CheckoutPage(driver);
    }

    public WebElement getProductNameLocator() {
        return driver.findElement(By.cssSelector(".table.table-striped>tbody>tr>td:nth-of-type(2)>a"));
    }

    public WebElement getColorLocator() {
        return driver.findElement(By.cssSelector(".table.table-striped>tbody>tr>td:nth-of-type(2)>small:first-of-type"));
    }

    public WebElement getSizeLocator() {
        return driver.findElement(By.cssSelector(".table.table-striped>tbody>tr>td:nth-of-type(2)>small:last-of-type"));
    }

    public WebElement getNumberOfItemsLocator() {
        return driver.findElement(By.cssSelector(".table.table-striped>tbody>tr>td:nth-of-type(3)"));
    }

    public WebElement getProductPriceLocator() {

        return driver.findElement(By.cssSelector(".table.table-striped>tbody>tr>td:nth-of-type(4)"));
    }

    public WebElement getSubtotalPriceLocator() {

        return driver.findElement(By.cssSelector("#td-sm-7"));
    }

    public WebElement getTotalPriceLocator() {

        return driver.findElement(By.cssSelector("#td-sm-9"));
    }

    public WebElement getViewCartButtonLocator() {

        return driver.findElement(By.cssSelector(".text-right>a:first-child"));
    }

}
