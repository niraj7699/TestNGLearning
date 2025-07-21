package com.testng.Base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporters {

    public static ExtentReports getReportObject(){
        String path=System.getProperty("user.dir")+"\\ExtentReports\\extentreport.html";
        ExtentSparkReporter reporter=new ExtentSparkReporter(path);
        reporter.config().setReportName("Web Automation Results");
        reporter.config().setDocumentTitle("Test Results");

        ExtentReports extentReports=new ExtentReports();
        extentReports.attachReporter(reporter);
        extentReports.setSystemInfo("Tester","Niraj Kumar");
        return extentReports;
    }
}
