package com.bellar.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class MyDateUtile {
public static void main(String[] args) {
	System.out.println(getPasswordDate());
}
	public static String getPasswordDate() {
	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmm");
	String format = simpleDateFormat.format(new Date());
	return format;
	}
	public static Date getMyFlowDate(int i) {
	Calendar calendar = Calendar.getInstance();
	calendar.add(Calendar.DATE, i);
	return calendar.getTime();
	}

}
