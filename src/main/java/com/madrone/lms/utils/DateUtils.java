package com.madrone.lms.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import com.madrone.lms.entity.LeaveStatusEnum;

public class DateUtils {

	
	public static final String pattern = "dd/MM/yyyy";
	private static SimpleDateFormat sdfDate = new SimpleDateFormat(pattern);
	
	
	public static Calendar convertStringToCalendar(String stringDate) {
		Calendar cal  = Calendar.getInstance();
		
		try {
			cal.setTime(sdfDate.parse(stringDate));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return cal;
	}
	
	
	public static Date convertStringToDate(String stringDate) {
		Date now = new Date();
		try {
			now =  sdfDate.parse(stringDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return now;
		
	}
	
	public static String convertCalendarToString(Calendar cal) {
		String returnString = "";
		Date d1 = cal.getTime();
    	returnString =  sdfDate.format(d1);

    	return returnString;
		
	}

	
	
}


