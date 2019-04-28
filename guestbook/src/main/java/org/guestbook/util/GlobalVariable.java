package org.guestbook.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GlobalVariable {

	public static String formatDate(Date date) {
		if(date == null) {
			return null;
		}
		DateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
		return df.format(date);
	}
	
}
