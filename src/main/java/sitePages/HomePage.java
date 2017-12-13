package sitePages;

import constantElements.Layout;

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

//    private static final Logger LOGGER = Logger.getLogger(HomePage.class);

    public Layout getLayout() {
        return new Layout(driver);
    }

    public static final By ProductSite1 =By.cssSelector("#centerColumn>.block-content>ul>div:first-child>div:first-child>div:first-child>li>div:last-child>.product-content-wrap>div:first-child>a");
    public static final By ProductSite2 =By.cssSelector("#bodyContent>.container>.row>div>div>ul>li:first-child>div>.product-content>div:first-child>a");



    public static final By ShoppingCartIcon1 =By.cssSelector(".header-shopping-cart>h3>a");
    public static final By ShoppingCartIcon2 =By.cssSelector("#cart");


}





