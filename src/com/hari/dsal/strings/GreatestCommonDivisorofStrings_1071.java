package com.hari.dsal.strings;

public class GreatestCommonDivisorofStrings_1071 {

	public String gcdOfStrings(String str1, String str2) {

		if (str1.length() < str2.length())
			return gcdOfStrings(str2, str1);
		if (!str1.startsWith(str2))
			return "";
		if (str2.isEmpty())
			return str1;

		return gcdOfStrings(str2, mod(str1, str2));
	}

	private String mod(String s1, final String s2) {

		while (s1.startsWith(s2))
			s1 = s1.substring(s2.length());
		return s1;
	}

	// SOLUTION 2
	public String gcdOfStrings_2(String str1, String str2) {
		if (str1.length() < str2.length()) {
			String temp = str1;
			str1 = str2;
			str2 = temp;
		}
		if (str2.length() == 0) {
			return str1;
		} else {
			String remainder = getRemainder(str1, str2);
			// if remainder would be empty if str2 is not found in str1, but since it could
			// also mean str1 = str2
			if (remainder.length() == 0 && !str1.equals(str2)) {
				return "";
			}
			return gcdOfStrings(str2, remainder);
		}
	}

	private String getRemainder(String str1, String str2) {
		// if smaller one not start with index 0 of bigger string, then there is no
		// common divisor
		return str1.indexOf(str2) == 0 ? str1.substring(str2.length()) : "";
	}

	public static void main(String[] args) {
		GreatestCommonDivisorofStrings_1071 gcd = new GreatestCommonDivisorofStrings_1071();
		System.out.println(gcd.gcdOfStrings("ABCABCABC", "ABCABC"));
	}
}
