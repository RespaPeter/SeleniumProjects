package com.qalegend.testscript;

import java.io.IOException;


import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.Test;

import com.qalegend.pages.HomePage;

public class HomeTest extends LoginTest {
	HomePage home=new HomePage(driver);
	//@Test(dataProvider = "UserCredentials", dataProviderClass = LoginTest.class,priority=1,description = "calculator",groups = {"Regression"})
	@Test(priority=1,description = "calculator",groups = {"Regression"})
  public void calculatorClick() throws InvalidFormatException, IOException {
		verifyLogin("admin","123456");
		
	 home=new HomePage(driver);
	 home.clickALert();
	  home.clickElement();
	  
  }
  @Test(priority=2,description = "pos",groups = {"Regression"})
  public void posTerminal()
  {
	 try {
		verifyLogin("admin","123456");
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
	  verifyLogin("admin","123456");
	  home=new HomePage(driver);
	  home.clickALert();
	  home.userMgClick();
	 
	boolean s=home.elementDisplayed();
	System.out.print(s);
	  
  }
  
   
}
