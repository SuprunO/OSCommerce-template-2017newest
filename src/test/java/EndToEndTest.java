import constantElements.CartPopUp;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Severity;
import ru.yandex.qatools.allure.annotations.Title;
import ru.yandex.qatools.allure.model.SeverityLevel;
import sitePages.*;
import technical.User;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.openqa.selenium.By.cssSelector;
import static technical.BasePage.SiteURL;

/**
 * Created by alex on 21.02.2017.
 */
public class EndToEndTest {
    ChromeDriver driver;
    ProductPage productPage;
    User userData;
    LoginPage loginPage;
    ShoppingCartPage shoppingCartPage;
    CheckoutPage checkoutPage;
    CreateAccountSuccessPage createAccountSuccessPage;
    CheckoutShipping checkoutShipping;
    CheckoutPayment checkoutPayment;
    OrderConfirmation orderConfirmation;
    PayPage payPage;
    HomePage homePage;
    CategoriesPage categoriesPage;
    CartPopUp cartPopUp;
    TransactionFinalPage transactionFinalPage;


    @BeforeTest
    public void StartUp() {
        System.setProperty("webdriver.chrome.driver", "C://selenium/chromedriver.exe");
        // System.setProperty("webdriver.gecko.driver", "C://gecko/geckodriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
        driver = new ChromeDriver(options);
        userData = new User();
        cartPopUp = new CartPopUp(driver);
        shoppingCartPage = new ShoppingCartPage(driver);
        productPage = new ProductPage(driver);
        loginPage = new LoginPage(driver);
        checkoutPage = new CheckoutPage(driver);
        createAccountSuccessPage = new CreateAccountSuccessPage(driver);
        checkoutShipping = new CheckoutShipping(driver);
        checkoutPayment = new CheckoutPayment(driver);
        orderConfirmation = new OrderConfirmation((driver));
        homePage = new HomePage(driver);
        payPage = new PayPage(driver);
        categoriesPage = new CategoriesPage(driver);
        transactionFinalPage = new TransactionFinalPage(driver);

    }


    @DataProvider(name = "url-data-provider")
    public Object[][] urlDataProvider() {
        return new Object[][]{
                {"http:/bestwatchesweb.com"},
                {"http://weddingstuffhub.com"},
                // {"http:/bestaccessoriesnow.com"},

        };
    }

    @Test(dataProvider = "url-data-provider")
    public void endToEndTest(String url) {
        homePage.open(url);
        homePage.threadSleep(10000);

        if (homePage.isElementPresent(HomePage.ProductSite1) == true) {
            homePage.clickOnElement(HomePage.ProductSite1, "Click on Product Site 1");
        } else if (homePage.isElementPresent(HomePage.ProductSite2) == true) {
            homePage.clickOnElement(HomePage.ProductSite2, "Click on Product Site 2");
        }

        productPage.threadSleep(5000);
        if (productPage.isElementPresent(ProductPage.SELECT_COLOR) == true) {

            productPage.chooseColor();
        } else {

        }

        productPage.threadSleep(5000);
        if (productPage.isElementPresent(ProductPage.SELECT_SIZE) == true) {
            productPage.chooseSize();
        } else {

        }

        if (productPage.isElementPresent(ProductPage.CHOOSEQTYFIELD) == true) {
            productPage.inputProductsQuantity();
        } else {

        }

        productPage.clickOnElement(ProductPage.ADDTOCARTBUTTON, "Add to cart Button");
        productPage.threadSleep(5000);
        if (homePage.isElementPresent(ProductPage.Link_to_shopping_cart) == true) {
            homePage.clickOnElement(ProductPage.Link_to_shopping_cart, "Shopping Cart icon");
        } else {
            homePage.clickOnElement(ProductPage.Link_to_shopping_cart2, "Checkout Cart icon Site 2");
        }

        shoppingCartPage.clickOnElement(ShoppingCartPage.CART_CHECKOUT_BUTTON, "CART_CHECKOUT_BUTTON1");

        loginPage.waitElementToBeClickable(25, CheckoutPage.LOGIN_PAGE_CONTINUE_BUTTON);
        loginPage.clickOnElement(CheckoutPage.LOGIN_PAGE_CONTINUE_BUTTON, "CONTINUE_BUTTON");

        checkoutPage.waitElementToBeClickable(25, CheckoutPage.FIRST_NAME);
        checkoutPage.threadSleep(5000);
        checkoutPage.clickOnElement(CheckoutPage.MALE_RADIOBUTTON, "MALE_RADIOBUTTON");
        checkoutPage.inputCredentials(userData);
        checkoutPage.clickOnElement(CheckoutPage.SHIPPING_PAGE_CONTINUE_BUTTON, "SHIPPING_PAGE_CONTINUE_BUTTON");
        createAccountSuccessPage.clickOnElement(CreateAccountSuccessPage.SUCCESS_PAGE_CONTINUE_BUTTON,"SUCCESS PAGE_CONTINUE_BUTTON");
        checkoutShipping.clickOnElement(CheckoutShipping.CHECKOUT_SHIPPING_CONTINUE_BUTTON,"CHECKOUT_SHIPPING_CONTINUE_BUTTON");
        checkoutPayment.selectRadiobuttons();
        checkoutPayment.clickOnElement(CheckoutPayment.CHECKOUT_PAYMENT_CONTINUE_BUTTON,"CHECKOUT_PAYMENT_CONTINUE_BUTTON");
        orderConfirmation.clickOnElement(OrderConfirmation.ORDER_CONFIRMATION_CONFIRM_ORDER_BUTTON,"ORDER_CONFIRMATION_CONFIRM_ORDER_BUTTON");

        payPage.enterClientCredentialsPaypage(userData);
        payPage.clickOnElement(PayPage.SUBMIT_TRANSACTION_BUTTON,"SUBMIT_TRANSACTION_BUTTON");
        Assert.assertEquals(driver.findElement(CheckoutPage.TRANSACTION_SUCCESS_TEXT).getText(),"Transaction Success");
    }


    @AfterClass

    public void cleanUp() {
        try {
            driver.close();
            driver.quit();
        } catch (Exception e) {
            System.out.println("some errors occured during closing driver: \n" + e);
        }
    }
}












