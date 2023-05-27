package com.qalegend.testscript;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qalegend.base.BaseSetUp;
import com.qalegend.dataprovider.DataProviderClass;
import com.qalegend.pages.LogIn;
import com.qalegend.pages.PosPage;

public class PosTest extends BaseSetUp{
	LogIn log;
	PosPage pos;
  @Test(dataProvider = "UserCredentials", dataProviderClass = DataProviderClass.class,priority=1,description = "TC0010 verify POS Terminal") 
  public void posFunctio(String uname,String pword)   {
  log=new LogIn(driver);
  pos=new PosPage(driver);
  log.validLog(uname,pword);
	log.clickALert();
	pos.clickPos();
	String actual=pos.posTitle();
	String expected="POS Terminal";
	Assert.assertEquals(actual,expected,"POS Window Opened Successfully");
	
	pos.mouseHoverKey();
	pos.selectLocation();
	pos.locationMouseHover();
	//pos.elementWait();
	pos.selectPrice();
  }  
}
  
