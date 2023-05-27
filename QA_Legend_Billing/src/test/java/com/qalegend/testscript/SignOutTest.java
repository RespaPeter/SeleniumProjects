package com.qalegend.testscript;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qalegend.base.BaseSetUp;
import com.qalegend.constants.Constants;
import com.qalegend.dataprovider.DataProviderClass;
import com.qalegend.pages.LogIn;
import com.qalegend.pages.SignOutTabPage;
import com.qalegend.utilities.ExcelUtility;

public class SignOutTest extends BaseSetUp {
	LogIn log;
	 SignOutTabPage signOut;
  @Test(dataProvider = "UserCredentials", dataProviderClass = DataProviderClass.class,priority=1,description = "TC0014 Verify SignOutTab",groups = {"Regression"})
  public void signOutTab(String uname,String pword) {
	  log=new LogIn(driver);
	  log.validLog(uname,pword);
	  signOut=new SignOutTabPage(driver);
	  log.clickALert();
	  signOut.tabClick();
	  String actual=signOut.getWindowTitle();
	  String expected="admin KL";
	  Assert.assertEquals(expected, actual,"Signout Window is not opened");
	  
  }
  @Test(dataProvider = "UserCredentials", dataProviderClass = DataProviderClass.class,priority=1,description = "TC0015 Verify SignOut Button",groups = {"Regression"})
  public void signOutButton(String uname,String pword) {
	  log=new LogIn(driver);
	  log.validLog(uname,pword);
	  signOut=new SignOutTabPage(driver);
	  log.clickALert();
	  signOut.tabClick();
	  signOut.signOutButtonClick();
	  String expected="Login - Demo POS";
	  String actual=signOut.getPageTitle();
	  Assert.assertEquals(expected, actual,"could not signout properly");
  }
  @Test(dataProvider = "UserCredentials", dataProviderClass = DataProviderClass.class,priority=1,description = "TC0016 Verify profile button working",groups = {"Regression"})
  public void profileButton(String uname,String pword) {
	  log=new LogIn(driver);
	  log.validLog(uname,pword);
	  signOut=new SignOutTabPage(driver);
	  log.clickALert();
	  signOut.tabClick();
	  signOut.profileButtonClick();
	  String actual=signOut.getPageTitle();
	  String expected="My Profile - QAlegend";
	  Assert.assertEquals(expected, actual,"could not open profile properly");
	 
  }
	 @Test(dataProvider = "passwordUpdate",priority=1,description = "TC0017 Verify  password change",groups = {"Regression"})
	  public void passwordChanging(String uname,String pword,String current,String newPass,String confPass) {
		  log=new LogIn(driver);
		  log.validLog(uname,pword);
		  signOut=new SignOutTabPage(driver);
		  log.clickALert();
		  signOut.tabClick();
		  signOut.profileButtonClick();
		  signOut.changePassword(current,newPass,confPass);
		  String actual=signOut.passwordUpdateMessage();
		  String expected="Password updated successfully";
		  Assert.assertEquals(expected, actual,"could not update Password");
	 }
	 
	@Test(dataProvider="updateProfile",priority=1,description = "TC0018 verify Edit Profile Details",groups = {"Regression"})
	  public void editProfileDetails(String uname,String pword,String prefix,String firstName,String lastName,String email) {
		  log=new LogIn(driver);
		  log.validLog(uname,pword);
		  signOut=new SignOutTabPage(driver);
		  log.clickALert();
		  signOut.tabClick();
		  signOut.profileButtonClick();
		  signOut.enterDetailsforUpdate(prefix, firstName, lastName, email);
		  signOut.selectLanguage();
		  signOut.ClickUpdateButton();
		  String actual=signOut.getMessage();
		  String expected="Profile updated successfully";
		  Assert.assertEquals(actual, expected,"Profile couldnot update");
	 }
	 @DataProvider(name="updateProfile")
	  public Object[] UserCredentials() throws InvalidFormatException,IOException{
		Object[][] data=ExcelUtility.getDataFromExcel(System.getProperty("user.dir")+Constants.EXCEL_PATH,"updateDetails");
		 return data;
	  }
	 @DataProvider(name="passwordUpdate")
	  public Object[] UpdatePassword() throws InvalidFormatException,IOException{
		Object[][] data=ExcelUtility.getDataFromExcel(System.getProperty("user.dir")+Constants.EXCEL_PATH,"changePassword");
		 return data;
	  }
  
}
