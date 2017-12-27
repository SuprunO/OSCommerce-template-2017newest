package technical;

import com.relevantcodes.extentreports.ExtentReports;

import java.io.File;

/**
 * Created by Rus on 23.01.2017.
 */
public class ExtentManager {
    public static ExtentReports extentReports;

    public final static String filePath = ":\\Users\\user\\IdeaProjects\\OSCommerce-Template-2017new\\test-output\\Extent.html";

    public synchronized static ExtentReports getReporter(String filePath) {
        if (extentReports == null) {
            extentReports = new ExtentReports(filePath, true);
            extentReports.loadConfig(new File(System.getProperty("user.dir") +"\\src\\main\\resources\\extent-config.xml"));
            extentReports
                    .addSystemInfo("Host Name", "Sup")
                    .addSystemInfo("Environment", "Different");
        }
        return extentReports;
    }
}
