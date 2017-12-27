package technical;

import com.relevantcodes.extentreports.ExtentReports;

import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Path;

/**
 * Created by Rus on 23.01.2017.
 */
public class ExtentManager {
    public static ExtentReports extentReports;
    public static Path path = FileSystems.getDefault().getPath(".");
    public final static String filePath = "C:\\Users\\user\\IdeaProjects\\OSCommerce-template-2017new\\user\\IdeaProjects\\OSCommerce-template-2017\\test-output\\Report.html";

    public synchronized static ExtentReports getReporter(String filePath) {
        if (extentReports == null) {
            extentReports = new ExtentReports(filePath, true);
            extentReports.loadConfig(new File("C:\\Users\\user\\IdeaProjects\\OSCommerce-template-2017new\\src\\main\\resources\\extent-config.xml"));
            extentReports
                    .addSystemInfo("Host Name", "Sup")
                    .addSystemInfo("Environment", "Different");
        }
        return extentReports;
    }
}
