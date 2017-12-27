package technical;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;

/**
 * Created by Rus on 05.02.2017.
 */
public class Utility {
    public static String captureScreenshot(WebDriver driver, String screenshotName){
        try {
            TakesScreenshot ts=(TakesScreenshot)driver;
            File source=ts.getScreenshotAs(OutputType.FILE);
            String dest = "C:\\Users\\user\\IdeaProjects\\OSCommerce-template-2017new\\target\\screenshots\\" + screenshotName + ".png";
            File destination = new File(dest);
            FileUtils.copyFile(source,destination);

            System.out.println("ScreenShot Taken");
            return dest;
        } catch (Exception e) {
            System.out.println("Exception_while_taking_Screenshot"+e.getMessage());
            return e.getMessage();
        }
    }
}
