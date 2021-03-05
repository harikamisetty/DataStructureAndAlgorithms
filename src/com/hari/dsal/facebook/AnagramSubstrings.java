package com.hari.dsal.facebook;

import java.util.Arrays;

public class AnagramSubstrings {
	public int solve(String s0, String s1) {
		if (s0 == null && s1 == null)
			return 0;
		int len = s0.length(), count = 0;

		for (int i = 0; i < s1.length() - len;  i++) {
			if (isAnagram(s0, s1.substring(i, i + len)))
				count++;
		}
		return count;
	}

	private boolean isAnagram(String s0, String s1) {
		char[] ch1 = s0.toCharArray();
		char[] ch2 = s1.toCharArray();
		Arrays.sort(ch1);
		Arrays.sort(ch2);

		String t1 = String.valueOf(ch1);
		String t2 = String.valueOf(ch2);

		return t1.equals(t2);
	}
	
	
	public static void main(String[] args) {
		AnagramSubstrings as = new AnagramSubstrings();
		as.solve("abc", "bcabxabc");
	}
}
