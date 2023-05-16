package com.qalegend.testscript;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qalegend.base.BaseSetUp;
import com.qalegend.dataprovider.DataProviderClass;
import com.qalegend.pages.LogIn;
import com.qalegend.pages.UserManagment;



public class UserManagmentTest extends BaseSetUp {

	LogIn log;
	UserManagment user;
	@Test(dataProvider = "UserCredentials", dataProviderClass = DataProviderClass.class,priority=2,description = "userManagment",groups = {"Regression"})
  public void elementCheck(String uname,String pword) {
		
		log=new LogIn(driver);
		user=new UserManagment(driver);
		log.validLog(uname, pword);
		log.clickALert();
		user.userMgClick();
		user.elementWait();
		String expectedValue="true";
		boolean actualvalue=user.elementDisplayed();
		System.out.println(actualvalue);
		System.out.println(expectedValue);
		/*Assert.assertEquals(actualvalue, expectedValue);
		System.out.println("Menu Dispalyed");
		*/
		
  }
}
