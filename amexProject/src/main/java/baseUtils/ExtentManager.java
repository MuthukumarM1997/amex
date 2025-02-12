package baseUtils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ExtentManager {
    private static ExtentReports extent;
    public static ExtentTest test;

    public static ExtentReports getExtentReports() {
        LocalDateTime now = LocalDateTime.now(); // Get current date & time
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmm");
        String formattedDateTime = now.format(formatter);
        if (extent == null) {
            ExtentSparkReporter sparkReporter = new ExtentSparkReporter("./test-output/"+formattedDateTime+"" +
                    "ExtentReport.html");
            extent = new ExtentReports();
            extent.attachReporter(sparkReporter);
        }
        return extent;
    }

    public static ExtentTest createTest(String testName) {
        test = getExtentReports().createTest(testName);
        return test;
    }

    public static void logInfo(String message) {
        test.info(message);
    }

    public static void logPass(String message) {
        test.pass(message);
    }

    public static void logFail(String message) {
        test.fail(message);
    }

    public static void flushReports() {
        if (extent != null) {
            extent.flush();
        }
    }
}
