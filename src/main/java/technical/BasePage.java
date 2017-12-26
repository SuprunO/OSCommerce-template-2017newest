package technical;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.testng.Assert.assertTrue;


/**
 * Created by alex on 07.02.2017.
 */
public class BasePage {

    //INPUT THE SITE NAME TO CHECK HERE:
    public static String SiteURL = "http://" + "weddingdev.com";
    //-------------------------------------------------------------
    public WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    private static final org.apache.log4j.Logger LOGGER = org.apache.log4j.Logger.getLogger(BasePage.class);


    public void waitByLinkText(String ByLinkText) {
        WebDriverWait waitForOne = new WebDriverWait(driver, 25);
        waitForOne.until(ExpectedConditions.elementToBeClickable(By.linkText(ByLinkText)));
    }


    public void clickOnСSSSelector(String CSSSelector) {
        driver.findElement(By.cssSelector(CSSSelector)).click();
    }

    public void hoverAndClick(WebDriver driver, WebElement clickElement) {
        Actions action = new Actions(driver);
        action.moveToElement(clickElement).build().perform();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        clickElement.click();
    }

    public WebElement findProductByText(String name, By locator) {
        List<WebElement> products = driver.findElements(locator);
        for (WebElement product : products) {
            if (product.getText().contains(name)) {
                return product;
            }
        }
        return null;
    }

//    public WebElement findPriceByProductName(String name) {
//        return findProductByText(name).findElement(By.xpath("../../p[2]"));
//    }

    /**
     * Opens Home Page entering url into the address field.
     */
    public void open(String url) {
        LOGGER.info("Opening URL: " + url);
        driver.get(url);
        driver.manage().window().maximize();
    }

    /**
     * Checks if specified an element is present on the current the page.
     * Note: for Ajax or elements with delayed appearing: "wait"|fluent-wait methods should be used.
     *
     * @param elementLocator By locator of target element
     * @return Boolean
     */
    public boolean isElementPresent(By elementLocator) {
        return !driver.findElements(elementLocator).isEmpty();
    }


    /**
     * Used to encapsulate required check before any interaction with UI element.
     *
     * @param locator     "By" class locator to search input field.
     * @param elementName String descriptive name of the element(just for pretty logs).
     */
    public void assertPresenceAndDisplay(By locator, String elementName) {
        assertTrue(isElementPresent(locator), "FAILED TO FIND ELEMENT: " + elementName);
        assertTrue(driver.findElement(locator).isDisplayed(), "FAILED TO DETECT VISIBILITY OF THE ELEMENT: " + elementName);
    }

    /**
     * Method that finds element by locator with class "By" and clicks on it.
     *
     * @param locator     "By" class locator to search input field.
     * @param elementName String descriptive name of the element(just for pretty logs).
     */
    public void clickOnElement(By locator, String elementName) {
        assertPresenceAndDisplay(locator, elementName);
        LOGGER.info("Clicking on: " + elementName);
        driver.findElement(locator).click();
    }


    /**
     * Causes the currently executing thread to sleep (temporarily cease execution)
     * for the specified number of milliseconds, subject to the precision and accuracy of system timers and schedulers.
     * The thread does not lose ownership of any monitors
     *
     * @param millis the length of time to sleep in milliseconds
     */

    public void threadSleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Models a condition that might reasonably be expected to eventually evaluate to something that is neither null nor false.
     *
     * @param sec     the length of time to sleep in milliseconds
     * @param locator "By" class locator to search input field.
     */


    public void waitElementToBeClickable(int sec, By locator) {
        WebDriverWait wait = new WebDriverWait(driver, sec);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    /**
     * Method that finds input field by locator with class "By" and fills in specified value.
     *
     * @param locator     "By" class locator to search Dropdown field.
     * @param value       String value that filles into the input.
     * @param elementName String descriptive name of the element(just for pretty logs).
     */
    public void selectValueInDropDown(By locator, String value, String elementName) {
        assertPresenceAndDisplay(locator, elementName);
      //  LOGGER.info("Selecting: \"" + value + "\" in the : " + elementName);
        Select dropDown = new Select(driver.findElement(locator));
        dropDown.selectByVisibleText(value);
    }


    /**
     * Method that finds input field by locator with class "By" and fills in specified value.
     *
     * @param locator     "By" class locator to search input field.
     * @param value       String value that fills into the input.
     * @param elementName String descriptive name of the element(just for pretty logs).
     */
    public void fillInInputField(By locator, String value, String elementName) {
        assertPresenceAndDisplay(locator, elementName);
    //    LOGGER.info("Typing in: \"" + value + "\" into the : " + elementName);
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(value);
    }


    public void selectFromDropdownV2(By locator, String text) {
        Select dropdown = new Select(driver.findElement(locator));
        dropdown.selectByVisibleText(text);
    }
}




