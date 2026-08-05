package com.ERP.Listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.ERP.Utils.ExtentManager;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class TestListener implements ITestListener {

    ExtentReports extent = ExtentManager.getInstance();
    public static ExtentTest test;

    @Override
    public void onStart(ITestContext context) {
        System.out.println("Execution Started...");
    }

    @Override
    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.log(Status.PASS, "Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {

        if(test != null) {
            test.log(Status.FAIL, "Test Failed");
            test.fail(result.getThrowable());
        }

    }
    @Override
    public void onTestSkipped(ITestResult result) {

        if(test != null) {
            test.log(Status.SKIP, "Test Skipped");
        }

    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
        System.out.println("Execution Completed...");
    }
}