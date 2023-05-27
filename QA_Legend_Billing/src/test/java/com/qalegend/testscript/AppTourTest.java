package com.qalegend.testscript;

import org.testng.annotations.Test;

import com.qalegend.base.BaseSetUp;
import com.qalegend.dataprovider.DataProviderClass;
import com.qalegend.pages.AppTourPage;
import com.qalegend.pages.LogIn;


public class AppTourTest extends BaseSetUp{
	LogIn log;
	AppTourPage app;
  @Test(dataProvider = "UserCredentials", dataProviderClass = DataProviderClass.class,priority=1,description="TC00 Verify Application Tour Tab Opened") 
  public void appTourCheck(String uname,String pword) {
	  log=new LogIn(driver);
	  app=new AppTourPage(driver);
	  log.validLog(uname,pword);
	  app.applicationTourTab();
	  
	 // app.elementWait();
	  //app.windowWait();
	//  app.clickALert();
	  
	  
  }
}
