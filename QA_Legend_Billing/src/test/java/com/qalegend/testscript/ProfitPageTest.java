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
	@Test(dataProvider = "UserCredentials", dataProviderClass = DataProviderClass.class,priority=1)
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
		//profit.alertBoxtClose();
		profit.elementWait();
		profit.buttonClose();
		
  }
}
