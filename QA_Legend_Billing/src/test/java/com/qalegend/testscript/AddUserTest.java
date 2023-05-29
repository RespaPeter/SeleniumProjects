package com.qalegend.testscript;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.qalegend.base.BaseSetUp;
import com.qalegend.constants.Constants;
import com.qalegend.pages.AddUserPage;
import com.qalegend.pages.LogIn;
import com.qalegend.pages.UserManagment;
import com.qalegend.utilities.ExcelUtility;

public class AddUserTest extends BaseSetUp {
	LogIn log;
	AddUserPage addUser;
	UserManagment user;
	@Test(dataProvider = "addUserDetails",priority=2,description = "TC0023 Couldnot add Already existing mail Id and UserName",groups = {"Smoke"})
	  public void enterExistingUserDetails(String uname,String pword,String prefix,String firstName,String lastName,String email,String userName,String passWord,String confirm,String commission){
			
			log=new LogIn(driver);
			addUser=new AddUserPage(driver);
			user=new UserManagment(driver);
			log.validLog(uname, pword);
			log.clickALert();
			user.userMgClick();
			user.userTabClick();
			user.addUser();
			addUser.enterUserDetails(prefix,firstName, lastName, email, userName, passWord, confirm, commission);
			addUser.elementWait();
			addUser.selectRole();
			addUser.selectCheckBox();
			addUser.enterSelectContact();
			addUser.submitButtonClick();
			String actual=addUser.getErrorMail();
			String expected="The Email has already been taken.";
							
	}
  
	@Test(dataProvider = "correctUserDetails",priority=1,description = "TC0024 verify to add a new User",groups = {"Regression"})
	  public void enterUserDetails(String uname,String pword,String prefix,String firstName,String lastName,String email,String userName,String passWord,String confirm,String commission){
			
			log=new LogIn(driver);
			addUser=new AddUserPage(driver);
			user=new UserManagment(driver);
			log.validLog(uname, pword);
			log.clickALert();
			user.userMgClick();
			user.userTabClick();
			user.addUser();
			addUser.enterUserDetails(prefix,firstName, lastName, email, userName, passWord, confirm, commission);
			addUser.elementWait();
			addUser.selectRole();
			addUser.selectCheckBox();
			addUser.enterSelectContact();
			addUser.submitButtonClick();
			String actual=addUser.getMessage();
			String expected="User added successfully";
			Assert.assertEquals(actual,expected,"Could not add new user");
					
	}
  

	@DataProvider(name="addUserDetails")
	  public Object[] UserCredentials() throws InvalidFormatException,IOException{
		Object[][] data=ExcelUtility.getDataFromExcel(System.getProperty("user.dir")+Constants.EXCEL_PATH,"userDetails");
		 return data;
	  }
	@DataProvider(name="correctUserDetails")
	  public Object[] CorrectUserCredentials() throws InvalidFormatException,IOException{
		Object[][] data=ExcelUtility.getDataFromExcel(System.getProperty("user.dir")+Constants.EXCEL_PATH,"correctDetails");
		 return data;
	  }
 
  }
  
