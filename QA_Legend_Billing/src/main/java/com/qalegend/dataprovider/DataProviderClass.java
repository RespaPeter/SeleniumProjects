package com.qalegend.dataprovider;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.DataProvider;

import com.qalegend.constants.Constants;
import com.qalegend.utilities.ExcelUtility;

public class DataProviderClass {
	@DataProvider(name="UserCredentials")
	  public Object[] UserCredentials() throws InvalidFormatException,IOException{
		Object[][] data=ExcelUtility.getDataFromExcel(System.getProperty("user.dir")+Constants.EXCEL_PATH,"Sheet1");
		 return data;
	  }
	
}