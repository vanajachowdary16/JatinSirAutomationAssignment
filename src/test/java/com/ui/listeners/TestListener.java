package com.ui.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.ui.test.TestBase;
import com.utility.BrowserUtility;
import com.utility.ExtentReporterUtility;
import com.utility.loggerUtility;

import java.util.Arrays;

import org.apache.logging.log4j.Logger;

public class TestListener implements ITestListener {
    ExtentSparkReporter sparkReporter;
    ExtentReports extentReports;
    ExtentTest extentTest;

    Logger logger = loggerUtility.getLogger(this.getClass());

    @Override
    public void onStart(ITestContext context) {
        logger.info("test suite started");
        ExtentReporterUtility.setupSparkReporter("extent-report");
       
    }
    @Override
    public void onTestStart(ITestResult result) {
        logger.info(result.getMethod().getMethodName());
        logger.info(result.getMethod().getDescription());
        logger.info(Arrays.toString(result.getMethod().getGroups()));
        ExtentReporterUtility.createExtentTest(result.getMethod().getMethodName());
        
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        logger.info(result.getMethod().getMethodName() + " passed");
        ExtentReporterUtility.getExtentTest().log(Status.PASS, result.getMethod().getMethodName() + " passed");
    }   

    @Override
    public void onTestFailure(ITestResult result) {
        logger.error(result.getMethod().getMethodName() + " failed");
        logger.error(result.getThrowable().getMessage());
        ExtentReporterUtility.getExtentTest().log(Status.FAIL, result.getMethod().getMethodName() + " failed");
        ExtentReporterUtility.getExtentTest().log(Status.FAIL, result.getThrowable().getMessage());
       Object testClass= result.getInstance();
      BrowserUtility browserUtility=((TestBase)testClass).getInstance();
      logger.info("capturing screenshot for the failed test script");
      String screenshotPath=  browserUtility.takeScreenshot(result.getMethod().getMethodName());
      logger.info("attaching screenshot to the html file");
      ExtentReporterUtility.getExtentTest().addScreenCaptureFromPath(screenshotPath);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        logger.warn(result.getMethod().getMethodName() + " skipped");
        ExtentReporterUtility.getExtentTest().log(Status.SKIP, result.getMethod().getMethodName() + " skipped");
    }       

    @Override
    public void onFinish(ITestContext context) {
        logger.info("test suite completed");
        ExtentReporterUtility.flushExtentReports();
    }           
  
}
