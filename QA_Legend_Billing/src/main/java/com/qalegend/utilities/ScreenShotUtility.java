package com.qalegend.utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.Test;

public class ScreenShotUtility {
	WebDriver driver;
  @Test
  public void screenshotMethod(String s) throws IOException {
	  if(result.getStatus()==ITestResult.FAILURE)
	  {
		  TakesScreenshot takeScreenShot=(TakesScreenshot)driver;
		  File screenshot=takeScreenShot.getScreenshotAs(OutputType.FILE);
		  FileUtils.copyFile(screenshot,new File("./Screenshots/"+result.getName()+".png"));
	  }
  
	  else if(result.getStatus()==ITestResult.SUCCESS)
	  {
		  TakesScreenshot takeScreenShot=(TakesScreenshot)driver;
		  File screenshot=takeScreenShot.getScreenshotAs(OutputType.FILE);
		  FileUtils.copyFile(screenshot,new File("./Screenshots/"+result.getName()+".png"));
	  }
  }
}
