package com.hari.dsal.strings.more;

public class StringToInteger {
	
	public static int stringToInteger(String s) {
	    int result = 0;
	    for (int i = 0; i < s.length(); i++) {
	        result = result * 10 + (s.charAt(i) -'0');
	    }
	    return result;
	}
	
	static int reverseStringToInteger(String s) {
	    int result = 0;
	    for (int i = 0; i < s.length(); i++) {
	        result += Math.pow(10, i) * (s.charAt(i) - '0');
	    }
	    return result;
	}
	
	public static void main(String[] args) {
		System.out.println(stringToInteger("12"));
		System.out.println(reverseStringToInteger("236"));
	}
}
