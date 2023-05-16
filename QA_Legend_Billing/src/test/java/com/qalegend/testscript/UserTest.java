package com.qalegend.testscript;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qalegend.base.BaseSetUp;
import com.qalegend.dataprovider.DataProviderClass;
import com.qalegend.pages.LogIn;

public class UserTest extends BaseSetUp {
	
	LogIn log;
	User useOb;
@Test(dataProvider = "UserCredentials", dataProviderClass = DataProviderClass.class,priority=1,groups = {"Regression"})
  
  public void userMethod(String uname,String pword) {
	log=new LogIn(driver);
	useOb=new User(driver);
	log.validLog(uname,pword);
	log.clickALert();
	useOb.javaClick();
	//useOb.elementWait();
	useOb.javaClickUser();
	String actual=useOb.elementText();
	String expected="Users Manage users";
	Assert.assertEquals(actual,expected, "User tab Opened Successfully");
}
	public void addNewUser(String uname,String pword) {
			log=new LogIn(driver);
			useOb=new User(driver);
			log.validLog(uname,pword);
			log.clickALert();
			useOb.javaClick();
			//useOb.elementWait();
			useOb.javaClickUser();
			useOb.elementWait();
			useOb.clickAction();
		//	useOb.elementClick();
		//	useOb.selectDropdown();
	
	
	
  }

}
