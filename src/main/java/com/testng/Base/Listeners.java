package com.testng.Base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.testng.Base.ExtentReporters;

public class Listeners extends Base implements ITestListener {
    ExtentTest extentTest;
    ExtentReports extentReports=ExtentReporters.getReportObject();
    public void onTestStart(ITestResult result) {
        extentTest=extentReports.createTest(result.getMethod().getMethodName());
    }

    public void onTestSuccess(ITestResult result) {
        // not implemented
        extentTest.log(Status.PASS,"Test Passed");
    }

    public void onTestFailure(ITestResult result) {
        // not implemented
        extentTest.fail(result.getThrowable());
        String filePath=takeScreenshot(result.getMethod().getMethodName());
        extentTest.addScreenCaptureFromPath(filePath,result.getMethod().getMethodName());
    }

    public void onTestSkipped(ITestResult result) {
        // not implemented
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // not implemented
    }

    public void onTestFailedWithTimeout(ITestResult result) {
        onTestFailure(result);
    }

    public void onStart(ITestContext context) {
        // not implemented
    }

    public void onFinish(ITestContext context) {
        // not implemented
        extentReports.flush();
    }
}
