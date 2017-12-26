import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import constantElements.CartPopUp;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import sitePages.*;
import technical.ExtentManager;
import technical.User;

import java.io.File;

/**
 * Created by alex on 21.02.2017.
 */
public class EndToEndTest extends ExtentManager{
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
    public ExtentReports extentReport;
    public ExtentTest extentTest;


    @BeforeTest
    public void StartUp() {
        extentReports = ExtentManager.getReporter(ExtentManager.filePath);
        System.setProperty("webdriver.chrome.driver", "C://selenium/chromedriver.exe");
        // System.setProperty("webdriver.gecko.driver", "C://gecko/geckodriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
        driver = new ChromeDriver(options);
        extentReport = new ExtentReports(System.getProperty("user.dir") + "/test-output/Report.html", true);
        extentReport.loadConfig(new File(System.getProperty("user.dir") + "/src/main/resources/extent-config.xml"));
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
                {"http://bestwatchesweb.com"},
                {"http://weddingstuffhub.com"},
               //  {"yourgiftshome.com"},
                // {"http://coolfootwearmart.com"},
                // {"http://adgetsstar.com"},
                // {"http://yourgreatbag.com"},
               //  {"http://weddingstorelab.com"},
                // {"http://yoursupremegifts.com"},
                // {"http://bestaccessoriesnow.com"},
                // {"http://gadgetsstar.com"},
                // {"http://toylandhub.com"},
                // {"http://sunglassesfun.com"},
        };
    }

    @Test(dataProvider = "url-data-provider")
    public void endToEndTest(String url) {
        extentTest = extentReport.startTest("endToEndTest");
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
        if (shoppingCartPage.isElementPresent(ShoppingCartPage.CART_CHECKOUT_BUTTON) == true) {
            shoppingCartPage.clickOnElement(ShoppingCartPage.CART_CHECKOUT_BUTTON, "CART_CHECKOUT_BUTTON");
        } else {
            shoppingCartPage.clickOnElement(ShoppingCartPage.CART_CHECKOUT_BUTTON2, "CART_CHECKOUT_BUTTON2");
        }
        loginPage.waitElementToBeClickable(25, CheckoutPage.LOGIN_PAGE_CONTINUE_BUTTON);
        loginPage.clickOnElement(CheckoutPage.LOGIN_PAGE_CONTINUE_BUTTON, "CONTINUE_BUTTON");

        checkoutPage.waitElementToBeClickable(25, CheckoutPage.FIRST_NAME);
        checkoutPage.threadSleep(5000);
        checkoutPage.clickOnElement(CheckoutPage.MALE_RADIOBUTTON, "MALE_RADIOBUTTON");
        checkoutPage.inputCredentials(userData);
        if (checkoutPage.isElementPresent(CheckoutPage.SHIPPING_PAGE_CONTINUE_BUTTON) == true) {
            checkoutPage.clickOnElement(CheckoutPage.SHIPPING_PAGE_CONTINUE_BUTTON, "SHIPPING_PAGE_CONTINUE_BUTTON");
        } else {
            checkoutPage.clickOnElement(CheckoutPage.SHIPPING_PAGE_CONTINUE_BUTTON2, "SHIPPING_PAGE_CONTINUE_BUTTON2");
        }

        if (createAccountSuccessPage.isElementPresent(CreateAccountSuccessPage.SUCCESS_PAGE_CONTINUE_BUTTON) == true) {
            createAccountSuccessPage.clickOnElement(CreateAccountSuccessPage.SUCCESS_PAGE_CONTINUE_BUTTON, "SUCCESS PAGE_CONTINUE_BUTTON");
        } else {
            createAccountSuccessPage.clickOnElement(CreateAccountSuccessPage.SUCCESS_PAGE_CONTINUE_BUTTON2, "SUCCESS PAGE_CONTINUE_BUTTON");
        }
        if (checkoutShipping.isElementPresent(CheckoutShipping.CHECKOUT_SHIPPING_CONTINUE_BUTTON) == true) {
            checkoutShipping.clickOnElement(CheckoutShipping.CHECKOUT_SHIPPING_CONTINUE_BUTTON, "CHECKOUT_SHIPPING_CONTINUE_BUTTON");
        } else {
            checkoutShipping.clickOnElement(CheckoutShipping.CHECKOUT_SHIPPING_CONTINUE_BUTTON2, "CHECKOUT_SHIPPING_CONTINUE_BUTTON");
        }
        checkoutPayment.selectRadiobuttons();
        if (checkoutPayment.isElementPresent(CheckoutPayment.CHECKOUT_PAYMENT_CONTINUE_BUTTON) == true) {
            checkoutPayment.clickOnElement(CheckoutPayment.CHECKOUT_PAYMENT_CONTINUE_BUTTON, "CHECKOUT_PAYMENT_CONTINUE_BUTTON");
        } else {
            checkoutPayment.clickOnElement(CheckoutPayment.CHECKOUT_PAYMENT_CONTINUE_BUTTON2, "CHECKOUT_PAYMENT_CONTINUE_BUTTON");
        }

        if (orderConfirmation.isElementPresent(OrderConfirmation.ORDER_CONFIRMATION_CONFIRM_ORDER_BUTTON) == true)
            orderConfirmation.clickOnElement(OrderConfirmation.ORDER_CONFIRMATION_CONFIRM_ORDER_BUTTON, "ORDER_CONFIRMATION_CONFIRM_ORDER_BUTTON");
        else {
            orderConfirmation.clickOnElement(OrderConfirmation.ORDER_CONFIRMATION_CONFIRM_ORDER_BUTTON2, "ORDER_CONFIRMATION_CONFIRM_ORDER_BUTTON");
        }
        payPage.enterClientCredentialsPaypage(userData);
        payPage.clickOnElement(PayPage.SUBMIT_TRANSACTION_BUTTON, "SUBMIT_TRANSACTION_BUTTON");
        Assert.assertEquals(driver.findElement(CheckoutPage.TRANSACTION_SUCCESS_TEXT).getText(), "Transaction Success");
    }

    @AfterMethod
 public void getResult(ITestResult result) {
        if (result.getStatus()==ITestResult.FAILURE){
            extentTest.log(LogStatus.FAIL,result.getThrowable());
            if (result.getStatus() == ITestResult.SKIP) {
                extentTest.log(LogStatus.SKIP, "Test skipped " + result.getThrowable());
            } else {
                extentTest.log(LogStatus.PASS, "Test passed");
            }
            extentReport.endTest(extentTest);
            extentReport.flush();
        }

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












