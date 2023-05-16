package com.qalegend.utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.qalegend.base.BaseSetUp;

public class ScreenshotUtility extends BaseSetUp{
	
	public static void takeScreenshot(String name) throws IOException {
		

		TakesScreenshot takesScreenshot = (TakesScreenshot)driver;
		File screenshot = takesScreenshot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot, new File(".//src/main//resources/screenshot//" + name + ".png"));
}
}