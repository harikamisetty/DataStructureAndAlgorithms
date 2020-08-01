package com.hari.dsal.strings;

import java.util.Arrays;

public class LongestCommonPrefix {

	public static String longestCommonPrefix(String[] strs) {
		if (strs == null || strs.length == 0) {
			return "";
		}

		String longestCommonPrefix = strs[0];

		for (int i = 1; i < strs.length; i++) {
			int j = 0;
			String currentString = strs[i];

			while (j < longestCommonPrefix.length() && j < currentString.length()
					&& longestCommonPrefix.charAt(j) == currentString.charAt(j)) {
				j++;
			}

			if (j == 0) {
				return "";
			}

			longestCommonPrefix = longestCommonPrefix.substring(0, j);
		}

		return longestCommonPrefix;
	}

	// BEST Solution
	public static String longestCommonPrefixds(String[] strs) {

		Arrays.sort(strs);

		char[] chr1 = strs[0].toCharArray();
		char[] chr2 = strs[strs.length - 1].toCharArray();
		StringBuilder res = new StringBuilder("");
		for (int i = 0; i < chr1.length; i++) {
			if (chr1[i] == chr2[i])
				res = res.append(chr1[i]);
		}
		return res.toString();
	}

	public static void main(String[] args) {

		// String []strs =
		// {"howtosolv","howtoproblem","howtoemyname","howtosolv","howtosolvemyname"};
		String[] strs = { "dog", "racecar", "car" };

		System.out.println(longestCommonPrefixds(strs));

	}

}
