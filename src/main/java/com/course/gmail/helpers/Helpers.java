package com.course.gmail.helpers;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Helpers {
	
	public static String getUniqueText(String text) {
		return text + (new SimpleDateFormat("dd-M-yyyy hh:mm:ss")).format(new Date());
	}
}

