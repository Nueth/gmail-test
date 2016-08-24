package com.course.gmail.helpers;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Helpers {
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
	public static String date = sdf.format(new Date());
	
	public static String getUniqueText(String text){
		return text+date;
	}
}

