package com.hari.dsal.number;

public class DigitMatch {

	public static int digitMatch(int a, int b) {
		if (a < 0 || b < 0) {
			throw new IllegalArgumentException();
		} else if (a == 0 && b == 0) {
			return 1;
		} else {
			int result = 0;
			if (a % 10 == b % 10) {
				result++;
			}
			if (a / 10 == 0 || b / 10 == 0) {
				return result;
			}
			return result + digitMatch(a / 10, b / 10);
		}
	}
	
	
	public static boolean digitToString(int a, int b) {
		
		String s1 = String.valueOf(a);
		String s2 = String.valueOf(b);
		if(s1.equals(s2)) return true;
		return false;		
	}
	public static void main(String[] args) {
		
		System.out.println(digitMatch(2060, 206));
		System.out.println(digitToString(120,124));
	}

}
