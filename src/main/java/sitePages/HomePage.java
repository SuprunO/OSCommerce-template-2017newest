package sitePages;

import constantElements.Layout;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import technical.BasePage;

/**
 * Created by alex on 04.02.2017.
 */
public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    private static final Logger LOGGER = Logger.getLogger(HomePage.class);

    public Layout getLayout() {
        return new Layout(driver);
    }

    public static final By FIRST_PRODUCT_IN_THE_GRID_SITE_1 = By.cssSelector("#centerColumn>.block-content>ul>li:first-child>.product-container>.product-content>div:first-child>a");
    public static final By FIRST_PRODUCT_IN_THE_GRID_SITE_2 = By.cssSelector("#bodyContent>.container>.row>div>div>ul>div:first-child>div>div:first-child>li>div>div>div:first-child>a");


    public static final By ShoppingCartIcon1 = By.cssSelector(".header-shopping-cart>h3>a");
    public static final By ShoppingCartIcon2 = By.cssSelector("#cart");


}





