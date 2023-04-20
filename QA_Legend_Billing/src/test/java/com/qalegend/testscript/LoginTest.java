package com.qalegend.testscript;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qalegend.automationcore.Base;
import com.qalegend.constants.Constants;
import com.qalegend.pages.LoginPage;
import com.qalegend.utilities.ExcelUtility;



public class LoginTest extends Base{
	LoginPage login;
  @Test(dataProvider="UserCredentials",priority=1,description = "verify valid login",groups = {"Regression"})
  public void verifyLogin(String uname,String pword)throws InvalidFormatException,IOException {
	  login=new LoginPage(driver);
	  System.out.println("Username"+uname);
	  System.out.println("Password"+pword);
	  login.enterUserName(uname);
	  login.enterUserPassword(pword);
	 /* login.enterUserName("admin");
	  login.enterUserPassword("123456");*/
	  login.loginButtonClick();
	  String actualUrl=login.currentUrl();
	  String expectedUrl="https://qalegend.com/billing/public/home";
	  Assert.assertEquals(actualUrl, expectedUrl);
	  System.out.println("Login Successfully");
	  
	  
  }
  @Test(priority=2,description = "verify Invalid login",groups = {"Smoke"})
  public void verifyInvalidLogin() {
	  login=new LoginPage(driver);
	  login.enterUserName("admin");
	  login.enterUserPassword("123");
	  login.loginButtonClick();
	  String actualMessage=login.getErrorMessage();
	  String expectedMessage="These credentials do not match our records.";
	Assert.assertEquals(expectedMessage, actualMessage);
	System.out.println(actualMessage);
	
	  
  }
  @Test(priority=1,description = "verify login page title",groups = {"Smoke"})
  public void verifyLoginTitle() {
	  login=new LoginPage(driver);
	  String expectedPageTitle="Home - QAlegend";
	  String actualPageTitle=login.getLoginPageTitle();
	  Assert.assertEquals(actualPageTitle,expectedPageTitle);
	  System.out.println("Logined Successfully");
	  
  }
  @Test(priority=2,description = "remember me button",groups = {"Regression"})
  public void rememberMe()
  {
	  login=new LoginPage(driver);
	  login.clickOnRememberMeButton();
	  Boolean status=login.checkElementSelected();
	//  System.out.println(status);
	  //Assert.assertEquals(status, true);
	  Assert.assertTrue(status);
	  //Assert.assertEquals(true, status);
	  System.out.println("Checkbox is selected");
  }
  @DataProvider(name="UserCredentials")
  public Object[] UserCredentials() throws InvalidFormatException,IOException{
	Object[][] data=ExcelUtility.getDataFromExcel(System.getProperty("user.dir")+Constants.EXCEL_PATH,"Sheet1");
	 return data;
  }

}
