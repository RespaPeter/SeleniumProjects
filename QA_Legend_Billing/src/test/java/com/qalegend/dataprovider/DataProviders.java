package com.qalegend.dataprovider;


import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.DataProvider;

import com.qalegend.utilities.ExcelUtility;

public class DataProviders {
  ExcelUtility excel=new ExcelUtility();

  @DataProvider(name="userCredentials")
  public Object[][] userData() throws InvalidFormatException,IOException{
	  Object[][] data=excel.getDataFromExcel("C:\\Users\\PRAGAL\\OneDrive\\Documents\\Selenium\\login.xlsx", "Sheet1");
    return data;
   
  }
}
