package com.qalegend.testscript;

import java.io.IOException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.qalegend.base.BaseSetUp;
import com.qalegend.constants.Constants;
import com.qalegend.dataprovider.DataProviderClass;
import com.qalegend.dataprovider.DataProviderResetPassword;
import com.qalegend.pages.LogIn;
import com.qalegend.pages.LoginPage;
import com.qalegend.retryAnalyser.Retry;
import com.qalegend.utilities.ExcelUtility;

public class LogTest extends BaseSetUp {
	LogIn log;
 @Test(dataProvider = "UserCredentials",dataProviderClass = DataProviderClass.class,priority = 1, enabled = true, description = "TC001 verify valid Login",groups= {"Smoke"})
  public void logfun(String uname,String pword)throws InvalidFormatException,IOException {
	  log=new LogIn(driver);
	  log.validLog(uname, pword);
	  log.clickALert();
	  String actual=log.getLoginPageTitle();
	  String expected="Home - QAlegend";
	  Assert.assertEquals(actual, expected);
  }
  
  @Test(dataProvider = "UserCredentials",dataProviderClass = DataProviderClass.class,priority = 2, enabled = true, description = "TC002 verify valid LoginPage Title",groups= {"Smoke"})
  public void verifyLoginPageTitle(String uname,String pword)
  {
	  log=new LogIn(driver);
	  log.validLog(uname, pword);
	  String actual=log.getLoginPageTitle();
	  String expected="Home - QAlegend";
	  Assert.assertEquals(actual, expected, "Login Title not Verified");
  }
  @Test(dataProvider = "invalidLogIn",priority = 3, enabled = true, description = "TC003 verify Invalid Login Details",groups= {"Smoke"})
  public void inValidLogin(String uname,String pword)
  {
	  log=new LogIn(driver);
	  log.validLog(uname, pword);
	  String actual=log.getErrorMsg();
	  String expected="These credentials do not match our records.";
	  Assert.assertEquals(actual, expected);
	  
	  
  }
  @Test(priority=4,description = "TC004 Verify remember me CheckBox",groups = {"Regression"},retryAnalyzer = Retry.class)
  public void rememberMe()
  {
	  log=new LogIn(driver);
	  log.clickOnRememberMeButton();
	  Boolean status=log.checkElementSelected();
	  String expected="true";
	  Assert.assertTrue(status,expected);
	
  }
  @Test(priority=5,description = "TC005 Verify ForgotPassword Link",groups = {"Regression"},retryAnalyzer = Retry.class)
  public void forgotPassWord()
  {
	  log=new LogIn(driver);
	  log.clickForgotPword();
	  String actual=log.getLoginPageTitle();
	  String expected="Reset Password - Demo POS";
	 Assert.assertEquals(actual,expected,"Reset Password is not working");
	  
	  
  }
  @Test(dataProvider = "resetPassword",priority=6,description = "TC006 Verify Reset Password Link",groups = {"Regression"},retryAnalyzer = Retry.class)
  public void resetPassWord(String mail,String pass)
  {
	  log=new LogIn(driver);
	  log.clickForgotPword();
	  log.enterMailId(mail);
	  log.submitClick();
	  String actual=log.getElementMessage();
	  String expected="We have e-mailed your password reset link!";
	  Assert.assertEquals(actual, expected,"Reset Password link is not working");
	   
  }
  @DataProvider(name="resetPassword")
	public Object[] UserCredentials() throws InvalidFormatException,IOException{
		Object[][] data=ExcelUtility.getDataFromExcel(System.getProperty("user.dir")+Constants.EXCEL_PATH,"Sheet2");
		 return data;
	}
  @DataProvider(name="invalidLogIn")
	public Object[] InvalidLog() throws InvalidFormatException,IOException{
		Object[][] data=ExcelUtility.getDataFromExcel(System.getProperty("user.dir")+Constants.EXCEL_PATH,"InvalidLoginDetails");
		 return data;
	}
  
}
