package com.qalegend.testscript;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qalegend.base.BaseSetUp;
import com.qalegend.dataprovider.DataProviderClass;
import com.qalegend.pages.LogIn;
import com.qalegend.pages.ProfitPage;

public class ProfitPageTest extends BaseSetUp {
	LogIn log;
	ProfitPage profit;

	@Test(dataProvider = "UserCredentials", dataProviderClass = DataProviderClass.class,description = "TC0011 verify Today's Profit tab clickable",priority=1,groups = {"Regression"})
	public void profitMethod(String uname,String pword) {
		log=new LogIn(driver);
		profit=new ProfitPage(driver);
		log.validLog(uname,pword);
		log.clickALert();
		profit.clickElement();
		profit.elementWait();
		String actual=profit.getTitle();
		String expected="Today's profit";
		Assert.assertEquals(actual, expected, "Profit Details Displayed Successfully");
	}
		@Test(dataProvider = "UserCredentials", dataProviderClass = DataProviderClass.class,description = "TC0012 verify Today's Profit close Button",priority=1,groups = {"Regression"})
	  public void profitCloseButton(String uname,String pword) {
			log=new LogIn(driver);
			profit=new ProfitPage(driver);
			log.validLog(uname,pword);
			log.clickALert();
			profit.clickElement();
			profit.elementWait();
			profit.buttonClose();
		}
		@Test(dataProvider = "UserCredentials", dataProviderClass = DataProviderClass.class,description = "TC0013 verify Today's Profit close Sign",priority=1,groups = {"Regression"})
	  public void profitCloseSign(String uname,String pword) {
			log=new LogIn(driver);
			profit=new ProfitPage(driver);
			log.validLog(uname,pword);
			log.clickALert();
			profit.clickElement();
			profit.elementWait();
			profit.closeSign();
			
			String actual=profit.getTitle();
			System.out.println("set="+actual);
			
		}
	
	
  }

