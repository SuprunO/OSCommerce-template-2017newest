package sitePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import technical.BasePage;

public class CreateAccountSuccessPage extends BasePage {
    public CreateAccountSuccessPage(WebDriver driver) {
        super(driver);
    }

    public static final By SUCCESS_PAGE_CONTINUE_BUTTON_SITE_1 = By.cssSelector("#tdb5");
    public static final By SUCCESS_PAGE_CONTINUE_BUTTON_SITE_2 = By.cssSelector("#tdb4");

}
