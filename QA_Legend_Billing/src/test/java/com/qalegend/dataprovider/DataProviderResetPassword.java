package com.qalegend.dataprovider;

import org.testng.annotations.Test;

import com.qalegend.constants.Constants;
import com.qalegend.utilities.ExcelUtility;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.DataProvider;

public class DataProviderResetPassword {
  

	ExcelUtility excel=new ExcelUtility();

	  @DataProvider(name="resetPassword")
	  public Object[][] userData() throws InvalidFormatException,IOException{
		  Object[][] data=excel.getDataFromExcel("C:\\Users\\PRAGAL\\OneDrive\\Documents\\Selenium\\reserPassword.xlsx", "Sheet1");
	    return data;
}
}
