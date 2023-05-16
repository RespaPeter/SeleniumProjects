package com.qalegend.testscript;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import org.testng.annotations.Test;

import com.qalegend.base.BaseSetUp;

import com.qalegend.dataprovider.DataProviderClass;
import com.qalegend.pages.LogIn;



public class LogTest extends BaseSetUp {
	LogIn log;
  @Test(dataProvider = "UserCredentials",dataProviderClass = DataProviderClass.class)
  public void logfun(String uname,String pword)throws InvalidFormatException,IOException {
	  log=new LogIn(driver);
	  log.validLog(uname, pword);
	  log.clickALert();
  }
  /*@DataProvider(name="UserCredentials")
  public Object[] UserCredentials() throws InvalidFormatException,IOException{
	Object[][] data=ExcelUtility.getDataFromExcel(System.getProperty("user.dir")+Constants.EXCEL_PATH,"Sheet1");
	 return data;
  }*/
}
