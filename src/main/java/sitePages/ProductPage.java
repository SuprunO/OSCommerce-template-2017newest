package sitePages;


import constantElements.Layout;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import technical.BasePage;

import java.util.ArrayList;
import java.util.logging.Logger;

/**
 * Created by alex on 21.02.2017.
 */


public class ProductPage extends BasePage {
    private static final org.apache.log4j.Logger LOGGER = org.apache.log4j.Logger.getLogger(ProductPage.class);

    public Layout getLayout() {
        return new Layout(driver);

    }

    //   private static final org.apache.log4j.Logger LOGGER = org.apache.log4j.Logger.getLogger(ProductPage.class);


    public static final By SELECT_COLOR = By.cssSelector("#product>div:nth-of-type(1)>select");
    public static final By SELECT_COLOR_VALUE = By.cssSelector("#product>div:nth-of-type(1)>select>option:last-child");
    public static final By SELECT_SIZE = By.cssSelector("#product>div:nth-of-type(2)>select");
    public static final By SELECT_SIZE_VALUE = By.cssSelector("#product>div:nth-of-type(2)>select>option:last-child");
    public static final By ADDTOCARTBUTTON = By.cssSelector(".buttonAction>[type=submit]");
    public static final By CHOOSEQTYFIELD = By.cssSelector("#input-quantity");
    public static final By HOP_UP_CHECKOUT_BUTTON = By.cssSelector(".popup-button>a");



    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public void chooseColor() {
        try {
            LOGGER.info("Choose color");
            Select select = new Select(driver.findElement(SELECT_COLOR));
            select.selectByIndex(1);

        } catch (Exception e) {
            Logger.getLogger("Skip this step");
        }
    }

    public void chooseSize() {
              LOGGER.info("Choose size");
        try {
            Select select = new Select(driver.findElement(SELECT_SIZE));
            select.selectByIndex(3);
        }catch (Exception e) {
            Logger.getLogger("Skip this step");
        }
    }

    public void inputProductsQuantity() {
        //   LOGGER.info("Input quantity of products");
        try {
            driver.findElement(CHOOSEQTYFIELD).clear();
            driver.findElement(CHOOSEQTYFIELD).sendKeys("1");
        }catch (Exception e) {
            Logger.getLogger("Skip this step");
        }
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







