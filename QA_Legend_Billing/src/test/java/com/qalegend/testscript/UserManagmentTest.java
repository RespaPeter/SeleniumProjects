package com.qalegend.testscript;
import java.io.IOException;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.qalegend.base.BaseSetUp;
import com.qalegend.constants.Constants;
import com.qalegend.dataprovider.DataProviderClass;
import com.qalegend.pages.LogIn;
import com.qalegend.pages.UserManagment;
import com.qalegend.utilities.ExcelUtility;



public class UserManagmentTest extends BaseSetUp {

	LogIn log;
	UserManagment user;
	@Test(dataProvider = "UserCredentials", dataProviderClass = DataProviderClass.class,priority=2,description = "TC0018 Verify userManagment Tab Opened Successfullly",groups = {"Regression"})
  public void elementCheck(String uname,String pword){
		
		log=new LogIn(driver);
		user=new UserManagment(driver);
		log.validLog(uname, pword);
		log.clickALert();
		user.userMgClick();
		boolean actual=user.elementCheck();
		Assert.assertEquals(actual, true,"User Managment Tab is not Opened");
		
	}
	@Test(dataProvider = "UserCredentials", dataProviderClass = DataProviderClass.class,priority=2,description = "TC0019 Verify user Tab Opened Successfullly",groups = {"Regression"})
	  public void userTabCheck(String uname,String pword){
			
			log=new LogIn(driver);
			user=new UserManagment(driver);
			log.validLog(uname, pword);
			log.clickALert();
			user.userMgClick();
			user.userTabClick();
			String actual=user.userPageTitle();
			String expected="Users - QAlegend";
			Assert.assertEquals(actual, expected,"User Tab is not opened");
								
		}
	@Test(dataProvider = "UserCredentials", dataProviderClass = DataProviderClass.class,priority=2,description = "TC0020 Verify Adduser button",groups = {"Regression"})
	  public void addUserButton(String uname,String pword){
			
			log=new LogIn(driver);
			user=new UserManagment(driver);
			log.validLog(uname, pword);
			log.clickALert();
			user.userMgClick();
			user.userTabClick();
			user.addUser();
			String actual=user.userPageTitle();
			String expected="Add user - QAlegend";
			Assert.assertEquals(actual, expected,"AddUser is not opened");
						
		}
	@Test(dataProvider = "UserCredentials", dataProviderClass = DataProviderClass.class,priority=2,description = "TC0021 Verify show user button",groups = {"Regression"})
	  public void showUserButton(String uname,String pword){
			
			log=new LogIn(driver);
			user=new UserManagment(driver);
			log.validLog(uname, pword);
			log.clickALert();
			user.userMgClick();
			user.userTabClick();
			user.showUserClick();
			user.selectShowUser();
			user.pageWait();
			
			
			/*String actual=user.getnumberShowUser();
			String expected="Showing 1 to 25 of 1,114 entries";
			Assert.assertEquals(actual, expected,"Show user button not working");
			System.out.println("text="+actual);*/
			
	}	
	@Test(dataProvider = "searchKey",priority=2,description = "TC0022 Verify search user button",groups = {"Regression"})
	  public void searchUserButton(String uname,String pword,String search){
			
			log=new LogIn(driver);
			user=new UserManagment(driver);
			log.validLog(uname, pword);
			log.clickALert();
			user.userMgClick();
			user.userTabClick();
			user.searchUser(search);
			
	}
	@DataProvider(name="searchKey")
	  public Object[] UserCredentials() throws InvalidFormatException,IOException{
		Object[][] data=ExcelUtility.getDataFromExcel(System.getProperty("user.dir")+Constants.EXCEL_PATH,"Sheet4");
		 return data;
	  }
	
}
