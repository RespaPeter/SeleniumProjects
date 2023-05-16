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
	@Test(dataProvider = "UserCredentials", dataProviderClass = DataProviderClass.class,priority=1,groups = {"Regression"})
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
@Test(dataProvider = "UserCredentials", dataProviderClass = DataProviderClass.class,priority=1,description = "calculator",groups = {"Regression"})
  public void calculatorClick(String uname,String pword) throws InvalidFormatException, IOException {
	log=new LogIn(driver);
	log.validLog(uname,pword);
	home=new HomePage(driver);
	home.clickALert();
	
	home.clickElement();
	
	String actualString="Calculator";
	String ExpectedString=home.elementTexte();
	Assert.assertEquals(actualString, ExpectedString);
	System.out.println("Calculater Displayed");
	  
  }
/*
 
	@Test(dataProvider = "UserCredentials", dataProviderClass = DataProviderClass.class,priority=2,description = "pos",groups = {"Regression"})
  public void posTerminal()
  {
	 try {
	
		  home=new HomePage(driver);
		  home.clickALert();
		  home.posClick();
		  
	} catch (InvalidFormatException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
  }
  @Test
  public void userManagment() throws InvalidFormatException, IOException
  {
	//  lp.verifyLogin("admin","123456");
	  home=new HomePage(driver);
	  home.clickALert();
	  home.userMgClick();
	 
	boolean s=home.elementDisplayed();
	System.out.print(s);
	  
  }
  */
   
}
