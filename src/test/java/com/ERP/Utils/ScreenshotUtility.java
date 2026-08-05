package com.ERP.Utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtility {

    public static String captureScreenshot(WebDriver driver, String testName) {

        TakesScreenshot ts = (TakesScreenshot) driver;

        File source = ts.getScreenshotAs(OutputType.FILE);

        String path = "./Screenshots/" + testName + ".png";

        File destination = new File(path);

        try {

            FileUtils.copyFile(source, destination);

        } catch (IOException e) {

            e.printStackTrace();

        }

        return path;
    }

}