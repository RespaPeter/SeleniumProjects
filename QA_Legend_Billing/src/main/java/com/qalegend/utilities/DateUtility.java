package com.qalegend.utilities;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtility {
	public static String getSystemDate()
	{
		DateFormat dateFormat=new SimpleDateFormat("dd-mm-yyyy");
		Date currentDateWithTime=new Date();
		String systemDate=dateFormat.format(currentDateWithTime);
		return systemDate;
		
				
	}
  
}
