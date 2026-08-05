package com.ERP.Base;
import com.aventstack.extentreports.ExtentTest;
import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.ERP.Listeners.TestListener;
import com.ERP.Pages.AdminLogin;
import com.ERP.Utils.ConfigReader;
import com.ERP.Utils.ScreenshotUtility;

public class BaseTest {

	public static Logger logger =
            LogManager.getLogger(BaseTest.class);
	ExtentTest test;
    public WebDriver driver;
    @BeforeMethod
    public void setup(ITestResult result) {

        String browser =
                ConfigReader.getProperty("BROWSER");
        
        
        if(browser.equalsIgnoreCase("chrome")) {
        	logger.info("Launching Chrome Browser");
            driver = new ChromeDriver();
            

        }

        driver.manage().window().maximize();

        driver.manage().timeouts()
              .implicitlyWait(Duration.ofSeconds(10));


        driver.get(ConfigReader.getProperty("BASE_URL"));
        logger.info("Application URL opened successfully");

        logger.info("Starting ERP Login");
        AdminLogin login = new AdminLogin(driver);

        login.ERPLogin(
                ConfigReader.getProperty("BASE_USER"),
                ConfigReader.getProperty("BASE_PASS")
        );


        System.out.println("Login Successful");
        logger.info("Login Successful");
    }

    @AfterMethod
    public void tearDown(ITestResult result) {

    	if (result.getStatus() == ITestResult.FAILURE) {

    	    String screenshotPath =
    	            ScreenshotUtility.captureScreenshot(driver, result.getName());

    	    if (TestListener.test != null) {
    	        TestListener.test.fail(result.getThrowable());

    	        try {
    	            TestListener.test.addScreenCaptureFromPath(screenshotPath);
    	        } catch (Exception e) {
    	            e.printStackTrace();
    	        }
    	    }
    	}

        if(driver != null) {
        	 logger.info("Closing Browser");
        	driver.quit();
        }
    }

}