package test_scripts;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.ITestResult;

import java.io.File;

public class DriverWrapper {

    protected String email = "shadidultests@gmail.com";
    protected String password = "Test123!!";

    private static WebDriver driver;
    private static String url = "https://pro.housecallpro.com/pro/log_in";


    public void takeScreenShot(String testName) {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File srcFile = ts.getScreenshotAs(OutputType.FILE);
        String destinationPath = "/Users/shad/desktop/errorFile/error" + testName + ".png";

        try {
            // Save the screenshot to the specified path
            FileUtils.copyFile(srcFile, new File(destinationPath));
            System.out.println("Screenshot saved to: " + destinationPath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            takeScreenShot(result.getName());
        }

        driver.quit();
    }


    @BeforeClass
    public void beforeClass() {
        //setChromedriver
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        //init webdriver object
        driver = new ChromeDriver();
        //navigate to the url
        driver.navigate().to(url);

    }

    @AfterClass
    public void afterClass() {
        //quit the browser
        driver.quit();
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static String getUrl() {
        return url;
    }

}
