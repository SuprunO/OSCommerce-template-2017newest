package sitePages;


import constantElements.Layout;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import technical.BasePage;

import java.util.ArrayList;

/**
 * Created by alex on 21.02.2017.
 */


public class ProductPage extends BasePage {

    public Layout getLayout() {
        return new Layout(driver);

    }

 //   private static final org.apache.log4j.Logger LOGGER = org.apache.log4j.Logger.getLogger(ProductPage.class);


    public static final By SELECT_COLOR = By.cssSelector("#product>div:nth-of-type(1)>select");
    public static final By SELECT_COLOR_VALUE = By.cssSelector("#product>div:nth-of-type(1)>select>option:last-child");
    public static final By SELECT_SIZE = By.cssSelector("#product>div:nth-of-type(2)>select");
    public static final By SELECT_SIZE_VALUE = By.cssSelector("#product>div:nth-of-type(2)>select>option:last-child");
    public static final By ADDTOCARTBUTTON = By.cssSelector(".buttonAction>[type=submit]");
    public static final By CHOOSEQTYFIELD  = By.cssSelector("#input-quantity");
    public static final By Link_to_shopping_cart = By.cssSelector(".alert-success>a:last-of-type");
    public static final By Link_to_shopping_cart2 = By.cssSelector(".popup-button>#tdb2");



    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getProductNameLocator(){
       return driver.findElement(By.cssSelector("#content>h1"));
    }

    public void chooseColor() {
    //    LOGGER.info("Choose color");
        Select select = new Select(driver.findElement(SELECT_COLOR));
        select.selectByIndex(1);
    }

    public void chooseSize() {
  //      LOGGER.info("Choose size");
        Select select = new Select(driver.findElement(SELECT_SIZE));
        select.selectByIndex(3);
    }

    public void inputProductsQuantity() {
     //   LOGGER.info("Input quantity of products");
        driver.findElement(CHOOSEQTYFIELD).clear();
        driver.findElement(CHOOSEQTYFIELD).sendKeys("1");
    }

    public String sizeDropdownExpectedOptions() {
        ArrayList<String> size = new ArrayList<String>();
        size.add("--- Please Select ---");
        size.add("US2");
        size.add("US4");
        size.add("US6");
        size.add("US8");
        size.add("US10");
        size.add("US12");
        size.add("US14");
        size.add("US16");
        size.add("US16W");
        size.add("US18W");
        size.add("US20W");
        size.add("US22W");
        size.add("US24W");
        size.add("US26W");
        return size.toString();
    }

}







