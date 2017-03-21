package org.jboss.test.drools.cep.demo.model;

import java.util.Calendar;
import java.util.Date;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calendar cal = Calendar.getInstance();
		Date date1 = cal.getTime();
		
		
		Calendar cal2 = Calendar.getInstance();
		cal2.add(Calendar.HOUR,2);
		Date date2 = cal2.getTime();
		
		long diff = date2.getTime() - date1.getTime();
		int hours = (int)diff / (60*1000);
		
		System.out.println(hours);
		
		
//		java.text.DateFormat df = new java.text.SimpleDateFormat("hh");
//        java.util.Date date1 = df.parse(this.startDate);
//        java.util.Date date2 = df.parse("19:05:15");
//        long diff = date2.getTime() - date1.getTime();

	}

}
