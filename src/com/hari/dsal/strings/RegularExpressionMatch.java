package com.hari.dsal.strings;

public class RegularExpressionMatch {

	public boolean isMatch(String s, String p) {
		if (s == null || p == null)
			return false;

		int i = 0, j = 0;

		while (i < s.length() && j < p.length()) {

			if ((s.charAt(i) == p.charAt(j)) || (p.charAt(j) == '?')) {
				i++;
				j++;
			} else if (p.charAt(j) == '*') {
				i++;
			}
		}

		if (j == p.length() - 1)
			j++;

		if (i == s.length() - 1 && j == p.length() - 1)
			return true;
		return false;
	}

	public static void main(String[] args) {
		RegularExpressionMatch rem = new RegularExpressionMatch();
		String s = "aa", p = "a*";
		System.out.println(rem.isMatch(s, p));
	}

}
