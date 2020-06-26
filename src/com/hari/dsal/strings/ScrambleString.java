package com.hari.dsal.strings;

import java.util.Arrays;

public class ScrambleString {

	public boolean isScramble(String s1, String s2) {
		if (s1.length() != s2.length()) {
			return false;
		}

		if (s1.length() == 1 && s2.length() == 1) {
			if (s1.charAt(0) == s2.charAt(0)) {
				return true;
			} else {
				return false;
			}
		}

		char[] array1 = s1.toCharArray();
		char[] array2 = s2.toCharArray();
		Arrays.sort(array1);
		Arrays.sort(array2);
		if (!Arrays.toString(array1).equals(Arrays.toString(array2))) {
			return false;
		}

		for (int i = 1; i < s1.length(); i++) {
			String s11 = s1.substring(0, i);
			String s12 = s1.substring(i);
			String s21 = s2.substring(0, i);
			String s22 = s2.substring(i);

			if (isScramble(s11, s21) && isScramble(s12, s22)) {
				return true;
			}

			s21 = s2.substring(0, s2.length() - i);
			s22 = s2.substring(s2.length() - i);

			if (isScramble(s11, s22) && isScramble(s12, s21)) {
				return true;
			}
		}

		return false;
	}
	
	public static void main(String[] args) {
		
		String str1 = "rgeat";
		String str2 = "great";
		
		ScrambleString ss= new ScrambleString();
		System.out.println(ss.isScramble(str1, str2));
		
	}
}
