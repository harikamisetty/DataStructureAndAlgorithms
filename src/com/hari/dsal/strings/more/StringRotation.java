package com.hari.dsal.strings.more;

public class StringRotation {
	
	public static void main(String[] args) {
		
		String s1 = "waterbottle";
		String x = "wat";
		String y = "erbottle";
		String s2 = y+x;
		
		System.out.println(isStringRotate(s1,s2));
	}

	private static boolean isStringRotate(String s1, String s2) {
		
		int len1 = s1.length();
		if(len1 == s2.length() && len1 > 0) {
			String s1s1 = s1 + s1;
			return s1s1.contains(s2);
		}
		
		return false;
	}
}
