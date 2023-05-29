package com.qalegend.testscript;

import static org.testng.Assert.assertEquals;

import java.io.IOException;


import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qalegend.base.BaseSetUp;
import com.qalegend.dataprovider.DataProviderClass;
import com.qalegend.pages.HomePage;
import com.qalegend.pages.LogIn;

public class HomeTest extends BaseSetUp {
	LogIn log;
	HomePage home;
	@Test(dataProvider = "UserCredentials", dataProviderClass = DataProviderClass.class,priority=1,description = "TC007 Verify alert box close Sucessfully",groups = {"Regression"})
	  public void closeAlertMessage(String uname,String pword)
	  {
		log=new LogIn(driver);
		log.validLog(uname,pword);
		home=new HomePage(driver);
		home.clickALert();
		
	  }
	
	@Test(dataProvider = "UserCredentials", dataProviderClass = DataProviderClass.class,priority=1,description = "TC008 Verify Loading Home Page successfully",groups = {"Regression"})
	  public void homeCheck(String uname,String pword)
	  {
		log=new LogIn(driver);
		log.validLog(uname,pword);
		home=new HomePage(driver);
		home.clickALert();
		String actual=home.elementText();
		String expected="Welcome efg,";
		Assert.assertEquals(actual, expected);
	    System.out.println("Successfully entered into Home Page");
	  }
@Test(dataProvider = "UserCredentials", dataProviderClass = DataProviderClass.class,priority=1,description = "TC009 verify calculator",groups = {"Sanity"})
  public void calculatorClick(String uname,String pword) throws InvalidFormatException, IOException {
	log=new LogIn(driver);
	log.validLog(uname,pword);
	home=new HomePage(driver);
	home.clickALert();
	
	home.clickElement();
	
	String actualString="Calculator";
	String ExpectedString=home.elementTexte();
	Assert.assertEquals(actualString, ExpectedString,"Calculater couldn't load");
	System.out.println("Calculater Displayed");
	  
  }

   
}
