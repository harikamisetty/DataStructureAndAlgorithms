 package com.hari.dsal.strings;

public class TimeConversion {

	public static void main(String[] args) {

		String time = "03:15:45PM";
		int hour = Integer.parseInt(time.substring(0, 2));
		if (time.charAt(time.length() - 2) == 'P') {
			if (hour != 12)
				hour = hour + 12;
			System.out.println(hour + time.substring(2, time.length() - 2));
		} else {
			if (hour != 12)
				System.out.println(time.substring(0, time.length() - 2));
			else
				System.out.println("00" + time.substring(2, time.length() - 2));
		}
		
		String str = "haribabu";
		System.out.println(str.substring(2,str.length()-2)); 
	}
}
 