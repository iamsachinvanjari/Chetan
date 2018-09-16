package com.crm.reports;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.crm.util.TestUtil;

public class ExtentReportListener implements ITestListener {

	private static int counter=0;
	private static ExtentReports extent = ExtentManager.createInstance("Free_CRM_Test_Report_CRC"+counter+++".html");
	
    public static ThreadLocal<ExtentTest> test = new ThreadLocal<ExtentTest>();
	
    @Override
	public synchronized void onStart(ITestContext context) {
    	/*ExtentTest parent = extent.createTest(getClass().getName());
        test.set(parent);*/
	}

	@Override
	public synchronized void onFinish(ITestContext context) {
		extent.flush();
	}
	
	@Override
	public synchronized void onTestStart(ITestResult result) {
		ExtentTest t = extent.createTest(result.getMethod().getMethodName());
        test.set(t);
	}

	@Override
	public synchronized void onTestSuccess(ITestResult result) {
		test.get().pass("Test passed");
	}

	@Override
	public synchronized void onTestFailure(ITestResult result) {
		
			test.get().fail(result.getTestName());
			System.out.println("TEST fAILED");
		
	}

	@Override
	public synchronized void onTestSkipped(ITestResult result) {
		test.get().skip(result.getThrowable());
	}

	@Override
	public synchronized void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}
}

