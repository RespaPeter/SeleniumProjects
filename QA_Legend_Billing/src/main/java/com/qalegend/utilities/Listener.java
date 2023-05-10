package com.qalegend.utilities;
import com.qalegend.automationcore.BaseSetup;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener extends BaseSetup implements ITestListener {
	
	public void onTestStart(ITestResult result) {
	
		ScreenShotUtility.screenshotMethod((result.getName());
		
	}
	
	public void onTestSuccess(ITestResult result) {
		
	}
	public void onTestFailure(ITestResult result) {
		
		
		
	}
	
	public void onTestSkipped(ITestResult result) {
		
	}
	
	public void onTestFaileButWithinSuccessPercentage(ITestResult result) {
		
	}
	
	public void onStart(ITestContext context) {
		
	}
	
	public void onFinish(ITestContext context) {
		
	}


	


}
