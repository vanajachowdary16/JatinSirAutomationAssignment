package com.utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterUtility {
    private static ExtentSparkReporter sparkReporter;
    private static ExtentReports extentReports;
    private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
    
    public static void setupSparkReporter(String reportName) {
        sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/results/" + reportName + ".html");
        extentReports = new ExtentReports();
        extentReports.attachReporter(sparkReporter);

    }
    public static void createExtentTest(String testName) {
        ExtentTest test = extentReports.createTest(testName); 
        extentTest.set(test);
    }
    public static ExtentTest getExtentTest() {
        return extentTest.get();
    }
    public static void flushExtentReports() {
        extentReports.flush();
    }
    
}
