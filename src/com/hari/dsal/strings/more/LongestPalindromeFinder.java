package com.hari.dsal.strings.more;

public class LongestPalindromeFinder {

	public static void main(String[] args) {
		System.out.println(longestPalindromeString("1234"));
		System.out.println(longestPalindromeString("12321"));
		System.out.println(longestPalindromeString("9912321456"));
		System.out.println(longestPalindromeString("9912333321456"));
		System.out.println(longestPalindromeString("12145445499"));
		System.out.println(longestPalindromeString("1223213"));
		System.out.println(longestPalindromeString("abb"));
		
		System.out.println(longestPalindromeString1("1234"));
		System.out.println(longestPalindromeString1("12321"));
		System.out.println(longestPalindromeString1("9912321456"));
		System.out.println(longestPalindromeString1("9912333321456"));
		System.out.println(longestPalindromeString1("12145445499"));
		System.out.println(longestPalindromeString1("1223213"));
		System.out.println(longestPalindromeString1("abb"));
	}

	static public String intermediatePalindrome(String s, int left, int right) {
		if (left > right) return null;
		while (left >= 0 && right < s.length()
				&& s.charAt(left) == s.charAt(right)) {
			left--;
			right++;
		}
		return s.substring(left + 1, right);
	}

	// O(n^2)
	public static String longestPalindromeString(String s) {
		if (s == null) return null;
		String longest = s.substring(0, 1);
		for (int i = 0; i < s.length() - 1; i++) {
			//odd cases like 121
			String palindrome = intermediatePalindrome(s, i, i);
			if (palindrome.length() > longest.length()) {
				longest = palindrome;
			}
			//even cases like 1221
			palindrome = intermediatePalindrome(s, i, i + 1);
			if (palindrome.length() > longest.length()) {
				longest = palindrome;
			}
		}
		return longest;
	}
	
	public static String longestPalindromeString1(String string) { // This is too good ..........................

		String p = "";
		for (int i = 0; i < string.length(); i++) {
			String str = "";
			for (int j = i; j < string.length(); j++) {
				str += string.charAt(j);
				String revStr = new StringBuilder(str).reverse().toString();
				if (string.contains(revStr) && p.length() < revStr.length()) {
					p = revStr;
				}
				if (p.length() == string.length()) {
					break;
				}
			}
		}
		return p;
	}

}

