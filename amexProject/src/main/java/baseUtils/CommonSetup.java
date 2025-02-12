package baseUtils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;


public class CommonSetup {
    protected ChromeDriver driver;
    ExtentReports extent;
    ExtentTest test;
    @BeforeTest
    public void setupExtent() {
        extent = ExtentManager.getExtentReports();
    }
    @BeforeMethod
    public void launch() {
        test = ExtentManager.createTest("Validation of Gold Card Application Page Error Messages when filling Junk Data");
        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
        driver = new ChromeDriver();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");
        ExtentManager.test.info("Navigating to the Amex Credit Card HomePage");
        driver.get("https://www.americanexpress.com/fr-fr/?inav=NavLogo");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
    @AfterTest
    public void flushReport(){
        ExtentManager.flushReports();
    }
}

