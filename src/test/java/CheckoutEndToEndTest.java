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
import technical.BasePage;
import technical.ExtentManager;
import technical.User;
import technical.Utility;

import java.io.File;
import java.util.logging.Logger;

/**
 * Created by alex on 21.02.2017.
 */
public class CheckoutEndToEndTest extends ExtentManager {
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
        String browser = "Chrome";
        if (browser == "Chrome") {
            System.setProperty("webdriver.chrome.driver", "C://selenium/chromedriver.exe");
        } else {
            System.setProperty("webdriver.gecko.driver", "C://gecko/geckodriver.exe");
        }


        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
        driver = new ChromeDriver(options);
        extentReport = new ExtentReports(System.getProperty("user.dir") + "/test-output/Report.html", true);
        extentReport.loadConfig(new File(System.getProperty("user.dir") + "/src/main/resources/extent-config.xml"));
        extentTest = extentReport.startTest("endToEndTest");
        extentTest.log(LogStatus.INFO, "Open Home Page");
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


    @Test(description = "Site 1")
    public void CheckoutEndToEndTest_Site_1() {
        homePage.open(BasePage.SiteURL_1);
        homePage.threadSleep(10000);

        extentTest.log(LogStatus.INFO, "Click on first product within HomePage Grid");
        homePage.clickOnElement(HomePage.FIRST_PRODUCT_IN_THE_GRID_SITE_1, "Product Site 1");

        extentTest.log(LogStatus.INFO, "Select color");
        productPage.threadSleep(5000);
        productPage.chooseColor();

        extentTest.log(LogStatus.INFO, "Select size");
        productPage.threadSleep(5000);
        productPage.chooseSize();

        extentTest.log(LogStatus.INFO, "Input product quantity");
        productPage.inputProductsQuantity();

        extentTest.log(LogStatus.INFO, "Click on ADD TO CART BUTTON");
        productPage.clickOnElement(ProductPage.ADDTOCARTBUTTON, "ADD TO CART BUTTON");
        productPage.threadSleep(5000);

        extentTest.log(LogStatus.INFO, "Shopping Cart Icon");
        homePage.clickOnElement(ProductPage.HOP_UP_CHECKOUT_BUTTON, "CHOPPING CART LINK /ICON");

        extentTest.log(LogStatus.INFO, "Checkout Button in the ShoppingCart  ");
        shoppingCartPage.waitElementToBeClickable(ShoppingCartPage.CART_CHECKOUT_BUTTON_SITE_1,25);
        shoppingCartPage.waitAndClickByJS(ShoppingCartPage.CART_CHECKOUT_BUTTON_SITE_1,"CART_CHECKOUT_BUTTON");

        extentTest.log(LogStatus.INFO, "Login page Continue Button");
        loginPage.waitElementToBeClickable( CheckoutPage.LOGIN_PAGE_CONTINUE_BUTTON,25);

        loginPage.clickOnElement(CheckoutPage.LOGIN_PAGE_CONTINUE_BUTTON, "CONTINUE_BUTTON");

        checkoutPage.waitElementToBeClickable( CheckoutPage.FIRST_NAME,2);
        checkoutPage.threadSleep(5000);
        checkoutPage.clickOnElement(CheckoutPage.MALE_RADIOBUTTON, "MALE_RADIOBUTTON");

        extentTest.log(LogStatus.INFO, "Insert Credentials on shipping page");
        checkoutPage.inputCredentials(userData);

        extentTest.log(LogStatus.INFO, "Click on continue to billing");
        checkoutPage.clickOnElement(CheckoutPage.SHIPPING_PAGE_CONTINUE_BUTTON_SITE_1, "SHIPPING_PAGE_CONTINUE_BUTTON");
        createAccountSuccessPage.clickOnElement(CreateAccountSuccessPage.SUCCESS_PAGE_CONTINUE_BUTTON_SITE_1, "SUCCESS PAGE_CONTINUE_BUTTON");
        checkoutShipping.clickOnElement(CheckoutShipping.CHECKOUT_SHIPPING_CONTINUE_BUTTON_SITE_1, "CHECKOUT_SHIPPING_CONTINUE_BUTTON");

        extentTest.log(LogStatus.INFO, "Select Radiobuttons");
        checkoutPayment.selectRadiobuttons();

        extentTest.log(LogStatus.INFO, "Click on Continue to CONFIRM ORDER");
        checkoutPayment.clickOnElement(CheckoutPayment.CHECKOUT_PAYMENT_CONTINUE_BUTTON_SITE_1, "CHECKOUT_PAYMENT_CONTINUE_BUTTON");


        extentTest.log(LogStatus.INFO, "Click on CONFIRM_ORDER_BUTTON_SITE_1");
        orderConfirmation.clickOnElement(OrderConfirmation.ORDER_CONFIRMATION_CONFIRM_ORDER_BUTTON_SITE_1, "ORDER_CONFIRMATION_CONFIRM_ORDER_BUTTON");

        extentTest.log(LogStatus.INFO, "Fill the data at the Paypage");
        payPage.enterClientCredentialsPaypage(userData);
        payPage.clickOnElement(PayPage.SUBMIT_TRANSACTION_BUTTON, "SUBMIT_TRANSACTION_BUTTON");

        extentTest.log(LogStatus.INFO, "Assert the transaction success page is ok");
        Assert.assertEquals(driver.findElement(CheckoutPage.TRANSACTION_SUCCESS_TEXT).getText(), "Transaction Success");
    }


  //  @Test(description = "Site 2")
    public void CheckoutEndToEndTest_Site_2() {
        homePage.open(BasePage.SiteURL_2);
        homePage.threadSleep(10000);

        extentTest.log(LogStatus.INFO, "Click on first product within HomePage Grid");
        homePage.clickOnElement(HomePage.FIRST_PRODUCT_IN_THE_GRID_SITE_2, "FIRST_PRODUCT_IN_THE_GRID_SITE_2");

        extentTest.log(LogStatus.INFO, "Select color");
        productPage.threadSleep(5000);

        productPage.chooseColor();

        extentTest.log(LogStatus.INFO, "Select size");
        productPage.threadSleep(5000);
        productPage.chooseSize();

        extentTest.log(LogStatus.INFO, "Input product quantity");
        productPage.inputProductsQuantity();

        extentTest.log(LogStatus.INFO, "Click on Add to Cart Button");
        productPage.clickOnElement(ProductPage.ADDTOCARTBUTTON, "Add to cart Button");

        extentTest.log(LogStatus.INFO, "Shopping Cart Icon");
        homePage.clickOnElement(ProductPage.HOP_UP_CHECKOUT_BUTTON, "Checkout Cart icon Site 2");

        extentTest.log(LogStatus.INFO, "Cart Checkout Button");
        shoppingCartPage.clickOnElement(ShoppingCartPage.CART_CHECKOUT_BUTTON_SITE_2, "CART_CHECKOUT_BUTTON2");


        extentTest.log(LogStatus.INFO, "Login page continue Button ");
        loginPage.waitElementToBeClickable(CheckoutPage.LOGIN_PAGE_CONTINUE_BUTTON,25);
        loginPage.clickOnElement(CheckoutPage.LOGIN_PAGE_CONTINUE_BUTTON, "CONTINUE_BUTTON");

        checkoutPage.waitElementToBeClickable(CheckoutPage.FIRST_NAME,25);
        checkoutPage.threadSleep(5000);
        checkoutPage.clickOnElement(CheckoutPage.MALE_RADIOBUTTON, "MALE_RADIOBUTTON");
        extentTest.log(LogStatus.INFO, "Insert Credentials on shipping page");
        checkoutPage.inputCredentials(userData);


        extentTest.log(LogStatus.INFO, "Click on continue to billing");

        checkoutPage.clickOnElement(CheckoutPage.SHIPPING_PAGE_CONTINUE_BUTTON_SITE_2, "SHIPPING_PAGE_CONTINUE_BUTTON2");


        createAccountSuccessPage.clickOnElement(CreateAccountSuccessPage.SUCCESS_PAGE_CONTINUE_BUTTON_SITE_2, "SUCCESS PAGE_CONTINUE_BUTTON");


        checkoutShipping.clickOnElement(CheckoutShipping.CHECKOUT_SHIPPING_CONTINUE_BUTTON2_SITE_2, "CHECKOUT_SHIPPING_CONTINUE_BUTTON");

        extentTest.log(LogStatus.INFO, "Select Radio Buttons");
        checkoutPayment.selectRadiobuttons();

        checkoutPayment.clickOnElement(CheckoutPayment.CHECKOUT_PAYMENT_CONTINUE_BUTTON_SITE_2, "CHECKOUT_PAYMENT_CONTINUE_BUTTON");

        extentTest.log(LogStatus.INFO, "Click on CONFIRM_ORDER_BUTTON_SITE_1");
        orderConfirmation.clickOnElement(OrderConfirmation.ORDER_CONFIRMATION_CONFIRM_ORDER_BUTTON_SITE_2, "ORDER_CONFIRMATION_CONFIRM_ORDER_BUTTON");

        extentTest.log(LogStatus.INFO, "Fill the data at the Paypage");
        payPage.enterClientCredentialsPaypage(userData);
        payPage.clickOnElement(PayPage.SUBMIT_TRANSACTION_BUTTON, "SUBMIT_TRANSACTION_BUTTON");

        extentTest.log(LogStatus.INFO, "Assert the transaction success page is ok");
        Assert.assertEquals(driver.findElement(CheckoutPage.TRANSACTION_SUCCESS_TEXT).getText(), "Transaction Success");
    }


   // @Test(description = "Site 3")
    public void CheckoutEndToEndTest_Site_3() {

    }


 //   @Test(description = "Site 5")
    public void CheckoutEndToEndTest_Site_5() {

    }


  //  @Test(description = "Site 6")
    public void CheckoutEndToEndTest_Site_6() {

    }

  ///  @Test(description = "Site 7")
    public void CheckoutEndToEndTest_Site_7() {

    }


  //  @Test(description = "Site 8")
    public void CheckoutEndToEndTest_Site_8() {

    }


  //  @Test(description = "Site 9")
    public void CheckoutEndToEndTest_Site_9() {

    }

   // @Test(description = "Site 10")
    public void CheckoutEndToEndTest_Site_10() {

    }


    @AfterMethod
    public void getResult(ITestResult result) throws Exception {
        if (result.getStatus() == ITestResult.FAILURE) {
            String screenshot_path = Utility.captureScreenshot(driver, result.getName());
            extentTest.log(LogStatus.FAIL, result.getThrowable());
            extentTest.log(LogStatus.FAIL, "Snapshot below: " + extentTest.addScreenCapture(screenshot_path));
        } else {
            if (result.getStatus() == ITestResult.SKIP) {
                extentTest.log(LogStatus.SKIP, "Test skipped " + result.getThrowable());
            } else {
                extentTest.log(LogStatus.PASS, "Test passed");
            }
        }

        extentReports.endTest(extentTest);
        extentReports.flush();
    }

    @AfterClass

    public void cleanUp() {
        extentReport.flush();
        try {
            driver.close();
            driver.quit();
        } catch (Exception e) {
            System.out.println("some errors occured during closing driver: \n" + e);
        }
    }

}












