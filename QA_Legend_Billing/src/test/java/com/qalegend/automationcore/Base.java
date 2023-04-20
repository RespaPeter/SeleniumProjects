package com.qalegend.automationcore;



import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import com.qalegend.constants.Constants;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

public class Base {
	public WebDriver driver;
	public Properties prop;
	public FileInputStream fs;
	public Base()
	{
		prop=new Properties();
		try
		{
		fs=new FileInputStream(System.getProperty("user.dir")+Constants.CONFIG_FILE);
		}
		catch (FileNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		try {
			prop.load(fs);
			
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	 @BeforeMethod(alwaysRun = true)
	  @Parameters({"browser"})
	  public void setUp(@Optional("chrome")String b) {
		  getBrowser(b);
		  String url=prop.getProperty("url");
		  driver.get(url);
		  		 
	  }
 
  public void getBrowser(String b) {
	  
	  if(b.equals("chrome"))
	  {
		  System.setProperty("webdriver.http.factory", "jdk-http-client");
		  System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+Constants.BROWSER_PATH);
		  driver =new ChromeDriver();
		  driver.manage().window().maximize();
		  	
	  }
	  else
	  {
		  System.setProperty("webdriver.http.factory", "jdk-http-client");
		  System.setProperty("webdriver.edge.driver",System.getProperty("user.dir")+Constants.EDGE_PATH);
		  driver = new EdgeDriver();
		  driver.manage().window().maximize();
		  }
  }
 

  @AfterMethod(alwaysRun = true)
  public void tearDown(ITestResult result)throws IOException {
	  if(result.getStatus()==ITestResult.FAILURE)
	  {
		  TakesScreenshot takeScreenShot=(TakesScreenshot)driver;
		  File screenshot=takeScreenShot.getScreenshotAs(OutputType.FILE);
		  FileUtils.copyFile(screenshot,new File("./Screenshots/"+result.getName()+".png"));
	  }
	 // driver.quit();
  }

}
