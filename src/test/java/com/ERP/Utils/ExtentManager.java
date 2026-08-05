package com.ERP.Utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    private static ExtentReports extent;

    public static ExtentReports getInstance() {

        if (extent == null) {

            ExtentSparkReporter spark =
                    new ExtentSparkReporter("Reports/ExtentReport.html");

            spark.config().setReportName("ERP Automation Report");
            spark.config().setDocumentTitle("Automation Test Results");

            extent = new ExtentReports();
            extent.attachReporter(spark);

            extent.setSystemInfo("Tester", "Naga Vijayalakshmi");
            extent.setSystemInfo("Project", "ERP Automation");
            extent.setSystemInfo("Environment", "QA");
        }

        return extent;
    }
}